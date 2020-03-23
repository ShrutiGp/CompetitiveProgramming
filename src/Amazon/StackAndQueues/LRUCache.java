package Amazon.StackAndQueues;

import java.io.PrintWriter;
import java.util.*;

public class LRUCache {

    Map<Integer,Integer> map;
    int capacity;
    Queue<Integer> q = new LinkedList<>();

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        capacity = N;
        map = new HashMap<>();
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        int value  = map.get(x) != null ? map.get(x) : -1;
        if(value != -1) {
            q.remove(x);
            q.add(x);
        }
        return value;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here

        if(q.contains(x)) {
            q.remove(x);
        } else {
            if(q.size() >= capacity) {
                int head =  q.poll();
                map.remove(head);
            }
        }

        q.add(x);
        map.put(x, y);



    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1,2);
        lruCache.set(2,3);
        lruCache.set(1,5);
        lruCache.set(4,5);
        lruCache.set(6,7);
        System.out.println("Answ : " + lruCache.get(4));
        System.out.println("Answ : " +lruCache.get(1));


        }
}
