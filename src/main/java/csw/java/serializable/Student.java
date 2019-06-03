package csw.java.serializable;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/7
 */
public class Student {
    private int id;
    private String name;
    private String pass;

    public Student(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pass='" + pass + '\'' +
            '}';
    }
}
