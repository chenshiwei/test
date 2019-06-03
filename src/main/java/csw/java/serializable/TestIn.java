package csw.java.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/7
 */
public class TestIn {
    public static void main(String[] args) throws Exception {
        File file = new File("stu.db");
        InputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object obj = ois.readObject();
//        Student stu = (Student) obj;
//        People people =(People) obj;
        System.out.println(obj);
//        System.out.println(people);
    }
}
