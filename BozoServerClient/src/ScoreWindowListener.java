import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
				Client.roll();
			}
			else if(!ae.getActionCommand().equals("Bozo Game :)")){
				Client.scoreClick(positions.valueOf(ae.getActionCommand()).ordinal());
			}
			else{
				JOptionPane.showMessageDialog(null, "Developers\n"+
						"10284667 Fabio F. Destro\n10284952 Vitor G. Torres");
			}
		}
	}

}
