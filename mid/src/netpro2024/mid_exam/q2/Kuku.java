package netpro2024.mid_exam.q2;

public class Kuku {
    public static void main(String args[]) {
       //ここに実装
        /* ↓下記を埋める。*/
        int n;
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                n = i * j;
                String result = String.format("%2d", n);
                System.out.print("|" + result);
            }
            System.out.println("|");
        }
        /* ↑上記を埋める。*/
    }
}

