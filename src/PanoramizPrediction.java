import java.util.Scanner;

public class PanoramizPrediction{

    public static void main(String... s) {

        Scanner sc = new Scanner(System.in);
        String soldiers[] = sc.nextLine().split(" ");
        int firstPrime = Integer.parseInt(soldiers[0]);
        int second = Integer.parseInt(soldiers[1]);

        while(firstPrime>0) {
            boolean isPrime = true;
            firstPrime++;
            for(int i = 2; i <= firstPrime/2; i++) {
                if(firstPrime%i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                if (firstPrime == second) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
                break;
            }
        }
    }
}
