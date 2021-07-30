import java.lang.Math;

/**
 * Dice and Coin
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // サイコロの面の数・・・N
        int N = Integer.parseInt(args[0]);
        // 勝つのに必要な得点・・・K
        int K = Integer.parseInt(args[1]);

        // サイコロの出目の確率
        double rateForDice = 1.0 / N;
        
        // 合計の確率
        double rate = 0;

        for (int i = 1; i <= N; i++) {
            int point = i;
            int count = 0;
            while (point < K) {
                point = point * 2;
                count++;
            }
            
            rate += rateForDice * Math.pow(0.5, count);
        }

        System.out.println(String.format("%.9f", rate));
    }
}
