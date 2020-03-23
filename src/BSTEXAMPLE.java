public class BSTEXAMPLE {

    public Node root;
     class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    void insertKey(int key) {
         root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
         if(root == null) {
             root = new Node(key);
             return root;
         }

         if(root.data > key) {
             root.left = insertRec(root.left, key);
         } else {
          root.right = insertRec(root.right, key);
         }

         return root;
    }

    Node search(Node root, int key) {
         if(root == null || root.data == key) {
             return root;
         }

         if(root.data > key) {
             return search(root.left, key);
         }

         return search(root.right, key);
    }

    void printInorder(Node root) {

         if(root == null) {
             return;
         }

         printInorder(root.left);
         System.out.println("root : " + root.data);
         printInorder(root.right);
    }


    boolean checkIfBST(Node root, int min, int max) {

         if(root == null)
             return true;

         if(root.data < min || root.data > max)
             return false;

         return checkIfBST(root.left, min, root.data) || checkIfBST(root.right, root.data, max);
    }

    int height(Node root) {
         if(root == null)
             return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh > rh)
            return lh + 1;
        else
            return rh + 1;

    }

    int countlLeaves(Node root) {
         if(root == null) {
             return 0;
         }
         if(root.left == null  && root.right == null)
             return 1;
         return countlLeaves(root.left) + countlLeaves(root.right);
    }


    boolean isBalanced(Node root) {
         if(root == null) {
            return true;
         }

         int leftHeight = height(root.left);
         int rightHeight = height(root.right);

         if(Math.abs(leftHeight - rightHeight) > 1) {
             return false;
         }

         return isBalanced(root.left) || isBalanced(root.right);
    }

    boolean isIdentical(Node root1, Node root2) {
         if(root1 == null && root2 == null) {
             return true;
         }

         if( (root1 == null || root2 == null) || (root1.data != root2.data))
             return false;

         return isIdentical(root1.left, root2.left) || isIdentical(root1.right, root2. right);
    }

    boolean isBalanc(Node root) {
         if(root == null) {
             return true;
         }

         int left = height(root.left);
         int right = height(root.right);

         if(Math.abs(left - right) > 1) {
             return false;
         }

         return isBalanced(root.left) || isBalanced(root.right);
    }


    boolean isSymmetric(Node root) {
         return checkSymmetry(root, root);
    }

    boolean checkSymmetry(Node root1, Node root2) {
         if(root1 == null && root2 == null) {
             return true;
         }

         if((root1 == null || root2 == null) || (root1.data != root2.data)) {
             return false;
         }

         return checkSymmetry(root1.left, root2.right) || checkSymmetry(root1.right, root2.left);
    }

    static int a[] = new int[10];

    static int factorial(int n) {
        if(n == 0)
            return 1;

        return a[n] = n * factorial(n-1);
    }

    static int longestCommonSubsequence(String s1, String s2, int length1, int length2, String word) {
        if(length1 == 0 || length2 == 0) {
            System.out.println("word  " + word);
            return 0;
        }

        if(s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
            word =  word + s1.charAt(length1 - 1);
            return 1 + longestCommonSubsequence(s1, s2, length1 - 1, length2 - 1, word);
        }

        return Math.max(longestCommonSubsequence(s1, s2, length1 - 1, length2, word), longestCommonSubsequence(s1, s2, length1, length2-1, word));
    }

    static int longestCommonSustring(String s1, String s2, int length1, int length2, int count) {
        if(length1 == 0 || length2 == 0)
           return count;

        if(s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
            count = longestCommonSustring(s1, s2, length1 - 1, length2 - 1, count + 1);
        } else {
            count = Math.max(count, Math.max(longestCommonSustring(s1, s2, length1, length2 -1, 0), longestCommonSustring(s1, s2, length1 - 1, length2, 0)));
        }
        return count;
    }


    static int longestByDp(String s1, String s2, int m , int n) {
        int a[][] = new int[m + 1][n + 1];

        int res=0;
        for(int i = 0 ; i < m; i ++) {
            for(int j = 0 ; j  < n;  j ++) {
                if(i ==0 || j == 0) {
                    a[i][j] = 0;
                } else {
                    if(s1.charAt(i) == s2.charAt(j)) {
                        a[i][j] = 1 + a[i-1][j-1];
                        if(a[i][j] > res) {
                            res = a[i][j];
                        }
                    } else {
                        a[i][j] = 0;

                    }
                }
            }
        }

        return res;
    }

    static int knapsack(int weights[], int values[], int n , int W) {

        if(W == 0 || n == 0) {
            return 0;
        }

        if(weights[n-1] > W) {
            return knapsack(weights, values, n - 1, W);
        }

        return Math.max(knapsack(weights, values, n-1, W - weights[n-1] ) + values[n-1], knapsack(weights, values,n-1, W));
    }


    static int knapSack(int W, int wt[], int v[], int index) {

        if(wt[index - 1] > W) {
            return knapSack(W, wt, v, index - 1);
        }

        int addingWeight = v[index - 1] + knapSack(W-wt[index - 1], wt, v, index - 1);

        return Math.max(addingWeight, knapSack(W, wt, v, index - 1));
    }



    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, n, W));
        BSTEXAMPLE bstexample = new BSTEXAMPLE();


        bstexample.insertKey(20);
        bstexample.insertKey(10);
        bstexample.insertKey(9);
        bstexample.insertKey(33);
        bstexample.insertKey(24);

        System.out.println("leaves  + " + bstexample.countlLeaves(bstexample.root));
        System.out.println("is Balanced" + bstexample.isBalanced(bstexample.root));

        Node searched = bstexample.search(bstexample.root, 33);
        System.out.println("SEARCH FOUND " + searched.data);

        bstexample.printInorder(bstexample.root);

        bstexample.checkIfBST(bstexample.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        String s1 = "ABCDGHSTYU";
        String s2 = "AEDFHRSTYU";
        System.out.println("ANSWRR : "  + longestCommonSubsequence(s1, s2, s1.length(), s2.length(), ""));
        System.out.println("ANSWRR : "  + longestCommonSustring(s1, s2, s1.length(), s2.length(), 0));
    }
}
