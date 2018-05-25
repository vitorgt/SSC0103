import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Scoreboard window.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class ScoreWindow extends JFrame {

	public static Vector<JButton> scoreSlots = null;

	/**
	 * Opens and sets up the scoreboard window.
	 */
	public ScoreWindow(){
		super("Bozo");
		this.setVisible(true);
		this.setSize(400, 500);
		this.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-200,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = (JPanel) this.getContentPane();
		jp.setLayout(new GridLayout(4, 3));

		scoreSlots = new Vector<JButton>();
		Vector<ScoreWindowListener> listeners = new Vector<ScoreWindowListener>();

		scoreSlots.add(new JButton("Uns"));
		scoreSlots.add(new JButton("Dois"));
		scoreSlots.add(new JButton("Tres"));
		scoreSlots.add(new JButton("Quatros"));
		scoreSlots.add(new JButton("Cincos"));
		scoreSlots.add(new JButton("Seis"));
		scoreSlots.add(new JButton("Full"));
		scoreSlots.add(new JButton("Sequencia"));
		scoreSlots.add(new JButton("Quadra"));
		scoreSlots.add(new JButton("Quina"));
		scoreSlots.add(new JButton("Roll"));
		scoreSlots.add(new JButton("Bozo Game :)"));

		for(int i = 0; i < 12; i++){
			listeners.add(new ScoreWindowListener());
			scoreSlots.elementAt(i).addActionListener(listeners.elementAt(i));
			scoreSlots.elementAt(i).setBackground(new Color(216,235,255));
			scoreSlots.elementAt(i).setForeground(Color.black);
		}

		jp.add(scoreSlots.elementAt(0));
		jp.add(scoreSlots.elementAt(6));
		jp.add(scoreSlots.elementAt(3));
		jp.add(scoreSlots.elementAt(1));
		jp.add(scoreSlots.elementAt(7));
		jp.add(scoreSlots.elementAt(4));
		jp.add(scoreSlots.elementAt(2));
		jp.add(scoreSlots.elementAt(8));
		jp.add(scoreSlots.elementAt(5));
		jp.add(scoreSlots.elementAt(10));
		jp.add(scoreSlots.elementAt(9));
		jp.add(scoreSlots.elementAt(11));
	}

}
