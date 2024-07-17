import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OthelloStone extends OthelloBoard {
    public static void main(String[] args) {
        new OthelloStone();
    }

    OthelloStone () {
        PutStone putStone = new PutStone();
    }

    // class start {
    // }

    class PutStone implements MouseListener{
        public PutStone (){
            addMouseListener(this);
        }

        public void paint (Graphics g) {

        }

        public void mouseClicked(MouseEvent e) {
            
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
