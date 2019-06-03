package csw.java.data.structure;

import java.util.Arrays;

/**
 * 作用: 顺序表
 *
 * @author chensw
 * @since 2018/9/18
 */
public class ArrayList implements List {

    private Object[] elemectData;
    private int size;

    private ArrayList(int initCapacity) {
        elemectData = new Object[initCapacity];
    }

    ArrayList() {
        this(4);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new RuntimeException("异常");
        return elemectData[index];
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
        if (size == elemectData.length) {
//      Object[] newArr = new Object[elemectData.length * 2];
//      System.arraycopy(elemectData, 0, newArr, 0, size);
//      elemectData = newArr;
            elemectData = Arrays.copyOf(elemectData, elemectData.length * 2);
        }
        for (int i = size; i > index; i--) {
            elemectData[i] = elemectData[i - 1];
        }
        elemectData[index] = element;
        size++;
    }

    @Override
    public void add(Object e) {
        if (size == elemectData.length) {
//      Object[] newArr = new Object[elemectData.length * 2];
//      System.arraycopy(elemectData, 0, newArr, 0, size);
//      elemectData = newArr;
            elemectData = Arrays.copyOf(elemectData, elemectData.length * 2);
        }
        elemectData[size] = e;
        size++;
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
        for (int i = 0; i < size; i++) {
            if (i != size - 1)
                sb.append(elemectData[i]).append(",");
            else
                sb.append(elemectData[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
