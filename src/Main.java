import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Dice and Coin
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        // 標準入力から「サイコロの出目」と「最大得点」を取得
        Scanner scanner = new Scanner(System.in); 
        int diceEyes = Integer.parseInt(scanner.next());    // サイコロの出目
        int maxScore = Integer.parseInt(scanner.next());    // 最大得点
        scanner.close();

        BigDecimal winRate = new BigDecimal("0");   // 勝率

        // サイコロの出目の数だけループ
        for (int i = 1; i <= diceEyes; i++) {
            // 最大得点以上になる為には何回連続でコインの表を出す必要があるか算出
            int numOfCoin = calculateNumOfCoin(i, maxScore);

            // サイコロの出目毎の勝率を集計
            winRate = winRate.add(calculateWinRate(diceEyes, numOfCoin));
        }

        // 小数点第10位以下を四捨五入
        winRate = winRate.setScale(9, RoundingMode.HALF_UP);

        // 勝率を出力
        System.out.println(winRate);
    }

    /**
     * 最大得点以上になる為には何回連続でコインの表を出す必要があるか算出します。
     * @param score 得点
     * @param maxScore 最大得点
     * @return コインを振る回数
     */
    private static int calculateNumOfCoin(int score, int maxScore)
    {
        int numOfCoin = 0;  // コインを振る回数

        // 最大得点未満の間ループ
        while (score < maxScore) {
            numOfCoin++;    // コインを振る回数をカウントアップ
            score *= 2;     // コインの表が出たら得点は2倍
        }

        return numOfCoin;
    }

    /**
     * 勝率を算出します。
     * @param diceEyes サイコロの出目
     * @param numOfCoin コインを振る回数
     * @return 勝率
     */
    private static BigDecimal calculateWinRate(int diceEyes, int numOfCoin)
    {
        final double COIN_PROBABILITY = 0.5;    // コインの表と裏が出る確率は同じ

        // 勝率を算出
        // ※勝率 ＝ サイコロの出目の確率 × 最大得点以上になるまで連続でコインの表が出る確率
        double winRate = (1 / (double)diceEyes) * Math.pow(COIN_PROBABILITY, (double)numOfCoin);

        return new BigDecimal(String.valueOf(winRate));
    }
}
