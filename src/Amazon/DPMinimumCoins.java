package Amazon;

public class DPMinimumCoins {

    static int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    int findMinimum(int num) {
        int res = 1;
        for(int i = coins.length - 1; i >= 0; i--) {
            if(coins[i] <= num) {
                res = coins[i];
                break;
            }
        }
        return res;
    }

    int getMinimumCoins(int num) {
        if (num == 0)
            return 0;

        int coin = findMinimum(num);
        int n1 = num / coin;
        return n1 + getMinimumCoins(num % coin);
    }

    public static void main(String[] args) {
        int num = 43;
        DPMinimumCoins dpMinimumCoins = new DPMinimumCoins();

        System.out.println(dpMinimumCoins.getMinimumCoins(43));
    }
}
