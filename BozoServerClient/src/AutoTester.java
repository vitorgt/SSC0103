
public class AutoTester {

	public static void main(String[] args) {
		for(int i = 0; i < 30; i++)
			try {
				new AutoClient();
			} catch (Exception e) {}
	}

}
