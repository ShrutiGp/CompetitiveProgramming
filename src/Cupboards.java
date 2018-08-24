import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Cupboards {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int cupboards = Integer.parseInt(sc.nextLine());
        String num1[] = new String[cupboards];
        String num2[] = new String[cupboards];

        for(int i=0; i<cupboards; i++) {
            String str = sc.nextLine();
            num1[i] = str.split(" ")[0];
            num2[i] = str.split(" ")[1];
        }
        int count = 0;

        int left0 = Collections.frequency(Arrays.asList(num1), "0");
        int left1 = Collections.frequency(Arrays.asList(num1), "1");

        count += left0 > left1 ? left1 : left0;
        int right0 = Collections.frequency(Arrays.asList(num2), "0");
        int right1 = Collections.frequency(Arrays.asList(num2), "1");

        count += right0 > right1 ? right1 : right0;

        System.out.print(count);
    }
}