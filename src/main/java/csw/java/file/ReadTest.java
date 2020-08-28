package csw.java.file;

import java.io.*;

/**
 * 作用:
 *
 * @author chensw
 * @since 2019/12/20
 */
public class ReadTest {
    public static void main(String[] args) {
        File file = new File("F:\\DATA\\uyun-netalert-2020.05.06.json");
        try (             FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line = "";
            int i=0;
            while (i<10) {
                line = br.readLine();
                System.out.println(line);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
