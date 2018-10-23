package csw.java.data.structure;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/19
 */
public class BinaryTreeTest {
  public static void main(String[] args) {
    // 创建二叉树
    Node node11 = new Node(11, null, null);
    Node node10 = new Node(10, null, null);
    Node node8 = new Node(8, null, null);
    Node node9 = new Node(9, node10, null);
    Node node5 =new Node(5, node8, node9);
    Node node4 =new Node(4, null, node5);
    Node node3 =new Node(3, null, null);
    Node node7 =new Node(7, node11, null);
    Node node6 =new Node(6, null, node7);
    Node node2 =new Node(2, node3, node6);
    Node node1 =new Node(1, node4, node2);

    IBinaryTree bt = new LinkedBinaryTree(node1);
    IBinaryTree bt2 = new LinkedBinaryTree();

    // 判断非空

    System.out.println(bt.isEmpty());
    System.out.println(bt2.isEmpty());

    // 先序遍历 1 4 5 2 3 6 7
    System.out.println("先序遍历");
    bt.preOrderTraverse();
    System.out.println();

    bt.preOrderByStack();
    // 中序遍历 4 5 1 3 2 6 7
    bt.inOrderTraverse();

    // 中序遍历非递归(栈) 4 5 1 3 2 6 7
    bt.inOrderByStack();

    // 后序遍历 5 4 3 7 6 2 1
    bt.postOrderTraverse();

    bt.postOrderByStack();

    // 层次遍历(队列) 1 4 2 5 3 6 7
    bt.levelOrderByStack();

    // 查找结点
    System.out.println(bt.findKey(7));

    // 二次树高度
    System.out.println(bt.getHeight());

    // 二次树结点个数
    System.out.println(bt.size());
  }
}
