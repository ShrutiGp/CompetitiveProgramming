//package Amazon;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//class Nodes {
//    int data;
//    Nodes left;
//    Nodes right;
//    public Nodes(int p) {
//        data = p;
//        left = right = null;
//    }
//
//    public String toString() {
//        return "left " + left.data + "   right " +right.data +   " data : " +data;
//    }
//}
//
//class BST {
//    int array[];
//    int num;
//
//    public BST(int array[], int num) {
//        this.array = array;
//        this.num = num;
//    }
//}
//public class InroderSuccessor {
//
//    static int isBST(Nodes root) {
//        if(root.left !=null && (root.data >= root.left.data))
//            return isBST(root.left);
//        else if(root.right != null && (root.data < root.right.data))
//            return isBST(root.left);
//        else
//            return 0;
//
//        return 1;
//
//        System.out.println("root1 " + root.data);
//        if(root != null && (root.left != null || root.right != null)) {
//            if(root.left !=null && (root.data < root.left.data)){
//                return 0;
//            } else {
//                isBST(root.left);
//            }
//            if(root.right != null && (root.data > root.right.data))
//                return 0;
//            else {
//                isBST(root.right);
//            }
//        }
//
//        return 1;
//    }
//
//    static  Nodes insert(Nodes root, int data) {
//        if(root == null) {
//            return new Nodes(data);
//        } else {
//                Nodes temp = null;
//               if(data <= root.data) {
//                   temp = insert(root.left, data);
//                   root.left = temp;
//               } else {
//                   temp = insert(root.right, data);
//                   root.right = temp;
//               }
//            return root;
//        }
//    }
//
//    static int getMinimum(Nodes n) {
//        if(n != null) {
//            while (n.left != null) {
//                n = n.left;
//            }
//            return n.data;
//        }
//        return 0;
//    }
//    static int inorderSuccessor(Nodes root, int num, Nodes originalRoot) {
//        if(root.data == num) {
//            if(root.right != null) {
//                return getMinimum(root.right);
//            } else {
//                int suc = -1;
//                while(originalRoot != null) {
//                    if(originalRoot.data < num)
//                        originalRoot = originalRoot.right;
//                    else if(originalRoot.data > num) {
//                        suc = originalRoot.data;
//                        originalRoot = originalRoot.left;
//                    } else {
//                        break;
//                    }
//                }
//                return suc;
//            }
//        }
//
//        if(root.data > num) {
//            return inorderSuccessor(root.left, num, root);
//        } else {
//            return inorderSuccessor(root.right, num, root);
//        }
//    }
//
//    static void printInorder(Nodes node) {
//        if (node == null) {
//            return;
//        }
//        printInorder(node.left);
//        System.out.print(node.data + " ");
//        printInorder(node.right);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = Integer.parseInt(sc.nextLine());
//        BST resultArray[] = new BST[T];
//        for(int i = 0 ; i < T; i++) {
//            int length = Integer.parseInt(sc.nextLine());
//            int array[]  =  Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int numberToFind = Integer.parseInt(sc.nextLine());
//
//            resultArray[i] = new BST(array, numberToFind);
//        }
//
//        for(int i = 0; i < T; i++) {
//            BST values = resultArray[i];
//            int array[] = values.array;
//            int find = values.num;
//
//            Nodes root = null;
//            for(int j = 0; j < array.length; j++) {
//                int data = array[j];
//                root = insert(root, data);
//            }
//            //printInorder(root);
//           // int num = inorderSuccessor(root, find, root);
//            System.out.println(isBST(root));
//        }
//    }
//}
