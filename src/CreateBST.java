class Node {
    int data;
    Node left;
    Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    Node(int data) {
        this.data=data;
        this.left=this.right=null;
    }
}

public class CreateBST {

    Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        Node temp = null;
        if(root.data < data) {
            temp = insert(root.right, data);
            root.right = temp;
        } else {
            temp = insert(root.left, data);
            root.left = temp;
        }
        return root;
    }


    void inorderTraversal(Node root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + " : ");
        inorderTraversal(root.right);
    }

    void preorderTraversal(Node root) {

        if(root == null)
            return;
        System.out.print(root.data + " : ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);

    }

    //wrong approach
    boolean checkIfBST(Node root) {
        if(root == null)
            return true;

        if(root.left != null && root.data < root.left.data)
            return false;
        if(root.right != null && root.data >= root.right.data)
            return false;

        if(!checkIfBST(root.left) || !checkIfBST(root.right)) {
            return false;
        }
        return true;
    }

    //right but inefficient approach to check BST - traversing same nodes multiple times

    boolean checkIfBST2(Node root) {
        if( root == null )
            return true;

        if(root.left != null && maxValue(root.left) > root.data)
            return false;
        if(root.right != null && minValue(root.right) < root.data)
            return false;

        if(!checkIfBST2(root.left) || !checkIfBST2(root.right))
            return false;

        return true;
    }

    int maxValue(Node root) {
        if(root != null) {
            while (root.right != null)
                root = root.right;

            return root.data;
        }
        return 0;
    }

    int minValue(Node root) {
        if(root != null) {
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }
        return 0;
    }


    //right with efficient approach

    boolean checkIfBST3(Node root) {
        int min = minValue(root); // or Integer.MIN_VALUE
        int max = maxValue(root);// or Integer.MAX_VALUE
        return checkIfBST3MinMAX(root, min, max);
    }

    boolean checkIfBST3MinMAX(Node root, int min, int max) {
        if(root == null)
            return true;

        if(root.data < min || root.data > max)
            return false;

        return (checkIfBST3MinMAX(root.left, min, root.data - 1) && checkIfBST3MinMAX(root.right, root.data +1, max));
    }

    public static void main(String[] args) {
        CreateBST bst = new CreateBST();
        Node root = null;
        root = bst.insert(root, 5);
        root = bst.insert(root, 2);
        root = bst.insert(root, 3);
        root = bst.insert(root, 4);
        root = bst.insert(root, 6);
        root = bst.insert(root, 8);
        root = bst.insert(root, 7);
        bst.inorderTraversal(root);
        System.out.println();
        bst.preorderTraversal(root);
        System.out.println(bst.checkIfBST(root));
       // System.out.println("ROOT is "  + root.getData() + "  : " +  root.left.right.right.getData() + "   " + root.right.getData() + "  " + root.right.right.left.getData());
    }
}
