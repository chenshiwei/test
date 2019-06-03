package csw.java.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String regex = "\\w(\\d\\d)(\\w+)";
        String candidate = "x99SuperJava";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(candidate);
        if (matcher.find()) {
            int gc = matcher.groupCount();
            for (int i = 0; i <= gc; i++)
                System.out.println("group " + i + " : "
                    + matcher.group(i));
        }
        // 生成一个Pattern,同时编译一个正则表达式
        Pattern p2 = Pattern.compile("[/]+");
        //用Pattern的split()方法把字符串按"/"分割
        String[] result = p2.split(
            "Kevin has seen《LEON》seveal times,because it is a good film."
                + "/ 凯文已经看过《这个杀手不太冷》几次了，因为它是一部"
                + "好电影。/名词:凯文。");
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

}
