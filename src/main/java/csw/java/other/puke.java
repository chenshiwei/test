package csw.java.other;

import java.util.HashSet;
import java.util.Set;

public class puke {
    private static Set<String> s24 = new HashSet<>();

    public static void main(String[] args) {
        char c[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
        System.out.println("随即抽取4张纸牌:");
        double num2[] = {1,5,5,5};
        pailie(num2, 0);
        System.out.println(num2[0] + " " + num2[1] + " " + num2[2] + " " + num2[3]);
        for (String aS24 : s24) {
            System.out.println(aS24);
        }
    }

    //因为要列举出所有情况 所以这4个数不同的组合也要列举出来 然后每组4个数 不停的去做+-*/运算
    private static void pailie(double[] num, int index) {
        if (index == num.length) {
            f(num, 0, 0, "", "");
//System.out.println(num[0]+" "+num[1]+" "+num[2]+" "+num[3]);
        } else if (index < num.length) {
            for (int i = index; i < num.length; i++) {
                double temp = num[index];
                num[index] = num[i];
                num[i] = temp;
                pailie(num, index + 1);
                temp = num[index];
                num[index] = num[i];
                num[i] = temp;
            }
        }
    }

    //以下代码则是例举出当前顺序的4个数 +-*/是否为24点  感觉相当于全排列
    public static void f(double[] num, int count, double sum, String s, String s2) {
        if (count == 4) {
            if (Math.abs(sum - 24)<0.0001) {
                s24.add(s2);
//System.out.println(s2);
            }
        } else {
            if (count == 0) {
                s2 += num[count];
                sum = num[count++];
            } else {
                s2 += s + num[count];
                switch (s) {
                    case "+":
                        if (count <= 2) {//如果当前第1个或第2个是加减
                            s2 = "(" + s2 + ")";
                        }
                        sum += num[count++];
                        break;
                    case "-":
                        if (count <= 2) {//如果当前第1个或第2个是加减
                            s2 = "(" + s2 + ")";
                        }
                        sum -= num[count++];
                        break;
                    case "*":
                        sum *= (num[count++] * 1.0);
                        break;
                    case "/":
                        sum /= (num[count++] * 1.0);
                        break;
                }
            }
            f(num, count, sum, "+", s2);
            f(num, count, sum, "-", s2);
            f(num, count, sum, "*", s2);
            f(num, count, sum, "/", s2);
        }
    }
}