package Amazon.Strings;

import javax.swing.event.MenuDragMouseListener;
import java.util.HashSet;

//public class AllPermutationsOfString {
//    static HashSet<String> hs = new HashSet<>();
//    static void printPermutations(String str, String printString) {
//        if(str.length() == 0) {
//            if(!hs.contains(printString)) {
//                System.out.print(printString + "  ");
//                hs.add(printString);
//            }
//        }
//        for(int i = 0; i < str.length(); i++) {
//
//            char beginningChar = str.charAt(i);
//            String beforeAfterBeginningChar = str.substring(0,i) + str.substring(i+1); //exclude i
//
//            printPermutations(beforeAfterBeginningChar, printString+beginningChar);
//        }
//    }
//    public static void main(String... s) {
//        String str = "abb";
//
//        printPermutations(str, "");
//    }
//}






public class AllPermutationsOfString {

    static void printPermutations(String s1, String word) {
        if(s1.length() == 0) {
            System.out.println(word);
        }

        for(int i = 0; i < s1.length(); i++) {
            char beg = s1.charAt(i);
            String remaining = s1.substring(0, i) + s1.substring(i+1);
            printPermutations(remaining, word + beg);
        }
    }

    static String checkIfPalidrome(String str, int start, int end) {
        String res = "NO";
        System.out.println("checking " + str);
        int i = start;
        int j = end;
        if(i == j) {
            System.out.println("PALINDROME " + str);
        }
        while(i < j) {
            System.out.println(str.charAt(i)  +  " == " + str.charAt(j) + "  " + i +  " " + j);
            if(str.charAt(i) != str.charAt(j)) {
                System.out.println("going to check for " + str.substring(i, end+1) +  "  " + str.substring(start, j+1) + " jhere : " + i + " = " + start +  " j " + j+" " + end );
                if(i != start && j != end) {
                    checkIfPalidrome(str.substring(i, end + 1), 0, str.substring(i, end + 1).length() - 1);
                    checkIfPalidrome(str.substring(start, j + 1), 0, str.substring(start, j + 1).length() - 1);
                } else {
                    break;
                }
            } else {
                i++;
                j--;
            }
        }
        System.out.println("BROKE");
        if(i == j+1) {
            System.out.println("PALINDROME " + str);
            return str;
        }
        return null;
    }

    static int lengthOfPalindome(String str, int i, int j) {
        if(i == j)
            return 1;

        if( i == j+1 && str.charAt(i) == str.charAt(j))
            return 2;

        if(str.charAt(i) == str.charAt(j))
            return (lengthOfPalindome(str, i + 1, j -1)) + 2;

        return Math.max(lengthOfPalindome(str, i, j-1), lengthOfPalindome(str, i+1, j));
    }

    static int maxCommonSubstring(String s1, String s2, int m, int n) {
        int L[][] = new int[m+1][n +1];
        int max = 0;
        String res = "";
        for(int i = 0 ; i < m+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    L[i][j] = L[i-1][j-1] + 1;
                    if(L[i][j] > max) {
                        res += s1.charAt(i-1);
                        max = L[i][j];
                    }
                }
            }
        }

        System.out.println(res);
        return max;
    }

    static void removeDuplicates(String str, int index, char lastRemoved, String res) {
        System.out.println(index);
        if(index == str.length()) {
            System.out.println(res);
            return;
        }
        if((index+1 <= str.length()-1 && str.charAt(index) == str.charAt(index + 1)) || str.charAt(index) == lastRemoved) {
            removeDuplicates(str, index+1, str.charAt(index), res);
        } else {
            System.out.println("ad index " + index);
            removeDuplicates(str, index+1, lastRemoved, res + str.charAt(index) );
        }
    }

    static void allPerms(String str, String word) {
        if(str.length() == 0) {
            System.out.println("string :" + word);
        }

        for(int i =0; i < str.length(); i++) {
            char beg = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i+1);
            allPerms(remaining, word + beg);
        }
    }

    public static void main(String[] args) {
        String s1 = "abc";

      //  printPermutations(s1, "");

        allPerms(s1, "");
//        String str = "aaaabbaa";
//      //  System.out.println("GOT MY ANSWER" + checkIfPalidrome(str, 0, str.length() - 1));
//        System.out.println("LONGEST COMMON" + maxCommonSubstring("GeeksForGeeks", "Geeks", 13, 5));
//        removeDuplicates("acaaabbbacdddd", 0, '\0', "");


    }

}
