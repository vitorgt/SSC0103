import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Keyboard input handler.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class KeyboardInput {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Reads a string typed on the keyboard until an enter is pressed.
	 * @return The string.
	 * @throws IOException
	 */
	public static String readString() throws IOException{
		return br.readLine();
	}

	/**
	 * Reads a string and try to transform it into an integer.
	 * However, it does not make any checks on the validity of the data entered.
	 * @return The number.
	 * @throws IOException
	 */
	public static int readInteger() throws IOException{
		return Integer.parseInt(readString());
	}

	/**
	 * Reads a string and try to transform it into a double.
	 * However, it does not make any checks on the validity of the data entered.
	 * @return The number.
	 * @throws IOException
	 */
	public static double readDouble() throws IOException{
		return Double.parseDouble(readString());
	}

}
