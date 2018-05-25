import java.io.IOException;
import bozoException.BozoException;

/**
 * Main class to execute the game on terminal.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class BozoTerminal {

	/**
	 * Handles the execution of the game.
	 * It has a loop to run 10 rounds.
	 * In each round, player roll the dices up to 3 times.
	 * Once mandatory, the other two are optional.
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		DiceRoller dice = new DiceRoller(5);
		Score score = new Score();
		System.out.println(score);

		for(int i = 0; i < 10; i++){
			System.out.println("Round #"+(i+1)+"\nPress ENTER to roll the dice\n");
			KeyboardInput.readString();
			for(int j = 0; j < 2; j++){
				if(j == 0) dice.roll();
				System.out.println(dice);
				System.out.println("Type the number of the dice you want to change (separated by spaces).");
				String change = KeyboardInput.readString().trim();
				dice.roll(change);
			}
			System.out.println(score);
			while(true){
				try {
					System.out.println("Choose the position you want to occupy with this drawn");
					int position = KeyboardInput.readInteger();
					score.add(position, dice.getDrawn());
					break;
				} catch (BozoException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("Not a number");
				}
			}
			System.out.println(score);
		}
		System.out.println("Final score: "+score.getScore());
	}

}
