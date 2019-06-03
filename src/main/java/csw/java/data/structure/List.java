package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
@SuppressWarnings("unused")
public interface List {

    int size();

    Object get(int index);

    boolean isEmpty();

    boolean contains(Object o);

    int indexOf(Object o);

    void add(int index, Object element);

    void add(Object e);

    Object remove(int index);

    boolean remove(Object o);

    Object replace(int index, Object element);

}

