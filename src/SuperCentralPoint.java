import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperCentralPoint {

    static boolean checkList(List<Integer> list, int element) {
        List<Integer> l = list.stream().sorted().collect(Collectors.toList());
        if(l.size() >= 3 && (l.indexOf(element) != 0 && l.indexOf(element) != l.size()-1)) {
            return true;
        }
        return false;
    }
    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int xcords[] = new int[n];
        int ycords[] = new int[n];

        for(int i = 0; i <n ; i++) {
            int arr[]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            xcords[i] = arr[0];
            ycords[i] = arr[1];
        }

        int count = 0;
        for(int i = 0; i < n;i++) {
            int x = xcords[i];
            int y = ycords[i];

            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            for(int j = 0; j < n;j++) {
                if(xcords[j] == x) {
                    list.add(ycords[j]);
                }
                if(ycords[j] == y) {
                    list1.add(xcords[j]);
                }
            }

            if(checkList(list, y) && checkList(list1,x)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
