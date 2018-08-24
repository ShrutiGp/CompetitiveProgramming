import java.util.Scanner;

public class AmusingJoke {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        String guest = sc.nextLine();
        String host = sc.nextLine();
        StringBuilder jumbled =  new StringBuilder(sc.nextLine());
        boolean result = false;
        String temp = "";

        if(jumbled.length() == (guest.length() + host.length())) {
            String combined = guest + host;
            for(int i = 0; i < combined.length(); i++) {
                int index = jumbled.indexOf(Character.toString(combined.charAt(i)));
                if (index != -1) {
                    temp += jumbled.charAt(index);
                    jumbled.deleteCharAt(index);
                }
            }
            if(temp.equals(combined))
                result = true;
        }
        if(result) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}