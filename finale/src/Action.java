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
            if(t.markFlag == 0) {
                btnClick.setText("○");
                t.oCounter += 1;
                t.markFlag = 1;
            } else if (t.markFlag == 1) {
                btnClick.setText("×");
                t.xCounter += 1;
                t.markFlag = 0;
            }
            winCheck();
        }
    }

    public void changeMark (int index, String mark) {
        t.btns[index].setText(mark);
        t.btns[index].setEnabled(false);
    }

    public void winCheck() {
        if (winO()) {
            JOptionPane.showMessageDialog(this,"○の勝ち！", "winner", JOptionPane.PLAIN_MESSAGE);
            reset();
        } else if (winX()) {
            JOptionPane.showMessageDialog(this,"×の勝ち！", "winner", JOptionPane.PLAIN_MESSAGE);
            reset();
        } else if (draw()) {
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

    public boolean checkStart () {
        if (" ".equals(t.btns[0].getText()) && " ".equals(t.btns[1].getText()) && " ".equals(t.btns[2].getText()) &&
            " ".equals(t.btns[3].getText()) && " ".equals(t.btns[4].getText()) && " ".equals(t.btns[5].getText()) &&
            " ".equals(t.btns[6].getText()) && " ".equals(t.btns[0].getText()) && " ".equals(t.btns[0].getText()))
        {
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
    }
}

