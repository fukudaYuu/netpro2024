import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloStone extends OthelloBoard {
    public static void mian(String[] args) {
        new OthelloStone();
    }

    OthelloStone () {
    }

    // class start {
    // }

    class PutStone implements MouseListener {
        public PutStone () {
            addMouseListener(this);
        }

        public void mouseClicked(MouseEvent e) {
			// マウスのボタンがクリックされた
		switch ( e.getButton() ) {
            case MouseEvent.BUTTON1:
                System.out.println("左クリック");
                break;
            case MouseEvent.BUTTON2:
                System.out.println("ホイールクリック");
                break;
            case MouseEvent.BUTTON3:
                System.out.println("右クリック");
                break;
            }
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
    }
}
