import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dice click handler.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class DiceWindowListener implements ActionListener {

	/**
	 * When a die is selected calls diceClick function.
	 * @see BozoGUI
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		BozoGUI.diceClick(Integer.parseInt(ae.getActionCommand()));
	}

}
