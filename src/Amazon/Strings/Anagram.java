package Amazon.Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    static boolean isAnagram(String s1, String s2) throws Exception {
        if(s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if( !hm.containsKey(s1.charAt(i))) {
                hm.put(s1.charAt(i), 1);
            } else {
                hm.put(s1.charAt(i), 0);
            }

            if( !hm.containsKey(s2.charAt(i))) {
                hm.put(s2.charAt(i), 1);
            } else {
                hm.put(s2.charAt(i), 0);
            }
        }

        for(Map.Entry<Character, Integer> e : hm.entrySet()) {
            if(e.getValue() > 0) {
                System.out.println("Not an Anagram");
                return false;
            }
        }
        System.out.println("Is an Anagram");
        return true;
    }

    static boolean isAnagramByBit(String s1, String s2) {
        int value = 0;
        System.out.println(0^1);
        for(int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i) + " "  + i + " index ");
            value = value ^ (int)s1.charAt(i);
            System.out.println(value);
            value = value ^ (int)s2.charAt(i);
            System.out.println(value);
        }
        return value == 0;
    }
    public static void main(String... s) {
        try {
            String str = "geeks";
            String str2 = "eekgs";
            isAnagram(str, str2);
            System.out.println(isAnagramByBit(str, str2));
        }catch (Exception e) {
            System.out.println("Exception"+ e.getMessage());
        }
    }
}
