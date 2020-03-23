package Amazon.Trees;

class Node1 {
    int data;
    Node1 left, right;

    public Node1(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {

    static Node1 root;

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.right.right = new Node1(4);
    }
}

public class LeftView {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int maxLevel = 0;

    void printLeftView(Node root, int level) {

        if(root == null) {
            return;
        }

        if(level > maxLevel) {
            maxLevel = level;
            System.out.print(root.data + " ");
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }



    void leftView(Node root) {
        printLeftView(root, 1);
    }

    void printBottomView(Node root) {
        if(root.right == null && root.left == null) {
            System.out.print(root.data + " ");
            return;
        }

        printBottomView(root.left);
        printBottomView(root.right);

    }

    void bottomView(Node root) {
        printBottomView(root);
    }




    int isBST(Node root) {

        if(checkIfMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return 1;
        else
            return 0;
    }

    boolean checkIfMax(Node root, int min, int max) {
        if(root == null)
            return  true;

        if(root.data > min || root.data < max)
            return false;

        return checkIfMax(root.left, min, root.data - 1) && checkIfMax(root.right, root.data + 1, max);
    }



}
