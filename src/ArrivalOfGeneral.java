import java.util.Arrays;
        import java.util.OptionalInt;
        import java.util.Scanner;

public class ArrivalOfGeneral {

    static int findMinPos(int heights[], int number) {
        for(int i = heights.length-1; i >= 0; i--) {
            if(heights[i] == number) {
                return i;
            }
        }
        return -1;
    }

    static int findMaxPos(int heights[], int number) {
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String str[] = sc.nextLine().split("\\s+");

        int heights[] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        OptionalInt max  = Arrays.stream(heights).max();
        OptionalInt min = Arrays.stream(heights).min();

        int maxPos =0 , minPos = 0;

        minPos = findMinPos(heights, min.getAsInt());

        int count = 0;
        for(int i = minPos; i < size-1; i++) {
            int temp = heights[i];
            heights[i] = heights[i+1];
            heights[i+1] = temp;
            count++;
        }

        maxPos = findMaxPos(heights, max.getAsInt());
        for(int j = maxPos; j>0; j--) {
            int temp = heights[j];
            heights[j] = heights[j-1];
            heights[j-1] = temp;
            count++;
        }
        System.out.print(count);

    }

}
