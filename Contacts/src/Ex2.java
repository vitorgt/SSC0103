import java.io.IOException;

public class Ex2 {

	public static void main(String[] args) throws IOException {

		System.out.println("Type a name: ");
		String name = EntradaTeclado.leString();
		System.out.println("Type an age: ");
		int age = EntradaTeclado.leInt();
		System.out.println("Type a height: ");
		double height = EntradaTeclado.leDouble();

		Person ne = new Person();
		ne.setName(name);
		ne.setAge(age);
		ne.setHeight(height);

		ne.printPerson();
	}

}
