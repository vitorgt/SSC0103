import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Thread to read server's terminal.
 * When someone types 'scores', it prints all the scores.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Thread
 */
public class ScoreThread extends Thread {

	public void run(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String x = "";
			try {
				x = br.readLine();
			} catch (Exception e) {}
			if(x.equalsIgnoreCase("scores")){
				Server.printScores();
			}
		}
	}

}
