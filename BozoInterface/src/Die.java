/**
 * Simulates a die with n sides.
 * Rolls it with the random class.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Random
 */
public class Die {

	private int sides;
	private int lastDrawn;
	private Random r = new Random();

	/**
	 * Six sided die constructor.
	 */
	public Die(){
		this.sides = 6;
	}

	/**
	 * N sided die constructor.
	 * @param n Number of sides.
	 */
	public Die(int n){
		this.sides = n;
	}

	/**
	 * @return Last number drawn.
	 */
	public int lastDrawn(){
		return lastDrawn;
	}

	/**
	 * Rolls the die.
	 * @return Side drawn.
	 */
	public int roll(){
		this.lastDrawn = r.getIntRandom(sides) + 1;
		return lastDrawn;
	}

	/**
	 * Returns a string representation of the die.
	 * Only works for six sided dice.
	 * @return A string representation of the die.
	 */
	@Override
	public String toString(){
		if(sides == 6){
			if(lastDrawn == 1) return "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
			else if(lastDrawn == 2) return "+-----+\n|*    |\n|     |\n|    *|\n+-----+";
			else if(lastDrawn == 3) return "+-----+\n|*    |\n|  *  |\n|    *|\n+-----+";
			else if(lastDrawn == 4) return "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+";
			else if(lastDrawn == 5) return "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
			else if(lastDrawn == 6) return "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+";
		}
		return Integer.toString(lastDrawn);
	}

}
