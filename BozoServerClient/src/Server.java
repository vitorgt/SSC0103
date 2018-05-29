import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

/**
 * Server class for Bozo game server.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 * @see Client
 */
public class Server {

	private static HashMap<String, Vector<Integer>> users;
	public final static int port = 7777;

	/**
	 * When a server is created it creates a HashMap to allocate all users data.
	 */
	public Server(){
		users = new HashMap<String, Vector<Integer>>();
	}

	/**
	 * Adds a new score to users data.
	 * Also creates a new user if it cannot find specified user's name.
	 * @param name User's ID.
	 * @param score User's score to be added.
	 */
	synchronized void addScore(String name, int score){
		if(!users.containsKey(name)){
			Vector<Integer> scores = new Vector<Integer>();
			users.put(name, scores);
		}
		users.get(name).add(score);
	}

	/**
	 * Prints all scores.
	 */
	synchronized static void printScores(){
		System.out.println();
		for(String name : users.keySet()){
			int sum = 0;
			for(Integer score : users.get(name))
				sum += score;
			System.out.println(name+":\n\tPlayed "+users.get(name).size()+" times");
			System.out.println("\tTotal score: "+sum+" points");
			System.out.println("\tAverage: "+(sum/users.get(name).size())+" points");
		}
	}

	/**
	 * Opens a server and a port for the game to be played.
	 * Each new connection is handled as a thread.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket socket = new ServerSocket(port);
		System.out.println("Port "+port+" open");
		Server server = new Server();
		new ScoreThread().start();
		while(true){
			Socket client = socket.accept();
			new ServerThread(client, server).start();
			System.out.println("New connection with client "+client.getInetAddress().getHostAddress());
		}
	}
}
