import java.util.Arrays;
import java.util.Scanner;

public class BeautifulMatrix {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s[] = new String[5];
        for(int i=0; i<5; i++){
            s[i] = sc.nextLine();
        }
        int r=0, c=0;
        for(int row=0; row <=5; row++) {
            String array[] = s[row].split(" ");
            int col = Arrays.asList(array).indexOf("1");
            if(col >= 0){
                r = row;
                c = col;
                break;
            }
        }

        int rowdiff = r-2>0 ? r-2 : 2-r;
        int coldiff = c-2>0 ? c-2 : 2-c;
        System.out.println(rowdiff+coldiff);
    }
}
