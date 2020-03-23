package Amazon.Trees;

import java.util.*;

class Node
{
    int data;
    Node left, right, nextRight;
    int hd;
    public Node(int item)
    {
        data = item;
        left = right = null;
        hd = Integer.MAX_VALUE;
        nextRight = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

public class LevelOrderTraversal
{
    // Root of the Binary Tree
    Node root;

    public LevelOrderTraversal()
    {
        root = null;
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }


    /* Print nodes at the given level */
    void printGivenLevel (Node root , int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    static Queue q = new LinkedList<Node>();

    void printLevelOrderTraversalUsingQueue() {
        if(root == null) {
            return;
        }

        q.add(root);

        while(!q.isEmpty()) {
            Node polled = (Node) q.poll();
            System.out.print( polled.data + " ");

            q.add(polled.left);
            q.add(polled.right);
        }
    }
    void printLevel1(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.println(root.data);
        } else {
            printLevel1(root.left, level - 1);
            printLevel1(root.right, level - 1);
        }
    }
    //******************IMPORTANT*****************
    void printLevelOrderTraversalBOTTOMVIEW() {

        Queue q = new LinkedList<Node>();


        root.hd = 0;

        q.add(root);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (!q.isEmpty()) {

            Node data =(Node) q.poll();

            treeMap.put(data.hd, data.data);
            if(data.left != null) {
                data.left.hd = data.hd - 1;
                q.add(data.left);
            }

            if(data.right != null) {
                data.right.hd = data.hd + 1;
                q.add(data.right);
            }

        }

        Set set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer , Integer>  map  = iterator.next();

            System.out.println(map.getKey() + " " + map.getValue());
        }


    }

    void printLevelOrderTraversalVERTICALVIEW() {

        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer, ArrayList> tm = new TreeMap<>();
        root.hd = 0;
        q.add(root);

        while(!q.isEmpty()) {

            Node temp = (Node) q.poll();
            if(tm.get(temp.hd) != null && tm.get(temp.hd) instanceof ArrayList) {
                ArrayList<Integer> list = tm.get(temp.hd);
                Integer i = temp.data;
                if(i instanceof Integer) {
                    list.add(temp.data);
                    tm.put(temp.hd, list);
                }
            } else {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(temp.data);
                tm.put(temp.hd, list1);
            }

            if(temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }


        Set set = tm.entrySet();

        @SuppressWarnings("unchecked")
        Iterator<Map.Entry<Integer, List>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer , List>  map  = iterator.next();
            List<Integer> values = map.getValue();
            for(Integer i : values) {
                System.out.print(i + " ");
            }
        }


    }

//
//    Node lowestCommonAncestor(Node root, Node n1, Node n2) {
//        if(root == null) {
//            return root;
//        }
//
//        if(root.data > n1 && root.data > n2) {
//            return lowestCommonAncestor(root.left, n1, n2);
//        } else if(root.data < n1 && root.data < n2) {
//            return lowestCommonAncestor(root.right, n1, n2);
//        }
//        return root;
//
//    }


    int count(Node root) {

        int c = 0;
        if(root != null && root.left == null && root.right == null) {
            return 1;
        }

        c += count(root.left);
        c += count(root.right);

        return c;
    }

    int countLeaves() {
        int res = count(root);
        System.out.println("count + " + res);
        return res;
    }


    void connect() {
        Queue queue = new LinkedList();

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node temp =(Node)queue.peek();
            queue.remove();
            if(temp != null) {
                    Node data =(Node)queue.peek();
                    temp.nextRight = data;


                    if(data.left != null) {
                        queue.add(data.left);
                    }
                    if(temp.right != null) {
                        queue.add(data.right);
                    }
                queue.add(null);
            }
            queue.remove();
        }

       print1(root);
    }


    void print1(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);

        Node temp = root;
        while(temp.nextRight != null) {
            temp = temp.nextRight;
            System.out.println(temp.data);
        }

