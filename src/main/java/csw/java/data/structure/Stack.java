package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
@SuppressWarnings("unused")
public interface Stack {

  int size();

  boolean isEmpty();

  Object pop();

  Object peek();

  void push(Object o);

}

