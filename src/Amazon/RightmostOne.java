package Amazon;
/* Write a one line function to return position of first 1 from right to left, in binary representation of an Integer.

I/P    18,   Binary Representation 010010
O/P   2
I/P    19,   Binary Representation 010011
O/P   1 */
public class RightmostOne {

    static char flipBit(char ch) {
        return ch == '1' ? '0' : '1';
    }

    static String onesComplement(String num) {
        String ones = "";
        char  ch[] = num.toCharArray();
        for(int i =0; i < ch.length; i ++) {
            ones += flipBit(ch[i]);
        };
        return ones;
    }

    static String twosComplement(String num) {
        int zeroLastIndex = num.lastIndexOf('0');
        String twos = "";
        if(zeroLastIndex == -1) {
            twos = 1 + onesComplement(num);
            return twos;
        }
        twos = num.substring(0, zeroLastIndex) + 1;
        if(zeroLastIndex < num.length() - 1) {
            twos += onesComplement(num.substring(zeroLastIndex + 1));
        }
        return twos;
    }

    public static void main(String[] args) {
        String binary = "0011";
        System.out.println("ones complement : "+ onesComplement(binary)  + "    " + twosComplement(onesComplement(binary)));
        System.out.println("12  "+ ((Math.log10(12 & -12)) / Math.log10(2)));

        System.out.println("complement : "+ Math.log10(12 & -12)  +"   " + Math.log10(2));

    }
}
