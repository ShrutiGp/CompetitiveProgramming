package CodeforcesProblems;

import java.util.*;

public class YoungPhysicist {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        float sumx = 0, sumy = 0, sumz = 0;
        for(int i = 1 ; i<=n; i++) {
            String s = sc.nextLine();
            String dimension[] = s.split(" ");
            sumx += Float.parseFloat(dimension[0]);
            sumy += Float.parseFloat(dimension[1]);
            sumz += Float.parseFloat(dimension[2]);
        }

        if(sumx == 0.0 && sumy == 0.0 && sumz == 0.0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}