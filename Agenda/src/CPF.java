
public class CPF extends Contacts{

	private String CPF, matrial, birth;

	public CPF(String name, String address, String email, String CPF, String matrial, String birth){
		super(name, address, email);
		this.CPF = CPF;
		this.matrial = matrial;
		this.birth = birth;
	}

	public String getCPF(){
		return CPF;
	}

	public String getMatrial(){
		return matrial;
	}

	public String getBirth(){
		return birth;
	}

}
