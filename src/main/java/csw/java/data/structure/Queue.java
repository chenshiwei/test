package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
@SuppressWarnings("unused")
public interface Queue {

  int size();

  boolean isEmpty();

  Object dequeue();

  Object peek();

  void enqueue(Object o);

}

