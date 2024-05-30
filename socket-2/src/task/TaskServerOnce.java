package task;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskServerOnce {
    private static int serverProcess(int n) {
            boolean[] primeIs = new boolean[n+1];
            Arrays.fill(primeIs, true);
            List<Integer> primes = new ArrayList<>();
            
            for (int p = 2; p*p <= n; p++) {
                if (primeIs[p]) {
                    for (int i = p*p; i <= n; i += p) {
                        primeIs[i] = false;
                    }
                }
            }
        
            for (int p = 2; p <= n; p++) {
                if (primeIs[p]) {
                    primes.add(p);
                }
            }
            int Max = primes.get(primes.size() - 1);

            return Max;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject n = (TaskObject) ois.readObject();// Integerクラスでキャスト。

            int num = n.getNumber();

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            TaskObject response = new TaskObject();
            response.setNumber(serverProcess(num));

            oos.writeObject(response);
            oos.flush();

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}

