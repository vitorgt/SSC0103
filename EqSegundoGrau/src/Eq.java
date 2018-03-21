public class Eq {

	public static void main(String[] args){
		double a = 0, b = 0, c = 0, d = 0, x1 = 0, x2 = 0;
		boolean retry = true;
		while(retry){
			try {
				System.out.printf("Type coefficients ax^2 + bx + c\na:");
				a = EntradaTeclado.leDouble();
				retry = false;
			}
			catch(Exception e){
				System.out.println("Not a number");
				retry = true;
			}
		}
		retry = true;
		while(retry){
			try {
				System.out.printf("\nb:");
				b = EntradaTeclado.leDouble();
				retry = false;
			}
			catch(Exception e){
				System.out.println("Not a number");
				retry = true;
			}
		}
		retry = true;
		while(retry){
			try {
				System.out.printf("\nc:");
				c = EntradaTeclado.leDouble();
				retry = false;
			}
			catch(Exception e){
				System.out.println("Not a number");
				retry = true;
			}
		}
		d = (b * b) - 4 * a * c;
		if(a == 0){
			System.out.printf("Not a second degree equation\n");
		}
		if(d < 0){
			System.out.printf("Doesn't exsists real roots\n");
		}
		else{
			x1 = ((-b + Math.sqrt(d)) / (2 * a));
			x2 = ((-b - Math.sqrt(d)) / (2 * a));
			System.out.println(x1 + " and " + x2);
		}
	}
}
