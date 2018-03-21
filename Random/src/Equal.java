/*71m*/

public class Equal {

	public static void main(String[] args) throws InterruptedException{
		int i = 0, a = 0, b = 1;
		Random r1 = new Random();
		Thread.sleep(2000);
		Random r2 = new Random();
		//Random r2 = new Random(r1.whatsMySeed()+2);
		for(i = 0; a != b; i++){
			a = r1.getIntRand(500001);
			b = r2.getIntRand(500001);
		}
		System.out.println("Generated numbers are: " + a + " and it took " + (i-1) + " iterations");
	}

}
