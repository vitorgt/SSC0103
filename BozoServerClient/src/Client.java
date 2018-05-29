import java.awt.Color;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Client class for Bozo game server.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Server
 */
public class Client {

	private static Socket socket;
	private static Scanner in;
	private static PrintStream out;
	private static String name = "";
	private static boolean change[] = new boolean[5];
	private static int i = 0, round = 1, score = 0;

	/**
	 * Opens up connection with server,
	 * creates windows to display the game
	 * and writes command lines to it.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		socket = new Socket("127.0.0.1", Server.port);
		System.out.println("You're connected");
		in = new Scanner(socket.getInputStream());
		out = new PrintStream(socket.getOutputStream());
		new ScoreWindow();
		new DiceWindow();
		clearChange();
		JOptionPane.showMessageDialog(null, "Click on the dice you want to change\n"+
				"Then click on 'Roll' to roll them\n"+
				"Click on the board to choose the position\n"+
				"you want to occupy with this drawn");
		writeI();
		writeR();
	}

	/**
	 * Writes 'F' command and sends it to server.
	 * Shows dialog window with total final score.
	 */
	private static void writeF() {
		out.println("F");
		if(in.hasNextLine())
			JOptionPane.showMessageDialog(null, in.nextLine()+"\nWell done.");
		if(in.hasNextLine())
			System.out.println(in.nextLine());
	}

	/**
	 * Writes 'P' command and sends it to server.
	 * @param position The desired position to set the dice drawn.
	 */
	private static void writeP(int position) {
		out.println("P"+round+" "+position);
		clearChange();
		Client.i = 0;
		Client.round++;
	}

	/**
	 * Reads boolean array to select which dice to roll.
	 * Writes 'T' command and sends it to server.
	 */
	private static void writeT() {
		String send = "T ";
		for(int i = 0; i < 5; i++)
			if(change[i])
				send += "1 ";
			else
				send += "0 ";
		out.println(send.trim());
		i++;
		clearChange();
		updateDice();
	}

	/**
	 * Writes 'R' command and sends it to server.
	 */
	private static void writeR() {
		out.println("R"+round);
		clearChange();
		updateDice();
	}

	/**
	 * Opens up a window asking for user's name.
	 * Writes 'I' command and sends it to server.
	 */
	private static void writeI() {
		JTextArea textArea = new JTextArea();
		while(name.length() == 0){
			textArea.setEditable(true);
			JScrollPane scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(null, scrollPane, "What's your name?", JOptionPane.PLAIN_MESSAGE);
			name = textArea.getText().trim().split("\n")[0];
		}
		out.println("I "+name);
		if(in.hasNextLine())
			JOptionPane.showMessageDialog(null, in.nextLine());
	}

	/**
	 * Update dice slots with the new drawn.
	 */
	private static void updateDice(){
		if(in.hasNextLine()) {
			String dice[] = in.nextLine().split(" ");
			for(int i = 0; i < 5; i++){
				DiceWindow.diceSlots.elementAt(i).setText(dice[i]);
				DiceWindow.diceSlots.elementAt(i).setBackground(new Color(216,235,255));
			}
		}
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
	 * Rolls the dice.
	 */
	public static void roll(){
		if(i < 2){
			JOptionPane.showMessageDialog(null, ((i == 0) ? "First":"Second")+" time rolling the dice");
			writeT();
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
	 * @param i Index of clicked scorebord slot.
	 */
	public static void scoreClick(int i) {
		while(Client.i < 2) {
			writeT();
		}
		writeP(i+1);

		if(in.hasNextLine()) {
			String read[] = in.nextLine().trim().split(" ");
			ScoreWindow.scoreSlots.elementAt(i).setText(Integer.toString(Integer.parseInt(read[4])-score));
			score = Integer.parseInt(read[4]);
			ScoreWindow.scoreSlots.elementAt(i).setBackground(new Color(204,204,204));

			if(round < 11)
				writeR();
			else {
				writeF();
				System.exit(0);
			}
		}
	}

}
