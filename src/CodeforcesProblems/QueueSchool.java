package CodeforcesProblems;

import java.util.Scanner;

public class QueueSchool {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String stats = sc.nextLine();
        String statsArray[] = stats.split(" ");
        String pattern = sc.nextLine();
        String patternArray[]  = pattern.split("(?!^)");

        int numberOfChildren = Integer.parseInt(statsArray[0]);
        int time = Integer.parseInt(statsArray[1]);

        for(int i = 1 ; i <= time; i++) {
            for(int j = 0; j < patternArray.length ; j++) {
                if(j+1 < patternArray.length) {
                    if(patternArray[j].equals("B") && patternArray[j+1].equals("G")) {
                        String temp = patternArray[j];
                        patternArray[j] = patternArray[j+1];
                        patternArray[j+1] = temp;
                        j++;
                    }
                }
            }
        }

        for(String s : patternArray) {
            System.out.print(s);
        }

    }
}