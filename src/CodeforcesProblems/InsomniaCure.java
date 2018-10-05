package CodeforcesProblems;

import java.util.Scanner;

public class InsomniaCure {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[4];
        for(int i=0; i<4; i++) {
            num[i] = Integer.parseInt(sc.nextLine());
        }
        int d = Integer.parseInt(sc.nextLine());

        int array[] = new int[d];
        int i = 0, count = 0;

        while(count <= d && i < 4) {
            for(int j = 0;  j< array.length; j++)
            {
                if((j+1) % num[i] == 0) {
                    array[j] = 1;
                }
            }
            i++;
        }

        for(int j=0 ; j<array.length; j++) {
            if(array[j] == 1) {
                count++;
            }
        }
        System.out.print(count);
    }
}
