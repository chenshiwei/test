package csw.java.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteReadTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter p= new PrintWriter("F:\\MavenProject\\test\\src\\main\\resources\\writeTest");
		p.println("wo cao");
		p.flush();
		p.close();
	}
}
