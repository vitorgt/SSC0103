import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Automatic client class for Bozo game server.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Client
 */
public class AutoClient {

	private static Socket socket;
	private static Scanner in;
	private static PrintStream out;
	private static String name = "auto fabio & vitor";
	private static int round;
	private static Random r = new Random();

	//public static void main(String[] args) throws Exception {//To run by itself
	public AutoClient() throws Exception {//To run with AutoTester
		socket = new Socket("127.0.0.1", Server.port);
		in = new Scanner(socket.getInputStream());
		out = new PrintStream(socket.getOutputStream());
		round = 1;
		writeI();
		for(int j = 0; j < 10; j++) {
			writeR();
			writeT();
			writeT();
			writeP(j+1);
		}
		writeF();
	}

	private static void writeF() {
		out.println("F");
		if(in.hasNextLine())
			System.out.println(in.nextLine());
		if(in.hasNextLine())
			System.out.println(in.nextLine());
	}

	private static void writeP(int position) {
		out.println("P"+round+" "+position);
		AutoClient.round++;
		if(in.hasNextLine())
			in.nextLine();
	}

	private static void writeT() {
		String send = "T ";
		for(int i = 0; i < 5; i++)
			send += r.getIntRandom(2)+" ";
		out.println(send.trim());
		if(in.hasNextLine())
			in.nextLine();
	}

	private static void writeR() {
		out.println("R"+round);
		if(in.hasNextLine())
			in.nextLine();
	}

	private static void writeI() {
		out.println("I "+name);
		if(in.hasNextLine())
			System.out.println(in.nextLine());
	}

}
