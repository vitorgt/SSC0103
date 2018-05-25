/**
 * Multiple dice manager.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Random
 * @see Die
 */
public class DiceRoller {

	private int n;
	private Die[] dice;
	private int[] drawn;

	/**
	 * N dice constructor.
	 * @param n Number of dice to create.
	 * @throws InterruptedException
	 */
	public DiceRoller(int n) throws InterruptedException{
		this.n = n;
		this.dice = new Die[n];
		this.drawn = new int[n];
		for(int i = 0; i < n; i++){
			dice[i] = new Die();
			Thread.sleep(100);
		}
	}

	/**
	 * @return The drawn.
	 */
	public int[] getDrawn() {
		return drawn;
	}

	/**
	 * Roll all the dice.
	 * @return The drawn.
	 */
	public int[] roll(){
		for(int i = 0; i < n; i++)
			drawn[i] = dice[i].roll();
		return drawn;
	}

	/**
	 * Roll some dice.
	 * @param which A boolean array that specifies which die to roll.
	 * @return The drawn.
	 */
	public int[] roll(boolean which[]){
		for(int i = 0; i < n; i++)
			if(which[i])
				drawn[i] = dice[i].roll();
		return drawn;
	}

	/**
	 * Roll some dice.
	 * @param s A string that specifies which die to roll.
	 * @return The drawn.
	 */
	public int[] roll(String s){
		for(String i : s.split(" ")){
			try {
				int p = Integer.parseInt(i) - 1;
				drawn[p] = dice[p].roll();
			} catch(Exception e) {}
		}
		return drawn;
	}

	/**
	 * Displays all dice.
	 * Only works for six sided dice.
	 * @return A string representation of all the dice.
	 */
	@Override
	public String toString(){
		String s = "";
		for(int i = 0; i < n; i++)
			s += (i+1)+"       ";
		s += "\n";
		for(int j = 0; j < 5; j++){
			for(int i = 0; i < n; i++)
				s += dice[i].toString().substring((7*j)+j, (7*(j+1))+j)+" ";
			s += "\n";
		}
		return s;
	}

}
