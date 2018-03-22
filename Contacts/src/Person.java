
public class Person {

	private String name;
	private int age;
	private double height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void printPerson(){
		System.out.println("Name: "+getName());
		System.out.println("Age: "+getAge());
		System.out.println("Height: "+getHeight()+"m");
	}
	
	
}
