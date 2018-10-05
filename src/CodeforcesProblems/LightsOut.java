package CodeforcesProblems;

import java.util.Arrays;
import java.util.Scanner;

public class LightsOut {

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        int initialState[][] = {{1,1,1}, {1,1,1}, {1,1,1}};

        int array[][] = new int[3][3];
        for(int i = 0;  i<3; i++) {
            String str = sc.nextLine();
            array[i] = Arrays.stream(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(array[i][j] % 2 > 0) {
                    initialState[i][j] = initialState[i][j] ^ 1;
                    if(i > 0)
                        initialState[i-1][j] = initialState[i-1][j] ^ 1;
                    if(i < 2)
                        initialState[i+1][j]= initialState[i+1][j] ^ 1;
                    if(j > 0)
                        initialState[i][j-1] =initialState[i][j-1] ^ 1;
                    if(j < 2)
                        initialState[i][j+1] = initialState[i][j+1] ^ 1;
                }
            }
        }

        for(int i = 0; i < initialState.length; i++) {
            for(int j = 0; j < initialState[i].length; j++) {
                System.out.print(initialState[i][j]);
            }
            System.out.println();
        }
    }

}