import java.util.Scanner;

public class LongWords {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int num  = Integer.parseInt(sc.nextLine());
        String str[] = new String[num];
        for(int i = 0;  i<num; i++) {
            str[i]= sc.nextLine();
        }
        for(String st : str) {
            int size = st.length();
            if(size > 10) {
                System.out.println(new StringBuilder().append(st.charAt(0)).append(size-2).append(st.charAt(size-1)));
            } else {
                System.out.println(st);
            }
        }

    }
}
