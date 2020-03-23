package Amazon.Strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseSentence {

    static void reverse(String str) {
        System.out.println(str);
        String s1[] = str.split("\\.");

        int i = 0, j = s1.length-1;
        while( i < j) {
            String temp = s1[i];
            s1[i] = s1[j];
            s1[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.stream(s1).collect(Collectors.joining(".")));
    }
    public static void main(String... s) {
        reverse("i.like.this.program.very.much");
    }
}
