package c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// （令和ー明治 2024-1989を対応すること　元号は元年（１年）優先　月は考慮しない）
//以下のコードの修正１－３を中心に治すこと　クライアントの修正は必要ないが修正してもよい。
//サーバのみ提出すること。（クライアントを修正してひとはその点明記してクライアントも提出）

public class GYServer {
    public static void main(String[] args) {
        int portNumber = 12345;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                //修正点１
                //修正点１
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static String convertToEra(int year) {
        String era="元号範囲外";
        int gyear=1989;

        //修正点2 15行程度
        // （令和ー明治 2024-1989を対応すること　元号は元年（１年）優先　月は考慮しない）
        //修正点2 15行程度
        //修正点2 15行程度
        //修正点2 15行程度

        if (year <= 1911) {
            era = "明治";
            year = year - 1867;
        } else if (year >= 1912 && year <= 1925) {
            era = "大正";
            year = year - 1911;
        }else if (year >= 1926 && year <=  1988) {
            era = "昭和";
            year = year - 1925;
        } else if (year >= 1989 && year <= 2018) {
            era = "平成";
            year = year - 1988;
        } else {
            era = "令和";
            year = year - 2018;
        }
        if (year == 1) return era + "元年";
        else return era + year;
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String clientMessage;
                while ((clientMessage = input.readLine()) != null) {
                    if (clientMessage.equalsIgnoreCase("quit")) {
                        break;
                    }
                    //修正点3
                    //修正点3
                    //修正点3
                }
            } catch (IOException e) {
                System.err.println("ClientHandler error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }
}

