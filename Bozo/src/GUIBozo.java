
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Fabio Fogarin Destro 10284667
 * @author Vitor Gratiere Torres 10284952
 */
public class GUIBozo {
	
	public static Vector<JButton> b = null;

	public GUIBozo() {
		
		JFrame frmBozo = new JFrame("Bozo");
		frmBozo.setVisible(true);
		frmBozo.setSize(400, 500);
		frmBozo.setLocation(300, 100);
		frmBozo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = (JPanel) frmBozo.getContentPane();
		jp.setLayout(new GridLayout(4, 3));
		
		
		b = new Vector<JButton>();
		Vector<BozoListener> lis = new Vector<BozoListener>();

		b.add(new JButton("Uns"));
		b.add(new JButton("Dois"));
		b.add(new JButton("Tres"));
		b.add(new JButton("Quatros"));
		b.add(new JButton("Cincos"));
		b.add(new JButton("Seis"));
		b.add(new JButton("Full"));
		b.add(new JButton("Sequencia"));
		b.add(new JButton("Quadra"));
		b.add(new JButton("Quina"));
		b.add(new JButton("Rolar"));
		b.add(new JButton("Bozo Game :)"));
		
		for(int i = 0; i < 12; i++) {
			lis.add(new BozoListener());
			b.elementAt(i).addActionListener(lis.elementAt(i));
			b.elementAt(i).setBackground(new Color(216,235,255));
			b.elementAt(i).setForeground(Color.black);
		}
		
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
