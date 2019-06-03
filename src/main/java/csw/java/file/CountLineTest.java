package csw.java.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountLineTest {
    static BufferedReader BR = null;
    static long Count = 0;

    public static void main(String[] args) throws IOException {
        Trvs(new File("D:\\workspace\\ai"));
        System.out.print(Count);
    }

    static void Trvs(File f) throws IOException {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            if (childs[i].isFile()) {
                if (childs[i].getName().endsWith(".scala") || childs[i].getName().endsWith(".java")) {
                    BR = new BufferedReader(new FileReader(childs[i]));
                    while (BR.readLine() != null)
                        Count += 1;
                }
            } else
                Trvs(childs[i]);
        }
    }
}