import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OthelloBoard {
    public static void main(String[] args){
		new OthelloBoard();
	}

	OthelloBoard() {
		BoardFrame frame = new BoardFrame();
		frame.setSize(500,600);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			System.exit(0);}});
		frame.setBackground(new Color(30, 80, 30));
		frame.setVisible(true);
	}

	class BoardFrame extends Frame {
		public static int board[][] = new int[8][8];
		// private int w;
		// private int h;
		// private int xStart;
		// private int yStart;
		private int n;
		
		public void paint(Graphics g) {
			// w = 200;
			// h = 200;
			// xStart = 50;
			// yStart = 50;
			n = 0;

			frameWork(g);
		}

		public void frameWork(Graphics g) {
			for (int i = 0; i < 9; i++) {
				g.drawLine(50 + n, 150, 50 + n, 550);
				g.drawLine(50, 150 + n, 450, 150 + n);
				n += 50;
			}
		}
	}
}
