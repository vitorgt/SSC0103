import java.awt.Color;
import javax.swing.JOptionPane;
import bozoException.BozoException;

/**
 * Main class to execute the game with graphical user interface.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class BozoGUI {

	public static DiceRoller dice = null;
	public static Score score = null;
	private static boolean change[] = null;
	private static int i = 0, round = 0;

	/**
	 * Handles the execution of the game.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
		change = new boolean[5];
		dice = new DiceRoller(5);
		score = new Score();
		new ScoreWindow();
		new DiceWindow();
		clearChange();
		JOptionPane.showMessageDialog(null, "Click on the dice you want to change\n"+
				"Then click on 'Roll' to roll them\n"+
				"Click on the board to choose the position\n"+
				"you want to occupy with this drawn");
	}

	/**
	 * Clears the boolean vector that selects the dice to roll.
	 */
	public static void clearChange(){
		for(int i = 0; i < 5; i++){
			change[i] = false;
		}
	}

	/**
	 * Shows a message dialog telling the users how many times they rolled the dice.
	 * Or a warning that they cannot roll the dice anymore.
	 */
	public static void roll(){
		if(i < 2){
			JOptionPane.showMessageDialog(null, ((i == 0) ? "First":"Second")+" time rolling the dice");
			i++;
			dice.roll(change);
			for(int i = 0; i < 5; i++){
				DiceWindow.diceSlots.elementAt(i).setText(Integer.toString(dice.getDrawn()[i]));
				DiceWindow.diceSlots.elementAt(i).setBackground(new Color(216,235,255));
			}
			clearChange();
		}
		else{
			JOptionPane.showMessageDialog(null, "You have already rolled the dice twice\n"+
					"You cannot roll it again at this round\n"+
					"Please select a score slot");
		}
	}

	/**
	 * Handles the click on a dice slot.
	 * Selected dice are kept in a boolean array.
	 * @param i Index of clicked dice.
	 */
	public static void diceClick(int i){
		if(change[i])
			DiceWindow.diceSlots.elementAt(i).setBackground(new Color(216,235,255));
		else
			DiceWindow.diceSlots.elementAt(i).setBackground(new Color(175,190,206));
		change[i] = !change[i];
	}

	/**
	 * Handles the click on a scorebord slot.
	 * Changes the text in the slot for the score.
	 * Rolls the dice for the next round.
	 * @param i Index of clicked scorebord slot.
	 * @throws BozoException
	 */
	public static void scoreClick(int i) throws BozoException{
		score.add(i+1, dice.getDrawn());
		ScoreWindow.scoreSlots.elementAt(i).setText(Integer.toString(score.getScoreArray()[i]));
		ScoreWindow.scoreSlots.elementAt(i).setBackground(new Color(204,204,204));

		BozoGUI.i = 0;
		BozoGUI.round++;
		clearChange();
		dice.roll();

		for(int j = 0; j < 5; j++){
			DiceWindow.diceSlots.elementAt(j).setText(Integer.toString(dice.getDrawn()[j]));
			DiceWindow.diceSlots.elementAt(j).setBackground(new Color(216,235,255));
		}
		if(round == 10){
			JOptionPane.showMessageDialog(null, "Final score: "+score.getScore()+"\nWell done.");
			System.exit(0);
		}
	}
}
