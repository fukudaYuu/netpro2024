import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    TicTacToe t;
    Action a;

    public Server(TicTacToe t) {
        this.t = t;
    }

    public Server(Action a) {
        this.a = a;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            TicTacToe t = new TicTacToe(true);
            Action a = new Action(t);

            ServerSocket serverSocket = new ServerSocket(500); // ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("localhostの" + serverSocket + "番ポートに接続します");

            Socket socket = serverSocket.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Question que = (Question) ois.readObject();
            
            String msgQuestion = que.getQuestion();
            System.out.println("質問：" + msgQuestion);
            Scanner scanner = new Scanner(System.in);
            System.out.println("質問に答えてください。");
            String answer = scanner.next();
            scanner.close();

            Question response = new Question();
            response.setAnser(answer);

            oos.writeObject(response);
            oos.flush();

            new Thread(() -> {
                try {
                    while (true) {
                        int index = ois.readInt();
                        String mark = ois.readUTF();
                        a.changeMark(index, mark);
                        a.winCheck();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();

            socket.close();
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポートにつながりません。");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
