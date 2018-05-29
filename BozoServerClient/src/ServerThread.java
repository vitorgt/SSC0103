import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import bozoException.BozoException;

/**
 * Thread to handle each user.
 * Handles dice rolling and score calculation and sends it to client.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Server
 * @see Client
 * @see Thread
 */
public class ServerThread extends Thread {

	private Socket socket;
	private Server server;
	private DiceRoller dice;
	private Score score;
	private String name;
	private Scanner in;
	private PrintStream out;

	/**
	 * Opens communication channels.
	 * Handles dice rolling and score calculation.
	 * Receives its designed socket and server's address.
	 * @param socket Port for communication with server.
	 * @param server Server's address for log registration.
	 * @throws Exception
	 */
	public ServerThread(Socket socket, Server server) throws Exception {
		this.socket = socket;
		this.server = server;
		this.dice = new DiceRoller(5);
		this.score = new Score();
		this.in = new Scanner(this.socket.getInputStream());
		this.out = new PrintStream(this.socket.getOutputStream());
	}

	/**
	 * Tries to read command lines received from client.
	 */
	public void run(){
		try {
			readI();
		} catch (Exception e) {
			server.addScore("I ERROR", 0);
			System.out.println(e.getMessage());
			in.close();
			out.close();
			return;
		}
		try {
			for(int i = 1; i < 11; i++){
				readR(i);
				readT();
				readT();
				readP(i);
			}
			readF();
		} catch (Exception e) {
			server.addScore(name, 0);
			System.out.println(e.getMessage());
			in.close();
			out.close();
			System.out.println(name+" offline");
			return;
		}
		server.addScore(name, score.getScore());
		out.println("Disconnecting you\nThanks for playing!");
		in.close();
		out.close();
		System.out.println(name+" offline");
	}

	/**
	 * Reads 'F' command from client.
	 * If successful, sends total final score back to him.
	 * @throws BozoException
	 */
	private void readF() throws BozoException {
		String read = in.nextLine().trim();
		if(read.split(" ").length > 1)
			throw new BozoException("'F' command received more than 1 arguments");
		else if(read.equals("F")){
			out.println("Your final total score: "+score.getScore());
			System.out.println(name+" finished with "+score.getScore()+" points");
		}
		else
			throw new BozoException("'F' command not found");
	}

	/**
	 * Reads 'P' command from client.
	 * If successful, sends total score back to him.
	 * @param i Round #
	 * @throws BozoException
	 */
	private void readP(int i) throws BozoException {
		String[] read = in.nextLine().trim().split(" ");
		if(read.length > 2)
			throw new BozoException("'P' command received more than 2 arguments");
		else if(read[0].equals("P"+i)){
			if(Integer.parseInt(read[1]) < 1 || Integer.parseInt(read[1]) > 10)
				throw new BozoException("'P' command received number out of range");
			score.add(Integer.parseInt(read[1]), dice.getDrawn());
			out.println("Your new total score: "+score.getScore());
		}
		else
			throw new BozoException("'P' command not found or out of context");
	}

	/**
	 * Reads 'T' command from client.
	 * If successful, sends new dice drawn back to him.
	 * @throws BozoException
	 */
	private void readT() throws BozoException {
		String[] read = in.nextLine().trim().split(" ");
		if(read.length > 6)
			throw new BozoException("'T' command received more than 5 dices");
		else if(read[0].equals("T")){
			boolean change[] = new boolean[5];
			for(int i = 0; i < 5; i++){
				if(read[i+1].equals("0"))
					change[i] = false;
				else if(read[i+1].equals("1"))
					change[i] = true;
				else
					throw new BozoException("'T' command received number out of range");
			}
			dice.roll(change);
			String send = "";
			for(int i = 0; i < 5; i++)
				send += dice.getDrawn()[i]+" ";
			out.println(send);
		}
		else
			throw new BozoException("'T' command not found or out of context");
	}

	/**
	 * Reads 'R' command from client.
	 * If successful, sends a dice drawn back to him.
	 * @param i Round #
	 * @throws BozoException
	 */
	private void readR(int i) throws BozoException {
		String read = in.nextLine().trim();
		if(read.split(" ").length > 1)
			throw new BozoException("'R' command received more than 1 arguments");
		else if(read.equals("R"+i)){
			System.out.println(name+" on round #"+i);
			dice.roll();
			String send = "";
			for(int j = 0; j < 5; j++)
				send += dice.getDrawn()[j]+" ";
			out.println(send);
		}
		else
			throw new BozoException("'R' command not found or out of context");
	}

	/**
	 * Reads 'I' command from client.
	 * If successful, sends welcome message back to him.
	 * @throws BozoException
	 */
	private void readI() throws BozoException {
		String read = in.nextLine().trim();
		if(read.split(" ")[0].equals("I")){
			this.name = toProper(read.substring(2, read.length()).trim().toLowerCase());
			out.println("Welcome "+name);
			System.out.println(name+" online");
		}
		else
			throw new BozoException("'I' command not found");
	}

	/**
	 * Converts a string to Proper Case.
	 * @param input String to be converted.
	 * @return Proper Case converted string.
	 */
	private String toProper(String input) {
		StringBuilder proper = new StringBuilder();
		boolean space = true;
		for(char c : input.toCharArray()) {
			if(Character.isSpaceChar(c) || Character.isWhitespace(c))
				space = true;
			else if(space) {
				c = Character.toUpperCase(c);
				space = false;
			}
			proper.append(c);
		}
		return proper.toString();
	}

}
