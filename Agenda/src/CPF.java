
public class CPF extends Contacts{

	private CPF, marital, birth;

	private CPF(String name, String address, String email, String CPF, String matrial, String birth){
		super(name, address, email);
		this.CPF = CPF;
		this.matrial = matrial;
		this.birth = birth;
	}

}
