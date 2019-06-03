package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/18
 */
@SuppressWarnings("unused")
public interface IBinaryTree {

    int size();

    boolean isEmpty();

    int getHeight();

    Node findKey(Object value);

    void preOrderTraverse();

    void inOrderTraverse();

    void postOrderTraverse();

    void preOrderByStack();

    void inOrderByStack();

    void postOrderByStack();

    void levelOrderByStack();
}

class Node {
    Object value;
    Node leftChild;
    Node rightChild;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", leftChild=" + leftChild +
            ", rightChild=" + rightChild +
            '}';
    }
}
