package csw.java.data.structure;

import java.util.Random;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/5
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(14);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(13);
        binaryTree.print();
        System.out.println();
        Random rand = new Random();
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < 20; i++) {
            bt.add(rand.nextInt(1000));
        }
        bt.print();
        System.out.println();

    }
}
