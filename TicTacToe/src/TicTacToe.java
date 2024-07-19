import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {
    static int w = 450, h = 500;
    public int markFlag = 0; //0が○、1が×
    public int counter = 0; //コマを置いたトータル回数
    public int oCounter = 0; //〇のコマ数
    public int xCounter = 0; //×のコマ数
    public int gameCounter = 1; //試合数
    public int oWinCounter = 0; //〇の勝利数
    public int xWinCounter = 0; //×の勝利数
    public int oHP = 10;
    public int xHP = 10;

    static JButton[] btns = new JButton[9];

    public TicTacToe () {
        //gui表示
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);

        //上
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(450, 50));

        JLabel label = new JLabel("○×ゲーム" );
        label.setFont(new Font("明朝体", Font.PLAIN, 30));
        topPanel.add(label);
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
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
