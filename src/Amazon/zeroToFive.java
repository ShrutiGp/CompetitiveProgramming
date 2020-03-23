package Amazon;

/* Given a integer as a input and replace all the ‘0’ with ‘5’ in the integer.
Examples:

    102 - 152
    1020 - 1525  */

public class zeroToFive {
    static int printResult(int num) {
        if(num == 0) {
            return 0;
        }
        int digit = num % 10;
        if(digit == 0)
            digit =5;
        return printResult(num/10)*10 + digit;
    }
    public static void main(String[] args) {
        String num = "102";
     //   System.out.println(num.replace('0', '5'));
        int number = 102;
        System.out.println("number : " + printResult(number));
    }
}
