/**
 * Dice and Coin
 *
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main 
{
    public static void main( String[] args )
    {
        // Nの入力
        System.out.print( "N : " );
        var inputN = new Scanner(System.in);
        var N = inputN.nextInt();
        // Kの入力
        System.out.print( "K : " );
        var inputK = new Scanner(System.in);
        var K = inputK.nextInt();
        inputN.close();
        inputK.close();

        // 計算した勝つ確率を保存
        var winProbability = new BigDecimal(0);

        // サイコロの各面それぞれの勝つまでの表の出る回数を計算
        for (var i = 1; i <= N; i++ ){
            
            // 各サイコロの得点
            var diceScore = i;
            // コインの表の確率
            // コインを投げない場合も同様の公式で計算できるように一旦1を初期値として設定
            var coinObverseProbability = new BigDecimal(1.0000000000);

            // サイコロの各面の勝つ回数を数え終わるまでループ
            while(true)
            {
                // 点数を比較
                if(diceScore >= K){
                    // 勝った場合は確率を計算して保存
                    winProbability = winProbability.add(new BigDecimal(1.0000000000 / N).multiply(coinObverseProbability));
                    break;
                }else{
                    // 負けた場合は表が出たと仮定して点数と表が出た確率を計算
                    diceScore = diceScore * 2;
                    coinObverseProbability = coinObverseProbability.multiply(new BigDecimal(0.5000000000));
                }
            }
        }

        // 結果出力
        System.out.print(winProbability.setScale(9, RoundingMode.HALF_UP).toString());
    }
}
