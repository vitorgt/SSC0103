import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIBozo {

	public static void main(String[] args) {

		JFrame a = new JFrame("Bozo");

		a.setVisible(true);
		a.setSize(400, 400);
		a.setLocation(100, 100);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = (JPanel) a.getContentPane();
		jp.setLayout(new GridLayout(4, 3));

		Vector<JButton> b = new Vector<JButton>();
		for(int i = 0; i < 9; i++) {
			b.add(new JButton(Character.toString((char)('1'+i))));
		}
		b.add(new JButton("10"));
		b.add(new JButton("Clear"));
		b.add(new JButton("End"));

		jp.add(b.elementAt(0));
		jp.add(b.elementAt(6));
		jp.add(b.elementAt(3));
		jp.add(b.elementAt(1));
		jp.add(b.elementAt(7));
		jp.add(b.elementAt(4));
		jp.add(b.elementAt(2));
		jp.add(b.elementAt(8));
		jp.add(b.elementAt(5));
		jp.add(b.elementAt(10));
		jp.add(b.elementAt(9));
		jp.add(b.elementAt(11));
	}

}
