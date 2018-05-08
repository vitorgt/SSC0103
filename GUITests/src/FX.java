import javax.swing.JFrame;

public class FX {

	public static void main(String[] args) {
		Window frame = new Window("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocation(500, 500);
		frame.setVisible(true);
	}
}
