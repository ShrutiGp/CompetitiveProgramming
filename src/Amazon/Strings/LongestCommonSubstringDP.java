//package Amazon.Strings;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class LongestCommonSubstringDP {
//
//    public String name;
//
//    public LongestCommonSubstringDP(String name) {
//        this.name = name;
//    }
//
//    public boolean equals(Object obj) {
//        LongestCommonSubstringDP longestCommonSubstringDP = (LongestCommonSubstringDP) obj;
//        return this.name == longestCommonSubstringDP.name;
//    }
//
//    public int hashCode() {
//        return this.name;
//    }
//
//    static int longestCommonPrefix(String s1, String s2, int m , int n) {
//
//        int result = 0;
//        int L[][] = new int[m+1][n+1];
//        String str = "";
//        for(int i = 0; i <=m; i++) {
//            for(int j = 0; j<=n; j++) {
//                if(i == 0 || j == 0)
//                    L[i][j] = 0;
//                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
//                    L[i][j] = L[i - 1][j - 1] + 1;
//                    if(L[i][j] > result) {
//                        str += s1.charAt(i-1);
//                        result = L[i][j];
//                    }
//                }
//                else
//                    L[i][j] = 0;
//            }
//        }
//        System.out.println("COMMON SUBSTRING: " + str);
//        return result;
//    }
//
//    static int longestPalindrome(String s1, int i, int j) {
//
//        if(i == j)
//            return 1;
//
//        if( (i+1 == j) && s1.charAt(i) == s1.charAt(j))
//            return 2;
//
//        if(s1.charAt(i) == s1.charAt(j)) {
//            return longestPalindrome(s1, i+1, j-1) + 2;
//        }
//
//        return Math.max(longestPalindrome(s1, i, j-1), longestPalindrome(s1, i+1, j));
//    }
//
//    //longest common subsequence - ( no need to be contigous)
//    static int lcsUsingRecusion(char X[], char Y[], int xsize, int ysize){
//        if(xsize == 0 || ysize == 0) {
//            return 0;
//        }
//
//        if(X[xsize - 1] == Y[ysize - 1]) {
//            return 1 + lcsUsingRecusion(X, Y, xsize - 1, ysize - 1);
//        }
//
//        return Math.max(lcsUsingRecusion(X, Y, xsize - 1, ysize), lcsUsingRecusion(X, Y, xsize, ysize - 1));
//    }
//
//    // longest common substring - needs to be contigous
//    static int lcSubstringUsingRecursion(char X[], char Y[], int xsize, int ysize, int count) {
//        if(xsize == 0 || ysize == 0) {
//            return count;
//        }
//
//        if(X[xsize - 1] == Y[ysize - 1]) {
//            count =  lcSubstringUsingRecursion(X, Y, xsize - 1, ysize - 1, count + 1);
//        } else
//            count =  Math.max(lcSubstringUsingRecursion(X, Y, xsize - 1, ysize, 0), lcSubstringUsingRecursion(X, Y, xsize, ysize - 1, 0));
//
//        return count;
//    }
//
//    static int longestIncreasingSubsequenceUsingDP(char X[], char Y[], int m, int n) {
//        //using tabulation
//
//        int lcs[][] = new int[m + 1][n + 1];  // all 0 indices will be used for calculation and have value 0
//
//        for(int i = 0; i <=m; i++) {
//            for(int j = 0 ; j <= n; j++) {
//                if(i == 0 || j == 0)
//                    lcs[i][j] = 0;
//
//                if(X[i-1] == Y[j-1]) {
//                    lcs[i][j] = lcs[i-1][j-1] + 1;
//                } else {
//                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j - 1]);
//                }
//            }
//        }

