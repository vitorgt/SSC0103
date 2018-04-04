
public class Contacts{

	private String name, address, email;
	private boolean active;

	public Contacts(String name, String address, String email){
		this.name = name;
		this.address = address;
		this.email = email;
		this.active = true;
	}

	public String getName(){
		return name;
	}

	public String getAddress(){
		return address;
	}

	public String getEmail(){
		return email;
	}

	public boolean isActive(){
		return active;
	}

	public void setActive(boolean active){
		this.active = active;
	}

}
