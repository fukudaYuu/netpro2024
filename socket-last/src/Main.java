import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
    static int w = 800, h = 600;
    //private JButton[] buttons = new JButton[9];

    public static void main (String[] args) {
        framework();
    }
    
    public static void framework () {
        JFrame frame = new JFrame("三目並べ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JButton btn = new JButton();
        frame.setVisible(true);
    }
}
