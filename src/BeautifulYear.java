import java.util.Scanner;

public class BeautifulYear {

    public static boolean check(int year) {
        String temp = String.valueOf(year % 10);
        while(year > 0) {
            year = year/10;
            if(String.valueOf(year).contains(temp)) {
                return false;
            }
            temp =String.valueOf(year % 10);

        }
        return true;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        while(year > 0) {
            year = year + 1;
            if(check(year)) {
                System.out.print(year);
                break;
            }
        }

    }
}