import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import bozoException.BozoException;

/**
 * Scoreboard slot click handler.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class ScoreWindowListener implements ActionListener {

	private enum positions {Uns,Dois,Tres,Quatros,Cincos,Seis,Full,Sequencia,Quadra,Quina,Roll};

	/**
	 * Verifies if the position is already occupied.
	 * When a empty slot is selected calls scoreClick function.
	 * @see BozoGUI
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			Integer.parseInt(ae.getActionCommand());
			JOptionPane.showMessageDialog(null, "Position already occupied");
		} catch (Exception e) {
			if(ae.getActionCommand().equals("Roll")){
				BozoGUI.roll();
			}
			else if(!ae.getActionCommand().equals("Bozo Game :)")){
				try {
					BozoGUI.scoreClick(positions.valueOf(ae.getActionCommand()).ordinal());
				} catch (BozoException e1) {}
			}
			else{
				JOptionPane.showMessageDialog(null, "Developers\n"+
						"10284667 Fabio F. Destro\n10284952 Vitor G. Torres");
			}
		}
	}

}
