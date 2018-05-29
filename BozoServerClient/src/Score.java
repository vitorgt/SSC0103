import bozoException.BozoException;

/**
 * Maintains a player's score.
 * Judges the dice combination to calculate the score.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class Score {

	private int score[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

	/**
	 * Judges the dice combination to calculate the score for a position.
	 * Positions cannot be selected twice.
	 * @param position 1 - Uns; 2 - Dois; 3 - Tres; 4 - Quatros; 5 - Cincos; 6 - Seis; 7 - Full; 8 - Sequencia; 9 - Quadra; 10 - Quina.
	 * @param dice Dice sides drawn.
	 * @throws BozoException
	 */
	public void add(int position, int dice[]) throws BozoException{
		position--;
		if(position < 0 || position > 9)
			throw new BozoException("Invalid position");
		if(score[position] != -1)
			throw new BozoException("Position already occupied");

		int occ[] = {0,0,0,0,0,0};
		int eq2 = 0, eq3 = 0, eq4 = 0, eq5 = 0;
		for(int i = 0; i < dice.length; i++){
			int p = dice[i] - 1;
			occ[p]++;
			if(occ[p] == 2) eq2++;
			else if(occ[p] == 3) eq3++;
			else if(occ[p] == 4) eq4++;
			else if(occ[p] == 5) eq5++;
		}

		if(position <= 5){
			score[position] = (position + 1) * occ[position];
		}
		else if(position == 6){
			if((eq2 >= 2 && eq3 >= 1) || eq5 == 1)
				score[position] = 15;
			else
				score[position] = 0;
		}
		else if(position == 7){
			if((occ[0] == 1 || occ[5] == 1) &&
					(occ[1] == 1 && occ[2] == 1 && occ[3] == 1 && occ[4] == 1))
				score[position] = 20;
			else
				score[position] = 0;
		}
		else if(position == 8){
			if(eq4 == 1)
				score[position] = 30;
			else
				score[position] = 0;
		}
		else{
			if(eq5 == 1)
				score[position] = 40;
			else
				score[position] = 0;
		}
	}

	/**
	 * @return The total score.
	 */
	public int getScore() {
		int score = 0;
		for(int i : this.score)
			if(i != -1) score += i;
		return score;
	}

	/**
	 * @return The score array.
	 */
	public int[] getScoreArray() {
		return score;
	}

	/**
	 * @return A string representation of the scoreboard.
	 */
	@Override
	public String toString() {
		String ocp[] = new String[10];
		for(int i = 0; i < 10; i++)
			if(score[i] == -1)
				ocp[i] = "("+(i+1)+")";
			else
				ocp[i] = ""+score[i];

		String r = "\n";
		r += ocp[0]+"    |   "+ocp[6]+"    |   "+ocp[3]+
			"\n--------------------------\n";
		r += ocp[1]+"    |   "+ocp[7]+"    |   "+ocp[4]+
			"\n--------------------------\n";
		r += ocp[2]+"    |   "+ocp[8]+"    |   "+ocp[5]+
			"\n--------------------------\n";
		r += "       |   "+ocp[9]+"   |\n       +----------+\n";
		return r;
	}

}
