package csw.java.other;

import java.io.File;

public class PgmImageTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("");
		// for(int c=1;c<=10304;c++){
		// sb.append(c).append(",");
		// }
		// sb.append("\n");

			for (int p = 1; p <= 10; p++) {
				for (int s = 1; s <= 40; s++) {
				PgmImage a = PgmImage.fromFile(new File("src/main/resources/att_faces/s" + s + "/" + p + ".pgm"));
//				int height = a.getHeight();
//				int width = a.getWidth();
				byte[] b = a.getContent();
				for (int i = 0; i < b.length; i++) {
					if (b[i] < 0) {
						sb.append(b[i]+128).append(",");
					} else {
						sb.append(b[i]+128).append(",");
					}
				}
				// sb.append("face");
				sb.append(s-1).append("\n");
				// sb.deleteCharAt(sb.lastIndexOf(",")).append("\n");
			}

		}
		System.out.println(sb);
	}

}