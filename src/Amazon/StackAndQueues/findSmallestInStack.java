package Amazon.StackAndQueues;

import java.util.Stack;

public class findSmallestInStack {
    int minEle;
    Stack<Integer> s = new Stack<>();

    int getMin()
    {
        if(s.isEmpty()){
            return -1;
        }
        return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty()){
            return -1;
        }
        int data = s.pop();

        if(data < minEle) {
            int temp = minEle;
            minEle = 2*minEle - data;
            return temp;
        }
        return data;
    }
    /*push element x into the stack*/
    void push(int x)
    {
        if(s.isEmpty()) {
            s.push(x);
            minEle = x;
        } else {
            if(x < minEle) {
                s.push(2*x - minEle);
                minEle = x;
            } else {
                s.push(x);
            }
        }
        return;
    }
    public static void main(String[] args) {

        findSmallestInStack findSmallestInStack = new findSmallestInStack();
        findSmallestInStack.push(79);
        findSmallestInStack.getMin();
        findSmallestInStack.push(4);
        findSmallestInStack.getMin();
        findSmallestInStack.getMin();
        findSmallestInStack.pop();
        findSmallestInStack.push(61);
        findSmallestInStack.getMin();

        findSmallestInStack.push(3);
        findSmallestInStack.push(1);


    }
}
