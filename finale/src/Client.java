import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class Client {

    TicTacToe t;
    Action a;

    public Client(TicTacToe t) {
        this.t = t;
    }

    public Client(Action a) {
        this.a = a;
    }

    public static void main(String arg[]) {
        try {
            TicTacToe t = new TicTacToe(false);
            Action a = new Action(t);

            Socket socket = new Socket("localhost", 500);
            System.out.println("接続されました");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            if(!a.checkStart()) {
                Question que = (Question) ois.readObject();
                String msgAnswer = que.getQuestion();
                System.out.println("答え：" + msgAnswer);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("質問を入力してください。");
            String question = scanner.next();
            scanner.close();

            Question q = new Question();
            q.setQuestion(question);

            oos.writeObject(q);
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
            System.err.println("サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}

