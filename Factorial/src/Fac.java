public class Fac {

	public static void main(String[] args) {
		int a = 0, i = 0, f = 1, n = 0;
		boolean retry = true;
		while(retry){
			try {
				System.out.println("Type a positive integer:");
				a = EntradaTeclado.leInt();
				n = a - 1;
				retry = false;
			}
			catch(Exception e){
				System.out.println("\nNot an Integer\n");
				retry = true;
			}
			if(a < 0){
				System.out.println("\nNot a positive Integer\n");
				retry = true;
			}
		}
		for(i = 0; i < n; i++) {
			f *= a--;
		}
		System.out.println(f);
	}

}
