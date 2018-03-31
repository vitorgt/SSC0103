
public class PersonMen extends PersonIMC{

	public PersonMen(String name, int age, double height, double weight) {
		super(name, age, height, weight);
	}
	public String classifyIMC(){
		double IMC = IMC();
		if(IMC < 20.7) return "Underweight (IMC = "+IMC+")";
		if(IMC < 26.4) return "Health (IMC = "+IMC+")";
		if(IMC < 32.3) return "Overweight (IMC = "+IMC+")";
		if(IMC > 32.3) return "Obese (IMC = "+IMC+")";
		return "Could not calculate";
	}
	
}
