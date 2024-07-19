import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    TicTacToe t;

    public Server(TicTacToe t) {
        this.t = t;
    }
    public static void main(String arg[]) {
        try {
            TicTacToe t = new TicTacToe(true);
            /* 通信の準備をする */
			ServerSocket server = new ServerSocket(5002);		//ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("相手の接続を待っています。");

            Socket socket = server.accept();	//クライアントからの接続要求を待ち、
                             // 要求があればソケットを取得し接続を行う
            System.out.println("接続されました");


            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Question que = (Question) ois.readObject();
            
            String msgQuestion = que.getQuestion();
            System.out.println("質問：" + msgQuestion);

            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("質問に答えてください。");
            String answer = reader.readLine();

            Question response = new Question();
            response.setAnswer(answer);

            oos.writeObject(response);
            oos.flush();

            ois.close();
            oos.close();
            socket.close();
            server.close();
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
