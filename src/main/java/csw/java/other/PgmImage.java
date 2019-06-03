package csw.java.other;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class PgmImage {

    @SuppressWarnings("unused")
    private final static String TAG = "PgmImage";

    public final static String MAGIC_NUMBER = "P5";
    public final static AtomicBoolean decodeFromBitmapCancelled = new AtomicBoolean(false);
    public final static AtomicBoolean isDecodingFromBitmap = new AtomicBoolean(false);
    private int width, height;
    private int maxVal;

    /**
     * the pixel values used to represent the image
     */
    private byte[] content;

    /**
     * export the PGM object to OutputStream
     *
     * @param os the stream that the PGM image bytes will be written to
     * @return true if the PGM image is exported successfully, otherwise false
     */
    public boolean save(OutputStream os) {
        if (os == null) {
            throw new IllegalArgumentException("output stream is not allowed null");
        }
        boolean noerror = true;
        try {
            os.write(MAGIC_NUMBER.getBytes()); // write magic number
            os.write(0x0A);// write LF 换行符
            os.write(intToBytes(width));
            os.write(0x20);// write SPACE 空格
            os.write(intToBytes(height));
            os.write(0x0A);// write LF 换行符
            os.write(intToBytes(maxVal));
            os.write(0x0A); // write LF 换行符
            os.write(content);
        } catch (IOException e) {
            noerror = false;
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return noerror;
    }

    public static void cancelDecodeFromBitmap() {
        decodeFromBitmapCancelled.set(true);
    }

    /**
     * create PgmImage object from an existing PGM image file
     *
     * @param file the PGM image file object. PGM image with comment is not
     *             supported
     * @return PgmImage object if successful, otherwise null
     */
    public static PgmImage fromFile(File file) {
        boolean error = false;
        if (file == null) {
            return null;
        }
        if (file.exists() && file.isFile()) {
            if (file.length() < 1024) {
                return null;
            }
        } else {
            return null;
        }
        InputStream fis = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            error = true;
        }
        if (error) {
            return null;
        } else {
            if (fis != null) {
                PgmImage pgm = new PgmImage();
                byte[] buffer = new byte[20];// store pgm head, 20 bytes are
                // sufficient;
                /**
                 * read PGM file head begin
                 */
                try {
                    int bufferSize = fis.read(buffer);
                    int start, end;
                    // magic number OK
                    if (buffer[0] == 'P' && buffer[1] == '5') {
                        end = start = 3;
                        // read width
                        while (end < bufferSize && !isWhiteSpace(buffer[end]))
                            ++end;
                        if (end >= bufferSize || start == end) {
                            error = true;
                        } else {
                            int width = bytesToInt(buffer, start, end);
                            if (width > 0) {
                                pgm.width = width;
                                end = start = end + 1;// skip whitespace
                                // read height
                                while (end < bufferSize && !isWhiteSpace(buffer[end]))
                                    ++end;
                                if (end >= bufferSize || start == end) {
                                    error = true;
                                } else {
                                    int height = bytesToInt(buffer, start, end);
                                    if (height > 0) {
                                        pgm.height = height;
                                        end = start = end + 1;
                                        // read max gray value,255
                                        while (end < bufferSize && !isWhiteSpace(buffer[end]))
                                            ++end;
                                        if (end >= bufferSize || start == end) {
                                            error = true;
                                        } else {
                                            int maxVal = bytesToInt(buffer, start, end);
                                            if (maxVal > 0 && maxVal < 256) {
                                                pgm.maxVal = maxVal;
                                                int contentLengthCalc = width * height;
                                                // move to the first byte of PGM
                                                // image content
                                                ++end;
                                                int contentLengthActual = (int) file.length() - end;
                                                if (contentLengthCalc == contentLengthActual) {
                                                    byte[] content = new byte[contentLengthActual];
                                                    // copy the bytes remained
                                                    // in buffer
                                                    for (int i = end; i < buffer.length; i++) {
                                                        content[i - end] = buffer[i];
                                                    }
                                                    fis.read(content, buffer.length - end, contentLengthActual - buffer.length + end);
                                                    pgm.content = content;
                                                    /**
                                                     * read pgm image file end
                                                     */
                                                } else {
                                                    error = true;
                                                }
                                            } else {
                                                error = true;
                                            }
                                        }
                                    } else {
                                        error = true;
                                    }
                                }
                            } else {
                                error = true;
                            }
                        }
                    } else {
                        error = true;
                    }
                } catch (IOException e) {
                    error = true;
                } finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (error) {
                    return null;
                } else {
                    return pgm;
                }
            } else {
                return null;
            }
        }
    }

    private static boolean isWhiteSpace(byte i) {
        return i == 0x20 || i == 0x09 || i == 0x0A | i == 0x0D;
    }

    private static int bytesToInt(byte[] bytes, int start, int end) {
        if (bytes != null && start < end && start >= 0 && end <= bytes.length) {
            String ts = new String(bytes, start, end - start);
            Integer ti = Integer.valueOf(ts);
            return ti.intValue();
        } else {
            new IllegalArgumentException("invalid parameter, byte array length:" + bytes.length + ", start index(inc):"
                + start + ", end index(exc):" + end);
        }
        return -1;
    }

    /**
     * convert integer to byte arrays. Every bit of intt in decimal occupies one
     * byte, from highest to lowest
     *
     * @param intt a positive integer
     * @return the byte array, the first byte in the array corresponds to the
     * highest bit of intt in decimal
     */
    private byte[] intToBytes(int intt) {
        if (intt <= 0) {
            throw new IllegalArgumentException("only positive integer is allowed");
        }
        // byte[] temp = new byte[11];
        // int count = 0;
        // while (intt > 0) {
        // temp[count] = (byte) (intt % 10 + 48);
        // intt /= 10;
        // ++count;
        // }
        // byte[] result = new byte[count];
        // --count;
        // for (int i = 0; i <= count; ++i) {
        // result[count - i] = temp[i];
        // }
        // return result;
        return String.valueOf(intt).getBytes();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public byte[] getContent() {
        return content;
    }
}