package task;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientOnce {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("入力値以下の最大素数を求めます。");
            System.out.println("数字を入力してください↓");
            int number = scanner.nextInt();
            scanner.close();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            TaskObject n = new TaskObject();
            n.setNumber(number);

            oos.writeObject(n);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject hanteiKekka = (TaskObject) ois.readObject();

            int replayNumber = hanteiKekka.getNumber();
            if (replayNumber == 0) {
                System.out.println(n + "は素数ではありません。");
            } else {
                System.out.println(n + "以下の最大素数は" + replayNumber + "です。");
            }

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}


