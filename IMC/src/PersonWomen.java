
public class PersonWomen extends PersonIMC{

	public PersonWomen(String name, int age, double height, double weight) {
		super(name, age, height, weight);
	}
	public String classifyIMC(){
		double IMC = IMC();
		if(IMC < 19.1) return "Underweight";
		if(IMC < 25.8) return "Health";
		if(IMC < 31.1) return "Overweight";
		if(IMC > 31.1) return "Obese";
		return "Could not calculate";
	}
	
}