        print1(root.left);

    }


    void leftView() {

        Queue queue = new LinkedList();

        queue.add(root);
        queue.add(null);
        while (!q.isEmpty()) {
            Node node = (Node)q.peek();

            if(node != null) {
                System.out.println(node.data);

                while(q.peek() != null) {

                    Node temp = (Node) q.peek();
                    if(temp.left != null)
                        q.add(temp.left);

                    q.remove();
                }

                q.add(null);
            }
            q.remove();
        }
    }



    void leftViewSpiral() {
        Queue queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        while (!q.isEmpty()) {
            Node node = (Node)q.peek();
            if(node != null) {
                while(q.peek() != null) {
                    Node temp = (Node) q.peek();
                    if(temp.left != null)
                        q.add(temp.left);

                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }

                q.add(null);
            }
            q.remove();
        }
    }



    Node connectRecur(Node root) {

        if(root == null)
            return root;

        if(root.left != null) {
            root.left.nextRight = root.right;
        }

        if(root.right != null) {
            root.right.nextRight = root.nextRight != null? root.nextRight.left : null;
        }

        connectRecur(root.left);
        connectRecur(root.right);

        return root;

    }


    void connect1() {
        root.nextRight = null;
        connectRecur(root);
        print1(root);
    }

    void printLevel(Node root, int level) {
        if(root == null) {
            return;
        }

        if(level == 1)
            System.out.print(root.data);
        else if(level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1 );
        }
    }


    void levelOrderTraversalByHeight() {
        int h = height(root);

        for(int i = 1; i <= h; i++) {
            printLevel(root, i);
        }
    }

    void printSpiralLevel(Node root, int level, boolean ltr) {
        if(root == null)
            return;

        if(level == 1)
            System.out.print(root.data + " ");
        else if(level > 1) {
            if(ltr) {
                printSpiralLevel(root.left, level - 1, ltr);
                printSpiralLevel(root.right, level - 1, ltr);
            } else {
                printSpiralLevel(root.right, level - 1, ltr);
                printSpiralLevel(root.left, level - 1, ltr);
            }
        }
    }

    void levelOrderTravelByHeightSPIRALLY() {
        int h = height(root);
        boolean ltr = false;
        for(int i = 1; i <= h; i++) {
            printSpiralLevel(root, i, ltr);
            ltr = !ltr;
        }
    }

        ////////////// DLL /////
    Node prev = null;
    Node head;
    void createDLL(Node root) {
        if(root == null)
            return;

        createDLL(root.left);
        if(prev == null) {
            head = prev;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        createDLL(root.right);
    }

    void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    void binaryTreeToDoublyLinkedList(Node root) {
        //this is for inorder traversal

        createDLL(root);
        printDLL(head);

    }


    /////////DLL ends//////


    boolean isIt(Node root1, Node root2) {
        if(root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    boolean isIdentical(Node root1, Node root2)
    {


        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        //Your code here
    }


   boolean inorderTraversal(Node rootL, Node rootR) {
        inorderTraversal(rootL.left, rootR.right);
        if(rootL.data != rootR.data)
            return false;

        inorderTraversal(rootL.right, rootR.left);

        return true;
    }

    int heightLeft(Node root) {

        if(root == null) {
            return 0;
        }
        return 1 + heightLeft(root.left);
    }

    int heightRight(Node root) {

        if(root == null) {
            return 0;
        }
        return 1 + heightRight(root.right);
    }


//    int height1(Node root) {
//
//        if(root == null) {
//            return 0;
//        }
//
//        int heightL = 1 + height1(root.left);
//        int heightR = 1 + height1(root.right);
//
//        return Math.floorMod(heightL, heightR) <= 1;
//    }

    boolean balanced() {
        int heightL = height(root.left);
        int heightR = height(root.right);
        return Math.floorMod(heightL, heightR) <= 1;
    }




    public String serialize(Node root, ArrayList<Integer> aa) {

        if(root == null) {
            aa.add(-1);
            return aa.toString();
        }

        aa.add(root.data);
        serialize(root.left, aa);
        serialize(root.right, aa);

        return aa.toString();
    }


    Node createBT(Node root, String str[], int index) {
        int data = Integer.parseInt(str[index].trim());
        if(data == -1)
            return null;

        if(root == null) {
            root = new Node(data);
        }
        index++;

        createBT(root.left, str, index);
        createBT(root.right, str, index);

        return root;
    }
    public Node deSerialize(String data) {
        data = data.substring(1, data.length() - 1);
        String str[] = data.trim().split(",");
        Node root = createBT(null, str, 0);
        inorder(root);
        return null;
    }

    void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.println("in " + root.data);
            inorder(root.right);
        }
    }


    static int res = Integer.MIN_VALUE;
    int maxPathSumUtil(Node root) {


        if(root == null) {
            return 0;
        }

        int lh = maxPathSumUtil(root.left);
        int rh = maxPathSumUtil(root.right);

        if(root.right != null && root.left != null) {
            int potentialMax = lh + rh + root.data;
            res = Math.max(res, potentialMax);

            return Math.max(lh, rh) + root.data;
        }


        if(root.right == null) {
            return lh + root.data;
        } else {
            return rh + root.data;
        }
    }

    int ans = 0;
    int diameter(Node root) {
        if(root == null){
            return 0;
        }

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        ans = Math.max(1+lh+rh, ans);

        return Math.max(lh, rh) + 1;
    }



    int maxPathSum()
    {
        maxPathSumUtil(root);
        diameter(root);
        System.out.println(res + " is res a d ans " + ans );
        return res;
    }
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
//        tree.printLevelOrder();
//
//        tree.printLevelOrderTraversalUsingQueue();


      //  tree.printLevelOrderTraversalVERTICALVIEW();

       // tree.countLeaves();
  //      tree.connect1();
    //    tree.balanced();
//
//        String serial = tree.serialize(tree.root, new ArrayList<Integer>());
//
//        tree.deSerialize(serial);
//        System.out.println(serial);

        tree.maxPathSum();
    }



}