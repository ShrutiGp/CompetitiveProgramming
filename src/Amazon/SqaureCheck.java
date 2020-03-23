package Amazon;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y =y;

        System.out.println("Points are "+ this.x + "   " +  this.y);
    }
}

public class SqaureCheck {
    static BufferedReader br;
    static StringTokenizer st;


    public static int findDistance(Point p1, Point p2) {
        return ( (p2.x - p1.x) * ( p2.x - p1.x)) + ( ( p2.y - p1.y) * ( p2.y - p1.y));
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String str[] = new String[T];
        for(int i = 0 ; i < T; i++) {
            str[i] = sc.nextLine();
        }

        for(int i = 0; i < str.length; i++) {
            int array[] = Arrays.stream(str[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = array[0];
            int x2 = array[1];
            int x3 = array[2];
            int x4 = array[3];
            int y1 = array[4];
            int y2 = array[5];
            int y3 = array[6];
            int y4 = array[7];
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);
            Point p4 = new Point(x4, y4);
            int d2 = findDistance(p1, p2);
            int d3 = findDistance(p1, p3);
            int d4 = findDistance(p1, p4);
            if(d2 == d3 && (d4 == (2 * d2)) && (findDistance(p2, p3) ==  (2 * d3))) {
                System.out.println("Yes");
            } else if (d2 == d4 && d3 == (2 * d2) && findDistance(p2, p4) ==(2 * d2)) {
                System.out.println("Yes");
            } else if( d3 == d4 && d2 == (2 * d4) && findDistance(p3, p4) == ( 2 * d4 )) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
