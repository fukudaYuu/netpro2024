import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
		int i=0;
		while(i<10) {
			Scanner scan = new Scanner(System.in);

			String str = scan.next();
			int first = Integer.parseInt(str);
			System.out.println("最初のトークンは: " + str);

			str = scan.next();
			int second = Integer.parseInt(str);
			System.out.println("次のトークンは  : " + str);
			
			System.out.println(i + "回目の合計は ： " + (first + second));

			i++;
		}


	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。
