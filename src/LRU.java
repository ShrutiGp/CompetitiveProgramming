import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRU {


    static int result(int arr[], int n) {
        int res = 1;

        for(int i = 0 ; i < n && arr[i] <= res; i++) {
            res =  res + arr[i];
        }

        return res;
    }
    int capacity;
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    void set(int x, int y) {
        if(queue.contains(x)) {
            queue.remove(x);
        } else if(queue.size() == capacity) {
            Integer head = queue.remove();
            map.remove(head);
        }

        queue.add(x);
        map.put(x, y);
    }

    int get(int x) {
        int retrieved = map.get(x) != null ? map.get(x) : -1;
        if(retrieved != -1) {
            queue.remove(x);
            queue.add(x);
        }

        return retrieved;
    }

    static int minimumJumps(int arr[]) {
        int jumps = 0;
        int i = 0;

        while (i < arr.length) {
            jumps++;
            int max = Integer.MIN_VALUE;
            int count = arr[i];
            if(i + count > arr.length) {
                break;
            }
            for(int j = 1; j <= count; j++) {
                if(arr[i+j] > max)
                    max = i+j;
            }
            i = max;
        }

        return jumps;
    }


    static int numberOfJumps(int heights[], int X, int Y) {
        int jumps = 0;
        for(int i = 0 ; i < heights.length; i++) {
            if(heights[i] <= X) {
                jumps++;
            } else {
                int h = heights[i];
                while (h > X) {
                    jumps++;
                    h = h - (X - Y);
                }
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("MINIMUM " + minimumJumps(arr));
        int arr2[] = {1, 2, 6, 10, 11, 15};
        System.out.println(result(arr2, arr2.length));
    }
}