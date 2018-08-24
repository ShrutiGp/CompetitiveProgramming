import java.util.Arrays;
import java.util.Scanner;

public class Tram {

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int noOfTrams = Integer.parseInt(sc.nextLine());
        int count[][] = new int[noOfTrams][2];
        for(int i = 0; i < noOfTrams; i++) {
            count[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int countPassengers = count[0][1];
        int temp = count[0][1];
        for(int i=1; i < noOfTrams-1; i++) {
            temp = temp - count[i][0] + count[i][1];
            countPassengers = temp>countPassengers ? temp : countPassengers;
        }
        System.out.print(countPassengers);
    }
}
