package csw.java.data.structure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/19
 */
public class LinkedBinaryTree implements IBinaryTree {

    private Node root;

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {

        this.root = root;
    }

    @Override
    public int size() {
        System.out.println("二叉树结点个数为:");
        return size(root);
    }

    public int size(Node node) {
        if (node == null)
            return 0;
        return size(node.leftChild) + size(node.rightChild) + 1;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getHeight() {
        System.out.println("二叉树高度为:");
        return this.getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return Math.max(getHeight(node.rightChild), getHeight(node.leftChild)) + 1;
    }

    @Override
    public Node findKey(Object value) {
        return this.finfKey(value, root);
    }

    private Node finfKey(Object value, Node node) {
        if (node == null) {
            return null;
        } else if (node.value.equals(value)) {
            return node;
        } else {
            Node node1 = this.finfKey(value, node.leftChild);
            Node node2 = this.finfKey(value, node.rightChild);
            if (node1 != null && node1.value.equals(value)) {
                return node1;
            }
            if (node2 != null && node2.value.equals(value)) {
                return node2;
            }
            return null;
        }
    }

    @Override
    public void preOrderTraverse() {
        if (root != null) {
            System.out.print(root.value + " ");
            IBinaryTree left = new LinkedBinaryTree(root.leftChild);
            left.preOrderTraverse();
            IBinaryTree right = new LinkedBinaryTree(root.rightChild);
            right.preOrderTraverse();
        }

    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历");
        this.inOrderTraverse(root);
        System.out.println();

    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            this.inOrderTraverse(node.leftChild);
            System.out.print(node.value + " ");
            this.inOrderTraverse(node.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.println("后序遍历");
        this.postOrderTraverse(root);
        System.out.println();
    }


    private void postOrderTraverse(Node node) {
        if (node != null) {
            this.postOrderTraverse(node.leftChild);
            this.postOrderTraverse(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    @Override
    public void preOrderByStack() {
        System.out.println("二叉树先序遍历非递归:");
        if (root == null) return;
        java.util.Deque<Node> stack = new LinkedList<>();

        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.value + " ");
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                Node tmp = stack.pop();
                current = tmp.rightChild;
            }
        }

        System.out.println();

    }

    @Override
    public void inOrderByStack() {
        System.out.println("二叉树中序遍历非递归:");
        if (root == null) return;
        java.util.Deque<Node> stack = new LinkedList<>();

        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.rightChild;
            }
        }

        System.out.println();


    }

    @Override
    public void postOrderByStack() {
        System.out.println("二叉树后序遍历非递归:");
        if (root == null) return;
        java.util.Deque<Node> stack = new LinkedList<>();

        Node current = root;
        Set<Node> flag = new HashSet<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                Node tmp = stack.peek();
                if (tmp.rightChild != null && !flag.contains(tmp)) {
                    current = tmp.rightChild;
                    flag.add(tmp);
                } else {
                    tmp = stack.pop();
                    System.out.print(tmp.value + " ");
                    current = null;
                }

            }
        }

        System.out.println();
    }

    @Override
    public void levelOrderByStack() {
        System.out.println("二叉树层次遍历:");
        if (root == null) return;
        java.util.Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                System.out.print(tmp.value + " ");
                queue.add(tmp.leftChild);
                queue.add(tmp.rightChild);
            }
        }
        System.out.println();

    }
}
