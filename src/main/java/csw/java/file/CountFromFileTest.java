package csw.java.file;

import java.io.*;

public class CountFromFileTest {

    public static void main(String[] args) {

        File file = new File("src/main/resources/readTest");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter bos = null;
        BufferedWriter bw = null;
        try {
            bos = new FileWriter(new File("src/main/resources/result"));
            bw = new BufferedWriter(bos);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                bw.write(line);
            }
            System.out.println(line);
            System.out.println(count);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
