import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Action extends JFrame implements ActionListener {
    TicTacToe t;

    public Action(TicTacToe t) {
        this.t = t;
    }

    public void actionPerformed (ActionEvent e) {
        //どのボタン押したか
        JButton btnClick = (JButton) e.getSource();

        //空白の場合のみ実行
        if (btnClick.getText().equals("")) {
            if(t.markFlag == 0) { //〇の番
                btnClick.setText("○");
                t.markFlag = 1;
                t.oCounter += 1;
            } else if (t.markFlag == 1) { //×の番
                btnClick.setText("×");
                t.markFlag = 0;
                t.xCounter += 1;
            }
            t.counter += 1;
            //ターミナル表示
            System.out.println(t.gameCounter + "試合" + t.counter + "手目");
            System.out.println("〇の数: " + t.oCounter);
            System.out.println("×の数: " + t.xCounter);
            System.out.println();
            winCheck();
            if(t.markFlag == 0) {
                System.out.println("〇の番です");
            } else {
                System.out.println("×の番です");
            }
        }
    }

    public void winCheck() {
        if (winO()) {
            System.out.println("〇が勝ちました！");
            t.oWinCounter += 1;
            t.xHP -= t.oCounter;
            System.out.println("試合数: " + t.gameCounter);
            System.out.println("〇の勝利数: " + t.oWinCounter + ", 残りHP :" + t.oHP);
            System.out.println("×の勝利数: " + t.oWinCounter+ ", 残りHP :" + t.xHP);
            JOptionPane.showMessageDialog(this,"〇の勝ち！", "winner", JOptionPane.PLAIN_MESSAGE);
            if(xHP0()) {
                totalOWin();
            }
            t.markFlag = 1;
            reset();
        } else if (winX()) {
            System.out.println("×が勝ちました！");
            t.gameCounter += 1;
            t.xWinCounter += 1;
            t.oHP -= t.xCounter;
            System.out.println("試合数: " + t.gameCounter);
            System.out.println("〇の勝利数: " + t.oWinCounter + ", 残りHP :" + t.oHP);
            System.out.println("×の勝利数: " + t.oWinCounter+ ", 残りHP :" + t.xHP);
            JOptionPane.showMessageDialog(this,"×の勝ち！", "winner", JOptionPane.PLAIN_MESSAGE);
            if(oHP0()) {
                totalXWin();
            }
            t.markFlag = 0;
            reset();
        } else if (draw()) {
            System.out.println("引き分け！");
            t.gameCounter += 1;
            System.out.println("試合数: " + t.gameCounter);
            System.out.println("〇の勝利数: " + t.oWinCounter + ", 残りHP :" + t.oHP);
            System.out.println("×の勝利数: " + t.oWinCounter+ ", 残りHP :" + t.xHP);
            JOptionPane.showMessageDialog(this,"引き分け！", "draw", JOptionPane.PLAIN_MESSAGE);
            reset();
        }
    }

    public boolean winO () {
        if (
            //横揃い
            ("○".equals(t.btns[0].getText()) && "○".equals(t.btns[1].getText()) && "○".equals(t.btns[2].getText())) ||
            ("○".equals(t.btns[3].getText()) && "○".equals(t.btns[4].getText()) && "○".equals(t.btns[5].getText())) ||
            ("○".equals(t.btns[6].getText()) && "○".equals(t.btns[7].getText()) && "○".equals(t.btns[8].getText())) ||
            //縦揃い
            ("○".equals(t.btns[0].getText()) && "○".equals(t.btns[3].getText()) && "○".equals(t.btns[6].getText())) ||
            ("○".equals(t.btns[1].getText()) && "○".equals(t.btns[4].getText()) && "○".equals(t.btns[7].getText())) ||
            ("○".equals(t.btns[2].getText()) && "○".equals(t.btns[5].getText()) && "○".equals(t.btns[8].getText())) ||
            //斜め揃い
            ("○".equals(t.btns[0].getText()) && "○".equals(t.btns[4].getText()) && "○".equals(t.btns[8].getText())) ||
            ("○".equals(t.btns[2].getText()) && "○".equals(t.btns[4].getText()) && "○".equals(t.btns[6].getText()))
            ) {
                return true;
        } else {
            return false;
        }
    }

    public boolean winX () {
        if (
            //横揃い
            ("×".equals(t.btns[0].getText()) && "×".equals(t.btns[1].getText()) && "×".equals(t.btns[2].getText())) ||
            ("×".equals(t.btns[3].getText()) && "×".equals(t.btns[4].getText()) && "×".equals(t.btns[5].getText())) ||
            ("×".equals(t.btns[6].getText()) && "×".equals(t.btns[7].getText()) && "×".equals(t.btns[8].getText())) ||
            //縦揃い
            ("×".equals(t.btns[0].getText()) && "×".equals(t.btns[3].getText()) && "×".equals(t.btns[6].getText())) ||
            ("×".equals(t.btns[1].getText()) && "×".equals(t.btns[4].getText()) && "×".equals(t.btns[7].getText())) ||
            ("×".equals(t.btns[2].getText()) && "×".equals(t.btns[5].getText()) && "×".equals(t.btns[8].getText())) ||
            //斜め揃い
            ("×".equals(t.btns[0].getText()) && "×".equals(t.btns[4].getText()) && "×".equals(t.btns[8].getText())) ||
            ("×".equals(t.btns[2].getText()) && "×".equals(t.btns[4].getText()) && "×".equals(t.btns[6].getText()))
            ) {
                return true;
        } else {
            return false;
        }
    }

    public boolean draw () {
        for(int i = 0; i < 9; i++) {
            if ("".equals(t.btns[i].getText())) {
                return false;
            }
        }
        return true;
    }

    public void reset() {
        for(int i = 0; i < 9; i++) {
            t.btns[i].setText("");
        }
        t.gameCounter += 1;
        t.counter = 0;
        t.oCounter = 0;
        t.xCounter = 0;
        System.out.println();
    }

    public boolean oHP0() {
        if (t.oHP <= 0) return true;
        else return false;
    }

    public void totalOWin () {
        System.out.println();
        System.out.println("×のHPがゼロになりました！！");
        System.out.println(t.gameCounter + "試合で終了！〇の勝ち！！");
        JOptionPane.showMessageDialog(this, t.gameCounter + "試合で終了！〇の勝ち！！", "champion", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

    public boolean xHP0() {
        if (t.xHP <= 0) return true;
        else return false;
    }

    public void totalXWin () {
        System.out.println();
        System.out.println("〇のHPがゼロになりました！！");
        System.out.println(t.gameCounter + "試合で終了！×の勝ち！！");
        JOptionPane.showMessageDialog(this, t.gameCounter + "試合で終了！×の勝ち！！", "champion", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

}



