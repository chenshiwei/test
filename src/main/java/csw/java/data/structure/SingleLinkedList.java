package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
public class SingleLinkedList implements List {

  class Node {
    Object data;
    Node next;

    public Node(Object data, Node next) {
      this.data = data;
      this.next = next;
    }

    public Node(Object data) {
      this.data = data;
    }

    public Node() {
    }

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }


  private Node head = new Node();
  private int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public Object get(int index) {
    Node p = head;
    for (int i = 0; i <= index; i++) {
      p = p.next;
    }
    return p.data;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public void add(int index, Object element) {

    Node p = head;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }
    Node newNode = new Node(element);
    newNode.next = p.next;
    p.next = newNode;
    size++;

  }

  @Override
  public void add(Object e) {
    this.add(size, e);
  }

  @Override
  public Object remove(int index) {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public Object replace(int index, Object element) {
    return null;
  }

  @Override
  public String toString() {
    if (size == 0) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    Node p = head.next;
    for (int i = 0; i < size; i++) {
      if (i != size - 1)
        sb.append(p.data).append(",");
      else
        sb.append(p.data);
      p = p.next;
    }
    sb.append("]");
    return sb.toString();
  }
}
