import java.io.IOException;

public class Ex {

	public static void main(String[] args) throws IOException {

		System.out.println("Type a name: ");
		String name = EntradaTeclado.leString();
		System.out.println("Male or Female? ");
		String sex = EntradaTeclado.leString();
		System.out.println("Type an age: ");
		int age = EntradaTeclado.leInt();
		System.out.println("Type a height(m): ");
		double height = EntradaTeclado.leDouble();
		System.out.println("Type a weight(kg): ");
		double weight = EntradaTeclado.leDouble();

		if(sex.toUpperCase().charAt(0) == 'M'){
			PersonMen men = new PersonMen(name, age, height, weight);
			men.printPersonIMC();
			System.out.println(men.classifyIMC());
		}
		else{
			PersonWomen women = new PersonWomen(name, age, height, weight);
			women.printPersonIMC();
			System.out.println(women.classifyIMC());
		}
	}

}
