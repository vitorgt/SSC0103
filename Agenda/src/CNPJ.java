
public class CNPJ extends Contacts{

	private CNPJ, entry, reason;

	private CPF(String name, String address, String email, String CNPJ, String entry, String reason){
		super(name, address, email);
		this.CNPJ = CNPJ;
		this.entry = entry;
		this.reason = reason;
	}

}
