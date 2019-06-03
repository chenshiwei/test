package csw.java.model.single;

public class Teacher {
    private Teacher() {
    }

    private static Teacher teacher;

    public static Teacher getTeacher() {
        if (teacher == null) {
            teacher = new Teacher();
        }
        return teacher;
    }

    public void love() {
        System.out.println("I love you!");
    }

}
