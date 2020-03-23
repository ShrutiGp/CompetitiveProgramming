//package Amazon.StackAndQueues;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.PrintWriter;
//        import java.util.*;
//
//public class MaximumOfSubarray {
//
//
//    static PrintWriter out = new PrintWriter(System.out);
//    static BufferedReader br;
//    static StringTokenizer st;
//
//    public static String next() {
//        if(st.hasMoreTokens()) {
//            return st.nextToken();
//        } else {
//            try {
//                st = new StringTokenizer(br.readLine());
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return st.nextToken();
//    }
//
//
//    public static void nextGreatest(int a[]) {
//
//        Stack<Integer> stack = new Stack<>();
//        HashMap<Integer, Integer> res = new HashMap<>();
//        for(int i = 0; i < a.length; i++) {
//           if(stack.isEmpty()) {
//               stack.push(a[i]);
//           } else {
//                while(!stack.isEmpty() && stack.peek() < a[i]) {
//                    int data = stack.pop();
//                    System.out.println("popped " +data);
//                    res.put(data, a[i]);
//                }
//                stack.push(a[i]);
//           }
//        }
//        res.put(a[a.length - 1], -1);
//        for(Map.Entry<Integer, Integer> e : res.entrySet()) {
//            System.out.println(e.getKey() + " " + e.getValue());
//        }
//    }
//
//    static class Ele
//    {
//        int x = 0;
//        int y = 0;
//        Ele(int x,int y)
//        {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    static boolean isValid(int i, int j)
//    {
//        return (i >= 0 && j >= 0 && i < R && j < C);
//    }
//
//
//    // Function to check whether the cell is delimiter
//    // which is (-1, -1)
//    static boolean isDelim(Ele temp)
//    {
//        return (temp.x == -1 && temp.y == -1);
//    }
//
//    public static int rottenOrangeCount(int a[][]) {
//
//        Queue<Ele> queue = new LinkedList<>();
//        for(int i = 0; i < a.length; i++) {
//            for(int j = 0; j < a[0].length; j++) {
//                if(a[i][j] == 2)
//                    queue.add(new Ele(i, j));
//            }
//        }
//
//        queue.add(new Ele(-1, -1));
//        int count = 0;
//
//        while(!queue.isEmpty()) {
//            boolean found = false;
//
//            while(!isDelim(queue.peek())) {
//                Ele temp = queue.peek();
//                if(isValid(temp.x + 1, temp.y) && a[temp.x+1][temp.y] == 1) {
//                    found = true;
//                    count++;
//                    a[temp.x+1][temp.y] = 2;
//                    queue.add(new Ele(temp.x + 1, temp.y));
//                }
//                if(isValid(temp.x - 1, temp.y) && a[temp.x-1][temp.y] == 1) {
//                    found = true;
//                    count++;
//                    a[temp.x-1][temp.y] = 2;
//                    queue.add(new Ele(temp.x - 1, temp.y));
//                }
//
//
//                queue.remove();
//
//            }
//
//            queue.remove();
//            if (!queue.isEmpty())
//            {
//                queue.add(new Ele(-1,-1));
//            }
//
//        }
//
//
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        int arr[] = {4,5,2,25};
//        nextGreatest(arr);
////
////
////        br = new BufferedReader(new InputStreamReader(System.in));
////        st = new StringTokenizer("");
////        int T = Integer.parseInt(next());
////        while(T-- > 0) {
////            int size =  Integer.parseInt(next());
////            int k = Integer.parseInt(next());
////            int a[] = new int[size];
////            for(int j =0 ; j < size; j++) {
////                a[j]=Integer.parseInt(next());
////            }
////            Queue<Integer> queue = new LinkedList<>();
////            int max = Integer.MIN_VALUE;
////            for(int i =0; i < size; i++) {
////                if(max < a[i]) {
////                    max = a[i];
////                }
////                queue.add(a[i]);
////                if(queue.size() % k == 0) {
////                    out.print(max + " ");
////                    int removed  = queue.poll();
////                    if(removed == max) {
////                        int newMax = Integer.MIN_VALUE;
////                        if(!queue.isEmpty()) {
////                            Iterator iterator = queue.iterator();
////                            while (iterator.hasNext()) {
////                                int data = (int) iterator.next();
////                                if (newMax < data) {
////                                    newMax = data;
////                                }
////                            }
////                        }
////                        max = newMax;
////                    }
////                }
////            }
////
////            out.println();
////        }
////
////        out.flush();
////        out.close();
//    }
//}
//
//
