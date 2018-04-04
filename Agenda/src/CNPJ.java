
public class CNPJ extends Contacts{

	private String CNPJ, entry, reason;

	public CNPJ(String name, String address, String email, String CNPJ, String entry, String reason){
		super(name, address, email);
		this.CNPJ = CNPJ;
		this.entry = entry;
		this.reason = reason;
	}

	public String getCNPJ(){
		return CNPJ;
	}

	public String getEntry(){
		return entry;
	}

	public String getReason(){
		return reason;
	}

}
