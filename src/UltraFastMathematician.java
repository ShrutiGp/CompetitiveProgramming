import java.util.Scanner;

public class UltraFastMathematician {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        char ch1[] = sc.nextLine().toCharArray();
        char ch2[] = sc.nextLine().toCharArray();
        int i = 0;
        while(i < ch1.length) {
            System.out.print(Character.getNumericValue(ch1[i]) ^ Character.getNumericValue(ch2[i]));
            i++;
        }
    }
}