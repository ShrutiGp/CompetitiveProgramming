package Amazon.Trees;

import java.util.*;

public class BinaryTree1 {

    Node root;
    static int max_level = 0;

    static class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int data) {
            this.data = data;
            hd = Integer.MAX_VALUE;
            this.left = this.right = null;
        }
    }

    void printLeftView(Node root, int level) {

        if(root == null) {
            return;
        }

        if(level > max_level) {
            max_level = level;
            System.out.println("NODE " + root.data);
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    void leftView() {
        printLeftView(root, 1);
    }

    void printBottomView() {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        root.hd = 0;
        queue.add(root);
        TreeMap treeMap = new TreeMap<Integer, Integer>();


        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node != null) {
                treeMap.put(node.hd, node.data);
            }

            if(node.left != null) {
                node.left.hd = node.hd - 1;
                queue.add(node.left);
            }

            if(node.right != null) {
                node.right.hd = node.hd + 1;
                queue.add(node.right);
            }
        }

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static boolean checkIfBST(Node root, int min, int max) {
        if(root == null)
            return true;

        if(min > root.data || max < root.data) {
            return false;
        }

        return checkIfBST(root.left, min, root.data - 1) && checkIfBST(root.right, root.data + 1, max);
    }

    void printLevelOrderTraversal() {
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.remove();

            System.out.println("NOde : " + temp.data);

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    boolean isSymmetric(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.data != root2.data) {
            return false;
        }

        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    int height(Node root) {
        if(root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
    }

    boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        return Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int countLeaves(Node root) {

        if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
            System.out.println("Leaf " + root.data);
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        BinaryTree1 tree = new BinaryTree1();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.left.right = new Node(27);
        tree.root.right.left.left = new Node(22);
        tree.root.right.right = new Node(35);

        BinaryTree1 tree1 = new BinaryTree1();
        tree1.root = new Node(12);
        tree1.root.left = new Node(10);
        tree1.root.right = new Node(10);
        tree1.root.right.left = new Node(3);
        tree1.root.right.right = new Node(4);
        tree1.root.right.left = new Node(4);
        tree1.root.right.right = new Node(3);

      //  tree.leftView();

     //   tree.printBottomView();
        System.out.println("LEAVES " + tree.countLeaves(tree.root));
//        tree.printLevelOrderTraversal();
//        System.out.println(tree.height(tree.root));
//        boolean isSymmetric = tree1.isSymmetric(tree1.root, tree1.root);
//        System.out.println("is Symmetric " + isSymmetric);
//        boolean isBSt = checkIfBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        System.out.println(isBSt);
    }


}
