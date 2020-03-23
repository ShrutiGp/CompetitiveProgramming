package Amazon.LinkedList;

import java.util.Stack;

class GfG
{
    int minEle;
    Stack<Integer> s;

    /*returns min element from stack*/
    int getMin()
    {
        return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty()){
            return -1;
        }
        return s.pop();
    }
    /*push element x into the stack*/
    void push(int x)
    {

        if(s.isEmpty()){
            minEle = x;
            s.push(x);
            return;
        }

        if(minEle > x) {
            minEle = x;
        }

        s.push(x);
        return;
    }
}