import java.util.Scanner;

public class StonesOnTable {

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        char ch[] = sc.nextLine().toCharArray();
        int count = 0;
        for(int i=1;  i<num ; i++) {
            if(ch[i-1] == ch[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

}
