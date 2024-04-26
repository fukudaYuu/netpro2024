// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
            while (true) {
                int genzai = 2024;
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                int age = Integer.parseInt(line);

                if (age >= 0 && age < 120) /*正しく答えているとき*/{
                    System.out.println("あなたは" + age + "歳ですね。");
                    System.out.println("2030年のあなたは、" + (age + 2030 - genzai) + "歳ですね。");
                    
                    //年代を出す
                    int seireki;
                    seireki = genzai - age;

                    String gengou;
                    int wareki;

                    if (seireki <= 1911) {
                        gengou = "明治";
                        wareki = seireki - 1867;
                    } else if (seireki >= 1912 && seireki <= 1925) {
                        gengou = "大正";
                        wareki = seireki - 1911;
                    }else if (seireki >= 1926 && seireki <=  1988) {
                        gengou = "昭和";
                        wareki = seireki - 1925;
                    } else if (seireki >= 1989 && seireki <= 2018) {
                        gengou = "平成";
                        wareki = seireki - 1988;
                    } else {
                        gengou = "令和";
                        wareki = seireki - 2018;
                    }
                    //出力
                    if (wareki == 1) System.out.println("あなたは" + gengou + "元年生まれです。");
                    else System.out.println("あなたは" + gengou + wareki + /* seireki + */  "年生まれです。");

                    /*String gengou;
                    int n = 0;
                    String gan = "元年";
                    if (age >= 97) {
                        gengou = "明治";
                    } else if (age <= 96 && age >= 36) {
                        gengou = "昭和";
                        n = age + 21;
                    } else if (age <= 35 && age >= 6) {
                        gengou = "平成";
                    } else {
                        gengou = "令和";
                        n = 6 - age;
                    }

                    //出力
                    System.out.print("あなたは" + gengou);
                    if (n == 1) {
                        System.out.print("元");
                    } else {
                        System.out.print(n);
                    }
                    System.out.println("年生まれです。");*/

                } else if /*終了*/(age == 'q' || age == 'e') {
                    break;
                } else /*正しく答えていないとき*/{
                    System.out.print("もう一度お聞きします。");
                }
            }
        }
		catch(IOException e) {
			System.out.println(e);
		}


	}
}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。