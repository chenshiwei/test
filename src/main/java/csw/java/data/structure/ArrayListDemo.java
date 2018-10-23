package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
public class ArrayListDemo {
  public static void main(String[] args) {
    List list = new ArrayList();
    java.util.LinkedList ll;
    list.add(4);
    list.add(9);
    list.add(5);
    list.add(7);
    list.add(65);
    System.out.println(list.size());
    list.add(3, 544);
    System.out.println(list.isEmpty());
    System.out.println(list.get(2));
    System.out.println(list);
    System.out.println(System.currentTimeMillis());
  }
}
