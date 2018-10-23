package csw.java.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/7
 */
public class TestOut {
    public static void main(String[] args) throws Exception{
        File file = new File("stu.db");
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        Student s1 = new Student(1, "niu", "868");
//        oos.writeObject(People.apply(1,"csw"));
        oos.flush();
        oos.close();
        out.close();
    }
}
