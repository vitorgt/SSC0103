/*27m*/

public class MegaSena {

	public static void main(String[] args) {
/*
		int seed = 0;
		boolean retry = true;
		while(retry){
			try{
				System.out.println("Type an integer for seed: ");
				seed = EntradaTeclado.leInt();
				retry = false;
			}
			catch(Exception e){
				System.out.println("\nNot an integer\n");
				retry = true;
			}
			if(seed < 0){
				seed = -seed;
			}
		}
		Random r = new Random(seed);
*/
		Random r = new Random();
		for(int i = 0; i < 6; i++){
			System.out.println(r.getIntRand(1, 61));
			//System.out.println(r.getIntRand(60)+1);
		}
	}

}
