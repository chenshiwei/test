package csw.java.data.structure;

public class BinaryTree {

    private Node root;

    public void add(int data) {
        if (root != null) {
            root.addNode(data);
        } else {
            root = new Node(data);
        }
    }

    public void print() {
        root.printNode();
    }


    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void addNode(int data) {
            if (this.data > data) {
                if (this.left != null) {
                    this.left.addNode(data);
                } else {
                    this.left = new Node(data);
                }
            } else {
                if (this.right != null) {
                    this.right.addNode(data);
                } else {
                    this.right = new Node(data);
                }
            }
        }

        public void printNode() {
            if (this.left != null) {
                this.left.printNode();
            }
            System.out.print(this.data+"->");
            if (this.right != null) {
                this.right.printNode();
            }
        }
    }
}
