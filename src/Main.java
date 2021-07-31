package src;

/**
 * Dice and Coin
 *
 */
public class Main {
    public static void main(String[] args) {
        int N = 3;
        int K = 10;
        int coinNum = 0;

        for (int i = 1; i <= N; i++) {
            coinNum = i;
            int num = 0;
            while (true) {

                num += 1;
                coinNum = coinNum * 2;

                if (coinNum >= K) {
                    System.out.println(String.valueOf(num) + "回目");
                    break;
                } else {

                }
            }
        }
    }
}

