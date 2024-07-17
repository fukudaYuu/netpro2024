package a;

public class PrimeTwinMain {

    public static void main(String[] args) {
        // 小さい順に全ての素数が呼ばれている前提

        int k = 0;
        int I = 1;

        for(int i = 3; i <= 40000; i++) {
            for(int j = 2; j*j < i; j++) {
                if (i % j == 0) {
                    k = 1;
                }
            }
            if (k == 0) {
                if (i - I  == 2) {
                    System.out.println(i);
                }
                I = i;
            }
            k = 0;
        }

    //     boolean[] prime = new boolean[100];
    //     int k;
    //     for(int i = 1; i < prime.length; i ++) {
    //         prime[i] = true;
    //     }

    //     for(int i = 3; i < prime.length; i++) {
    //         for (int j = 2; j * j <= i; j++){
    //             if (i % j == 0) {
    //                 prime[i] = false;
    //                 break;
    //             }
    //         }
    //     }

    //     for (int i = 3; i < prime.length; i ++) {
    //         if(prime[i]) {
    //             System.out.println(prime[i]);
    //             k = i;
    //             if(i - k == 1) {
    //                 System.out.println(i);
    //             }
    //         }
    //     }
    }
}
