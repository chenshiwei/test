package csw.java.file;

import java.io.File;

public class FileListTest {
    public static void main(String[] args) {
        File f = new File("E:\\MavenProject\\test");
        System.out.println(f.getName());
        list(f, 0);
    }

    private static void list(File f, int lv) {
        File[] children = f.listFiles();
        if (children != null)
            for (int i = 0; i < children.length; i++) {
                for (int j = 0; j < lv; j++) System.out.print("┃");
                if (i == children.length - 1) System.out.println("┗" + children[i].getName());
                else System.out.println("┣" + children[i].getName());
                if (children[i].isDirectory()) list(children[i], lv + 1);
            }
    }

}
