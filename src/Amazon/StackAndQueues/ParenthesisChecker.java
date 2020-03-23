package Amazon.StackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ParenthesisChecker {

    static boolean isMatchingPair(Character newChar, Character poppped) {
        if((newChar == '}' && poppped == '{') ||  (newChar == ']' && poppped == '[')  ||  (newChar == ')' && poppped == '(') )
            return true;

        return false;
    }

    static void findNextGreatest(int arr[], int index, int compareIndex, List<Integer> result) {
        if(compareIndex > (arr.length-1) && index != arr.length - 1) {
            result.add(-1);
            findNextGreatest(arr, index+1, index + 2, result);
        }

        if(index == arr.length - 1) {
            result.add(-1);
            System.out.println("RESULT " + result.toArray());
            return;
        }

        if(arr[index] < arr[compareIndex]) {
            System.out.println("Index " + arr[compareIndex]);
            result.add(arr[compareIndex]);
            findNextGreatest(arr, index+1, index + 2, result);
        } else {
            findNextGreatest(arr, index, compareIndex+1, result);
        }
    }


    static void nextGreatestUsingStack(int a[]) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(a[0]);

        for(int i = 1; i < a.length; i++) {
            while(!st.isEmpty() && st.peek() < a[i]) {
                int elemt = st.pop();
                System.out.println("PEEK " + elemt + " for " + a[i]);
                list.add(a[i]);
                list.add(a[i]);
            }
            st.push(a[i]);
        }

        while(!st.isEmpty()) {
            int elem = st.pop();
            list.add(-1);
        }

        System.out.println(list.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));


    }


    public static void main(String[] args) {
        int a1[] = {7,8,1,4};
        nextGreatestUsingStack(a1);

//        int a[] = {1,3,2,4};
//        findNextGreatest(a, 0, 1, new ArrayList<>());

        Stack<Character> stack = new Stack<>();
        char ch[] = { '{', '[', '(', ')',']', '}',};
        boolean balanced = true;
        for(int i = 0 ; i < ch.length; i++) {
            if(ch[i] == '{' || ch[i] == '[' || ch[i] == '(' ) {
                stack.push(ch[i]);
            } else {
                if(stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                Character poppped = stack.pop();
                boolean isMatching = isMatchingPair(ch[i], poppped);
                if(!isMatching) {
                    balanced = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) {
            balanced = false;
        }

        System.out.println("IS BALANCED ? " + balanced);
    }
}
