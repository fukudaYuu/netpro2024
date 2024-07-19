import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する

public class Client {
    TicTacToe t;

    public Client(TicTacToe t) {
        this.t = t;
    }

    public static void main(String arg[]) {
        try {
            TicTacToe t = new TicTacToe(false);
            /* 通信の準備をする */
			BufferedReader reader =		//キーボードから接続するサーバ名を読み込む
            new BufferedReader(new InputStreamReader(System.in));
            System.out.print("サーバーネームを入力してください。(localhost or 133.27.....)? >");
            String serverName = reader.readLine();
            Socket socket =			//指定されたサーバの5000番ポートに接続を要求する
            new Socket(serverName, 5002);

            System.out.println("質問を入力してください。");
            String question = reader.readLine();
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Question q = new Question();
            q.setQuestion(question);
            oos.writeObject(q);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
            Question que = (Question) ois.readObject();
            String msgAnswer = que.getAnswer();
            System.out.println("答え：" + msgAnswer);

            
            ois.close();
            oos.close();
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

