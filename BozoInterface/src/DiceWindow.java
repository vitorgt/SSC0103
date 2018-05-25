import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dice window.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class DiceWindow extends JFrame {

	public static Vector<JButton> diceSlots = null;

	/**
	 * Opens and sets up the dice window.
	 */
	public DiceWindow(){
		super("Dice");
		this.setVisible(true);
		this.setSize(400, 100);
		this.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-200,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2+200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = (JPanel) this.getContentPane();
		jp.setLayout(new GridLayout(1, 5));

		diceSlots = new Vector<JButton>();
		Vector<DiceWindowListener> listeners = new Vector<DiceWindowListener>();

		BozoGUI.dice.roll();
		for(int i = 0; i < 5; i++){
			listeners.add(new DiceWindowListener());
			diceSlots.add(new JButton(Integer.toString(BozoGUI.dice.getDrawn()[i])));
			diceSlots.elementAt(i).addActionListener(listeners.elementAt(i));
			diceSlots.elementAt(i).setActionCommand(Integer.toString(i));
			diceSlots.elementAt(i).setBackground(new Color(216,235,255));
			diceSlots.elementAt(i).setForeground(Color.black);
			jp.add(diceSlots.elementAt(i));
		}
	}
}
