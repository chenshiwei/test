package csw.java.model.single;

public class Student {
	private Student() {
	}

	private static Student student = new Student();
	
	public static Student getStudent() {
		return student;
	}
	
	public void show(){
		System.out.println("I cao!");
	}

}
