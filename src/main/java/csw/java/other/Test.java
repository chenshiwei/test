package csw.java.other;

import java.util.*;
import java.util.stream.IntStream;

public class Test {


  public static void main(String[] args) {
//获取数字的个数、最小值、最大值、总和以及平均值
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    IntStream a = primes.stream().mapToInt((x) -> x);
    IntSummaryStatistics stats = a.summaryStatistics();
    System.out.println("Highest prime number in List : " + stats.getMax());
    System.out.println("Lowest prime number in List : " + stats.getMin());
    System.out.println("Sum of all prime numbers : " + stats.getSum());
    System.out.println("Average of all prime numbers : " + stats.getAverage());
    System.out.println(stats);

    class foo {
      @Override
      public String toString(){
          return "caocao";
      }
    }

    List list= new ArrayList();
    list.add(1);
    list.add(new Date());
    list.add("cao");
    list.add(new foo());

    System.out.println(list.get(1));
    System.out.println(list);
    System.out.println(list.get(3));

  }

}
