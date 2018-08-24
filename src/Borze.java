import java.util.Scanner;

public class Borze {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String patternArray[]  = pattern.split("(?!^)");

        for(int i=0; i<patternArray.length; i++) {
            if(patternArray[i].equals("."))
                System.out.print("0");
            else if(patternArray[i].equals("-") && (i+1<patternArray.length)) {
                if(patternArray[i+1].equals(".")) {
                    System.out.print("1");
                } else {
                    System.out.print("2");
                }
                i++;
            }
        }

    }
}
