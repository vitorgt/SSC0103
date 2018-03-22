import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		String x1 = (EntradaTeclado.leString()).toUpperCase();

		int a = 0, e = 0, i = 0, o = 0, u = 0, c = 0;
		for(c = 0; c < x1.length(); c++){
			if(x1.charAt(c) == 'A') a++;
			else if(x1.charAt(c) == 'E') e++;
			else if(x1.charAt(c) == 'I') i++;
			else if(x1.charAt(c) == 'O') o++;
			else if(x1.charAt(c) == 'U') u++;
		}

		System.out.println("a: "+a+"\ne: "+e+"\ni: "+i+"\no: "+o+"\nu: "+u);
		System.out.println(x1);

		String x2 = (EntradaTeclado.leString()).toUpperCase();
/*
		if(x2.equals(x1.substring(0,x2.length()))){
			System.out.println(x1+" starts with "+x2);
		}
		else if(x2.equals(x1.substring(x1.length()-x2.length(),x1.length()))){
			System.out.println(x1+" ends with "+x2);
		}
*/
		if(x1.startsWith(x2))
			System.out.println(x1+" starts with "+x2);
		if(x1.endsWith(x2))
			System.out.println(x1+" ends with "+x2);
	}

}
