import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {
    static int w = 450, h = 600;
    public int markFlag = 1; //0が○、1が×
    public int oCounter = 0; //○の数
    public int xCounter = 0; //×の数

    static JButton[] btns = new JButton[9];
    private Socket socket;
    public ObjectOutputStream oos;
    public ObjectInputStream ois;
    public boolean isServer;

    public TicTacToe(boolean isServer) {
        try {
            if(isServer) {
                ServerSocket serverSocket = new ServerSocket();
                socket = serverSocket.accept();
                markFlag = 0;
            } else {
                socket = new Socket("localhost", 500);
                markFlag = 1;
            }

            //gui表示
            JFrame frame = new JFrame("Tic Tac Toe");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(w, h);
            frame.setLocationRelativeTo(null);

            //上
            JPanel topPanel = new JPanel();
            topPanel.setPreferredSize(new Dimension(450, 150));

            JLabel oCountLabel = new JLabel("○: " + oCounter);
            topPanel.add(oCountLabel);
            JLabel xCountLabel = new JLabel("×: " + xCounter);
            topPanel.add(xCountLabel);
            frame.add(topPanel, BorderLayout.NORTH);

            //三目並べのマス
            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new GridLayout(3, 3));

            for (int i = 0; i < 9; i++) {
                btns[i] = new JButton("");
                btns[i].setBackground(Color.white);
                btns[i].setFont(new Font("明朝体", Font.PLAIN, 90));
                btnPanel.add(btns[i]);
                btns[i].addActionListener(new Action(this));
            }
            frame.add(btnPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}