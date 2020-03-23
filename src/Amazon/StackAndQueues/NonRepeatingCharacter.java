package Amazon.StackAndQueues;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class NonRepeatingCharacter {

    static PrintWriter out = new PrintWriter(System.out);


    static void printNonrepeatingCharsMethod1(int size, char charArray[]) {
        Queue<Character> q = new ArrayDeque<>();
        List<Character> occured = new ArrayList<>();
        for(int i = 0 ; i < size; i++) {
            if(occured.contains(charArray[i])) {
                q.remove(charArray[i]);
                if (q.isEmpty()) {
                    out.print("-1 ");
                } else {
                    out.print(q.peek() + " ");
                }
            } else {
                occured.add(charArray[i]);
                q.add(charArray[i]);
                out.print(q.peek()+ " ");
            }


        }
    }

    static void printNonrepeatingCharsMethod2(int size, char charArray[]) {
        Queue<Character> queue = new ArrayDeque<>();
        boolean isRepeated[] = new boolean[256];
        for(int i = 0 ; i < size; i++) {

            if(!isRepeated[charArray[i]]) {
                queue.add(charArray[i]);
                isRepeated[charArray[i]] = true;
            }
            else {
                queue.remove(charArray[i]);
            }
            if (queue.isEmpty()) {
                out.print("-1 ");
            } else {
                out.print(queue.peek() + " ");
            }


        }
    }

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {

            int size = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            char charArray[] = line.replaceAll(" ", "").toCharArray();


            printNonrepeatingCharsMethod1(size, charArray);
            printNonrepeatingCharsMethod2(size, charArray);

            out.println();

        }
        out.flush();
        out.close();

    }
}
