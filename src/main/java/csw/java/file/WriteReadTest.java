package csw.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteReadTest {

	public static void main(String[] args) {
		File file = new File("src/main/resources/readTest");
		try (FileWriter bos = new FileWriter(new File("src/main/resources/writeTest"));
				BufferedWriter bw = new BufferedWriter(bos);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			StringBuilder sb = new StringBuilder("");
			while ((line = br.readLine()) != null) {
				String[] a = line.split(",");
				sb.append(a[0]).append("++").append(a[1]).append("\n");
			}
			bw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
