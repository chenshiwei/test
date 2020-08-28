package csw.java.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作用:
 *
 * @author chensw
 * @since 2020/5/21
 */

public class DeleteTest {

    // 指定文件保存的位置
    private final String savePath = "F:/tmp/";
    // 查询并删除所有今天生成的文件
    public int deleteFile() {
        int number = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        File file = new File(savePath);
        // list():指定此抽象路径名表示的目录中的文件和目录
        // 除非是空目录，才能删除，否则是假删除，实际没有被删除
        String[] templist = file.list();
        System.out.println(templist);
        File temp = null;
        for (String aTemplist : templist) {
            // path完整路径： c:/a/20180313abc.txt
            String path = savePath + aTemplist;
            temp = new File(path);
            // startsWith：用来检测某字符串是否以另一个字符串开始
            if (temp.getName().startsWith(date)) {
                System.out.println(temp.getName());
                temp.delete();
                number++;
            }
        }
        return number;
    }
    public static void main(String[] args) {
        DeleteTest deleteTest = new DeleteTest();
        int n = deleteTest.deleteFile();
        System.out.println("删除文件的个数为：" + n);
    }
}
