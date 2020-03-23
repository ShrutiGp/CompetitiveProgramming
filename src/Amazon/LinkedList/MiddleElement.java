package Amazon.LinkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class MiddleElement {
    static Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void insert(int data) {
        Node n = new Node(data);
        if(head == null) {
            head = n;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }

    }

    int findMiddleElem() {
        int count = 0;
        Node mid = head;
        while(head.next != null) {
            if(count % 2 == 0) {
                mid = mid.next;
            }
            count++;
            head = head.next;
        }
        return mid.data;
    }
    int findMiddleElem1() {
        Node ptr1 = head;
        Node ptr2 = head;
        if(head != null) {
            System.out.println(ptr1.data + " " + ptr2.data);
            while (ptr2 != null && ptr2.next != null) {
                ptr2 = ptr2.next.next;
                ptr1 = ptr1.next;
            }
        }
        return ptr1.data;
    }

    void reverse() {

    }

    static void print() {
        Node temp = head;

        while(temp != null) {
            System.out.println(" ELEM " + temp.data);
            temp = temp.next;
        }
    }

    void rotateByKelements(int k) {


        Node kNode = null;
        Node temp = head;
        int count = 0;

        while(temp.next != null) {
            count++;
            if(count == k) {
                kNode = temp;
            }
            temp = temp.next;
        }
        if(kNode != null) {
            temp.next = head;
            head = kNode.next;
            kNode.next = null;
        }

        print();

    }


    public Node reverseListAndReturnHead() {
        Node prev = null;
        Node curr = head;
        Node second = null;

        while(curr != null) {
            second = curr.next;
            curr.next = prev;
            prev = curr;
            curr = second;
        }

        return prev;
    }


    public Node reverseInGroups(Node head, int k) {

        Node prev = null;
        Node curr = head;
        Node second = null;
        int count = 0;
        while(count < k && curr != null ) {
            second = curr.next;
            curr.next = prev;
            prev = curr;
            curr = second;
            count++;
        }

        if(second != null) {
            head.next = reverseInGroups(second, k);
        }

        return prev;

    }

    static Node reverseInGroupsOfK(Node head, int k) {
        Node curr = head, prev = null, second = null;
        int count  = 0;
        while(count < k && curr != null) {
            second = curr.next;
            curr.next = prev;
            prev = curr;
            curr = second;
            count++;
        }

        if(second != null) {
            head.next = reverseInGroupsOfK(second, k);
        }

        return prev;


    }

    int getCount(Node node)
    {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    int getIntersectionPoint(int d, Node headA, Node headB) {
        int count = 0;
        while(count < d) {
            if(headA == null) {
                return -1;
            }
            headA = headA.next;
            count++;
        }

        while(headA != null && headB != null) {
            if(headA== headB) {
                return headA.data;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return -1;

    }
    int intersectPoint(Node headA, Node headB)
    {
        int c1 = getCount(headA);
        int c2 = getCount(headB);
        int point  = -1;
        if(c1 > c2) {
            int d = c1 - c2;
            point = getIntersectionPoint(d, headA, headB);
        } else {
            int d = c2 - c1;
            point = getIntersectionPoint(d, headB, headA);
        }
        return point;
    }

    int findAndRemoveLoopUsingHashmap() {
        HashSet<Node> hs = new HashSet<>();
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            if(hs.contains(temp) && prev != null) {
                prev.next = null;
                return 1;
            } else {
                hs.add(temp);
                prev = temp;
                temp = temp.next;
            }
        }
        return 0;
    }

    int findLoopUsingSLOWandFASTpointers() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }

        return 0;
    }

    static boolean findLoop(Node head) {

        HashSet<Node> hs = new HashSet<>();
        Node temp = head, prev = null;

        while (temp != null) {
            if(hs.contains(temp)) {
                prev.next = null;
                return true;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return  false;
    }

    static int findResLoop(Node head) {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if(slow == fast) {
                 break;
            }
        }

        if(slow == fast) {
            slow = head;

            while(slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }

        return 0;
    }

    int removeLoopUsingSLOWandFASTpointers() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return 1;
            }
        }
        return 0;
    }

    // by calc length and then finding the n'th node
    int nthNodeFromEnd(int n) {

        int len = 1;
        Node temp = head;
        while(temp.next!= null) {
            len++;
            temp = temp.next;
        }

        if(n > len) {
            return -1;
        }
        temp = head;
        for(int i = 0; i < (len-n); i++) {
            temp = temp.next;
        }

        return temp.data;

    }

    // by taking 2 pointers
    int nthNodeFromEndyTaking2Pointers(int n) {

        Node slow = head;
        Node fast = head;

        for(int i = 0; i < n-1; i++) {
            if(fast == null) {
                return -1;
            }
            fast = fast.next;

        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

    }



    Node addTwoLists(Node first, Node second) {
        int remainder = 0;
        Node newHead = null;
        Node lastNode = null;
        while(first != null || second != null) {

            int sum = 0;
            if(first != null) {
                sum+= first.data;
            }
            if(second != null) {
                sum+= second.data;
            }

            if(remainder > 0) {
                sum += remainder;
            }

            remainder = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            Node n = new Node(sum);
            if(newHead == null) {
                newHead = n;
            } else {
                lastNode.next = n;
            }

            lastNode = n;

            if(first != null)
                first = first.next;

            if(second != null)
                second = second.next;
        }

        if(remainder > 0) {
            lastNode.next = new Node(remainder);
        }

        return newHead;
    }

    Node pairWiseSwap(Node node) {

        if(node == null || node.next == null) {
            return node;
        }

        if(node != null && node.next != null) {
            int temp = node.data;
            node.data = node.next.data;
            node.next.data = temp;
        }

        pairwiseSwap(node.next.next);

        return node;
    }


    Node pairwiseSwap(Node head) {

        Node temp = head;
        while(temp != null && temp.next != null) {
            int res = temp.data;
            temp.data = temp.next.data;
            temp.next.data = res;

            temp = temp.next.next;
        }
        return head;
    }

    Node sortLinkedListOf01and2sByData() { //0.23 seconds

        int count[] = {0,0,0};
        Node temp = head;
        while(temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int currentNum = 0;
        while(temp != null) {
            if(count[currentNum] == 0) {
                currentNum++;
            } else {
                --count[currentNum];
                temp.data = currentNum;
                temp = temp.next;
            }

        }
        return head;
    }


    Node insert(Node zero, Node data) {

            zero.next = data;
            zero = data; // move zero to last element

        return zero;
    }

    Node sortLinkedListOf01and2sByPointers() { //0.23 seconds

        Node zeroHead = null;
        Node oneHead = null;
        Node twoHead = null;

        Node zero = null, one = null, two = null;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                if(zero == null) {
                    zeroHead = temp;
                }
                zero = insert(zero, temp);
            }
            if(temp.data == 1) {
                if(one == null) {
                    oneHead = temp;
                }
                one = insert(one, temp);
            }
            if(temp.data == 2) {
                if(two == null) {
                    twoHead = temp;
                }
                two = insert(two, temp);
            }
            temp = temp.next;
        }

        if(zero != null) {
            zero.next = oneHead != null ? oneHead : twoHead;
        }

        if(one != null && twoHead != null) {
            one.next = twoHead;
        }
        if(two != null) {
            two.next = null;
        }

        head = zeroHead == null ?  (oneHead == null ? twoHead : oneHead) : zeroHead;
        return head;

    }

    boolean checkIfLinkedListIsPalindromeSTACK() {

        Stack<Integer> stack = new Stack<>();
        boolean res = true;
        Node temp = head;
        while(temp!= null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp!= null) {
            if( temp.data != stack.pop()) {
                res = false;
                break;
            }
            temp = temp.next;
        }

        return res;

    }

    boolean checkIfPalindromeByReversing() {

        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean palindrome = true;
        if(slow != null && slow.next != null) {

            Node curr = fast != null ? slow.next : slow;
            Node prev = null, second = null;

            while(curr != null) {
                second = curr.next;
                curr.next = prev;
                prev = curr;
                curr = second;
            }

            Node reversedHead = prev;

            while(head != slow && reversedHead != null) {
                if(head.data != reversedHead.data) {
                    palindrome = false;
                    break;
                }
                head = head.next;
                reversedHead = reversedHead.next;
            }
        } else if(slow != null && slow.next == null) {
            if(head.data != slow.data) {
                palindrome = false;
            }
        }
        return palindrome;
    }


    Node mergeSorted(Node h1, Node h2) {
        Node prev = null;
        Node newHead = null;
        while(h1 != null && h2!= null) {
            if(h1.data < h2.data) {
                if(prev == null) {
                    prev = h1;
                    newHead = prev;
                } else {
                    prev.next = h1;
                    prev = h1;
                }
                h1 = h1.next;
            } else {
                if(prev == null) {
                    prev = h2;
                    newHead = prev;
                } else {
                    prev.next = h2;
                    prev = h2;
                }
                h2 = h2.next;
            }
        }

        while(h1 != null) {
            prev.next = h1;
            prev = h1;
        }

        while(h2 != null) {
            prev.next = h2;
            prev = h2;
        }

        return newHead;
    }


    static Node mergeSortedByRecursion(Node h1, Node h2) {
        if(h1 == null)
            return h2;

        if(h2 == null)
            return h1;

        if(h1.data < h2.data) {
            h1.next = mergeSortedByRecursion(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeSortedByRecursion(h1, h2.next);
            return h2;
        }
    }


    public static void main(String[] args) {
        MiddleElement middleElement = new MiddleElement();
        middleElement.insert(1);
        middleElement.insert(2);
        middleElement.insert(3);
        middleElement.insert(4);
        middleElement.insert(5);
        middleElement.insert(6);
        middleElement.insert(7);
        middleElement.insert(8);
////        System.out.println("HI:"+middleElement.head.data);
////
////
////        middleElement.findMiddleElem1();
////        middleElement.findMiddleElem();
///
//
//        middleElement.rotateByKelements(4);

//
//        head  = middleElement.reverseListAndReturnHead();
//        print();

        head  = middleElement.reverseInGroups(head, 3);
        print();




    }
}
