package csw.java.data.structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
public class ConvertDemo {
  public static void main(String[] args) {
    int n = 13;
    int t = n;
    Deque stack = new LinkedList();
//    String str = "";
    do {
      int mod = t % 2;
      stack.push(mod);
//      str = mod + str;
      t /= 2;
    } while (t > 0);

    System.out.print(n + " -> ");
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }
}