//
//        return lcs[m][n];
//
//    }
//
//    static String remmoveDuplicates(String str) {
//
//        str = str.toLowerCase();
//        char ch[] = str.toCharArray();
//        Arrays.sort(ch);
//
//        int index = 1;
//        int lastVisited = ch[0];
//        for(int i = 1; i < ch.length; i++) {
//            if(ch[i] != lastVisited) {
//                lastVisited = ch[i];
//                ch[index] = ch[i];
//                index++;
//            }
//        }
//        str = String.valueOf(ch);
//        System.out.println(str);
//        return str.substring(0, index);
//    }
//
//
//    static boolean isAnagram(String str1, String str2) {
//
//        if(str1.length() != str2.length())
//            return false;
//
//        int value = 0;
//        for(int i =0; i  < str1.length(); i++) {
//            value = value ^ (int)str1.charAt(i);
//            value = value ^ (int) str2.charAt(i);
//        }
//
//        return value == 0;
//    }
//
//    static int longestCommonSUBSTRINGusingDP(char X[], char Y[], int m, int n) {
//        int lcs[][] = new int[m+1][n+1];
//
//        int result = 0;
//        String str = "";
//
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if( i == 0 || j == 0)
//                    lcs[i][j] = 0;
//
//                if(X[i-1] == Y[j-1]) {
//                    lcs[i][j] = lcs[i-1][j-1] + 1;
//                    if(result < lcs[i][j]) {
//                        str += X[i - 1];
//                        result = lcs[i][j];
//                    }
//                } else {
//                    lcs[i][j] = 0;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    static int lengthPalidrome(String str, int start, int end) {
//
//        if(start == end) {
//            return 1;
//        }
//
//        if(start + 1 == end && str.charAt(start) == str.charAt(end)) {
//            return 2;
//        }
//
//        if(str.charAt(start) == str.charAt(end)) {
//            return lengthPalidrome(str, start+1, end-1) + 2;
//        }
//
//        return Math.max(lengthPalidrome(str, start, end-1), lengthPalidrome(str, start+1,end));
//    }
//
//    static void removeDuplicates(String str, char lastRemoved, int i, String res) {
//        if(i == str.length()-1) {
//            System.out.println("Reached end "+ res);
//            return;
//        }
//        if(str.charAt(i) == str.charAt(i+1) || str.charAt(i) == lastRemoved) {
//            lastRemoved = str.charAt(i);
//            removeDuplicates(str, lastRemoved, i+1, res);
//        } else {
//            removeDuplicates(str, lastRemoved, i+1, res + str.charAt(i));
//        }
//
//    }
//
//
//    public static void  removeDuplicate(String str, int lastRemoved, int currentIndex, String res) {
//
//        if(currentIndex == str.length() - 1) {
//            if(str.charAt(str.length() - 1) != lastRemoved) {
//                res += str.charAt(str.length() - 1);
//            }
//            System.out.println("String " + res);
//            return;
//        }
//
//        if(str.charAt(currentIndex) == str.charAt(currentIndex + 1) || str.charAt(currentIndex) == lastRemoved) {
//            lastRemoved = str.charAt(currentIndex);
//            removeDuplicate(str, lastRemoved, currentIndex + 1, res);
//        } else {
//            removeDuplicate(str, lastRemoved, currentIndex + 1, res + str.charAt(currentIndex));
//        }
//    }
//
//    public static int lengthOfLongestSubstring(String s) {
//        if(s==null||s.length()==0){
//            return 0;
//        }
//
//        HashSet<Character> set = new HashSet<>();
//        int result = 1;
//        int i=0;
//        for(int j=0; j<s.length(); j++){
//            char c = s.charAt(j);
//            if(!set.contains(c)){
//                System.out.println("Added to set : " + c);
//                set.add(c);
//                result = Math.max(result, set.size());
//            }else{
//                System.out.println("not added to set : " + c);
//                while(i<j){
//                    if(s.charAt(i)==c){
//                        i++;
//                        System.out.println("New Index : " + i);
//                        break;
//                    }
//
//                    set.remove(s.charAt(i));
//                    i++;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    static int longestDistinct(String str) {
//        HashSet<Character> hs = new HashSet<>();
//        int result = 1;
//
//        int start = 0;
//        for(int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if(!hs.contains(ch)) {
//                hs.add(ch);
//                result = Math.max(result, hs.size());
//            } else {
//                while(start < i) {
//                    if(str.charAt(start) == ch) {
//                        start++;
//                        break;
//                    }
//                    hs.remove(str.charAt(start));
//                    start++;
//                }
//            }
//        }
//
//        return result;
//
//    }
//
//    static void lcsinarray() {
//        String[] arr = {"geeksforgeeks", "geeks" ,"geek"};
//        int size = arr.length;
//        int min = Integer.MAX_VALUE;
//        String minString = null;
//        for(int j =0 ; j<size; j++) {
//            if(arr[j].length() < min) {
//                min = arr[j].length();
//                minString = arr[j];
//            }
//        }
//
//        int length = minString.length();
//        String check = minString.substring(0, length);
//        boolean found = true;
//        for(int j = 0; j < size; j++) {
//            if(arr[j].indexOf(check) == -1) {
//                found = false;
//            }
//            if(j == size-1 && found) {
//                System.out.println(check);
//                break;
//            }
//            if(arr[j].indexOf(check) == -1 && length > 2) {
//                j = 0;
//                check = minString.substring(0, --length);
//                found = true;
//            }
//        }
//        if(found == false) {
//            System.out.println("-1");
//        }
//    }
//
//
//    static void lcsAllowed() {
//        String[] arr = {"geeksforgeeks", "geeks" ,"geek"};
//
//        int min = Integer.MAX_VALUE;
//        String minString = null;
//        for(int i = 0; i < arr.length; i++) {
//            if(arr[i].length() < min) {
//                min = arr[i].length();
//                minString = arr[i];
//            }
//        }
//        boolean found = false;
//        int i = 0;
//        while(i < arr.length) {
//            if(arr[i].indexOf(minString) >= 0) {
//                found = true;
//            }
//            else if(minString.length() > 2) {
//                minString = minString.substring(0, minString.length()-1);
//                if()
//            }
//        }
//
//
//    }
//
//    static int longestCommonSubsequence(char X[], char Y[], int x, int y) {
//        if(x == 0 || y == 0)
//            return 0;
//
//        if(X[x - 1] == Y[y-1] ) {
//            return 1 + longestCommonSubsequence(X, Y, x-1, y-1);
//        }
//
//        return Math.max(longestCommonSubsequence(X, Y, x -1, y), longestCommonSubsequence(X, Y, x, y-1));
//    }
//
//    public static void main(String... s) {
//        String l = "geeksforgeeks";
//        System.out.println("LONGEST SUBSTRING : " + lengthOfLongestSubstring(l));
//        System.out.println("is ana " + isAnagram("Shruti", "itruSh"));
//        System.out.println(" i need answ : " + remmoveDuplicates("GeeksForGeek"));
//
//        String st = "geeksforgeek";
//        removeDuplicate(st, '\0', 0, "");
//
//        int c = lengthPalidrome(st, 0, st.length() - 1);
//        System.out.println("c :" + c);
////        String st1 = "abcdxyzs";
////        String st2 = "xyzabcd";
////
//////        System.out.println(longestCommonPrefix(st1, st2, st1.length(), st2.length()));
//////        System.out.println(longestPalindrome(st1, 0, st1.length()-1));
//////
//////        removeDuplicates(st1, '\0', 0, "");
////
////
////        char X[] = st1.toCharArray();
////        char Y[] = st2.toCharArray();
////        System.out.println(lcSubstringUsingRecursion(X, Y, st1.length(), st2.length(), 0));
////        lcsUsingRecusion(X, Y, st1.length(), st2.length());
////    }
//    }
//}
