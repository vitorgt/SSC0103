
public class Agenda{

	private Contacts contacts[] = new Contacts[100];
	private int nContacts = 0;

	public Agenda(){
	}

	public static void main(String[] args){
		int op = 0;
		Agenda a = new Agenda();
		while(true){
			op = a.readOption();
			switch(op){
				case 1:
					String a1 = a.type("Name: ");
					String a2 = a.type("Address: ");
					String a3 = a.type("Email: ");
					String a4 = a.type("CPF: ");
					String a5 = a.type("Matrial Status: ");
					String a6 = a.type("Date of Birth: ");
					CPF cp = new CPF(a1, a2, a3, a4, a5, a6);
					a.add(cp);
					System.out.println("************** Contact added **************");
					break;
				case 2:
					a1 = a.type("Name: ");
					a2 = a.type("Address: ");
					a3 = a.type("Email: ");
					a4 = a.type("CNPJ: ");
					a5 = a.type("State Registration: ");
					a6 = a.type("Official Company Name: ");
					CNPJ cn = new CNPJ(a1, a2, a3, a4, a5, a6);
					a.add(cn);
					System.out.println("************** Contact added **************");
					break;
				case 3:
					String remove = a.type("Name: ");
					Contacts search = a.search(remove);
					if(search != null){
						search.setActive(false);
						System.out.println("************** Contact removed **************");
					}
					else{
						System.out.println("************** Contact doesn't exist  **************");
					}
					break;
				case 4:
				case 5:
				case 6:
					String lookfor = a.type(((op == 4) ? "Name: " : "")+((op == 5) ? "CPF: " : "")+((op == 6) ? "CNPJ: " : ""));
					search = a.search(lookfor);
					if(search != null){
						a.printContact(search);
					}
					else{
						System.out.println("************** Contact doesn't exist  **************");
					}
					break;
				case 7:
					a.printContacts();
					break;
			}
			System.out.println("Type ENTER to continue");
			a.type("");
		}
	}

	private String type(String out){
		String typing;
		while(true){
			try{
				System.out.println(out);
				typing = EntradaTeclado.leString();
				return typing;
			}
			catch(Exception e){
				System.out.println("Retry typing please");
			}
		}
	}

	private int readOption(){
		System.out.println("1) Add by CPF\n2) Add by CNPJ\n3) Remove by Name\n4) Search by Name\n5) Search by CPF\n6) Search by CNPJ\n7) View all contacts");
		int k = -1;
		while(true){
			System.out.println("Type an option: ");
			try{
				k = EntradaTeclado.leInt();
				if(k > 0 && k < 8)
					return k;
			}
			catch(Exception e){
				;
			}
		}
	}

	private void add(Contacts c){
		contacts[nContacts++] = c;
	}

	private void printContacts(){
		for(Contacts ctc : contacts){
			if(ctc == null) break;
			printContact(ctc);
		}
	}

	private void printContact(Contacts ctc){
		if(ctc != null && ctc.isActive()){
			System.out.println();
			System.out.println("Name: "+ctc.getName());
			System.out.println("Address: "+ctc.getAddress());
			System.out.println("Email: "+ctc.getEmail());
			if(ctc instanceof CPF){
				System.out.println("CPF: "+((CPF)ctc).getCPF());
				System.out.println("Matrial Status: "+((CPF)ctc).getMatrial());
				System.out.println("Date of Birth: "+((CPF)ctc).getBirth());
			}
			else if(ctc instanceof CNPJ){
				System.out.println("CNPJ: "+((CNPJ)ctc).getCNPJ());
				System.out.println("State Registration: "+((CNPJ)ctc).getEntry());
				System.out.println("Official Company Name: "+((CNPJ)ctc).getReason());
			}
			System.out.println();
		}
	}

	private Contacts search(String lookingfor){
		for(Contacts ctc : contacts){
			if(ctc == null) break;
			if(ctc.getName().equals(lookingfor)) return ctc;
			if(ctc instanceof CPF)
				if(((CPF)ctc).getCPF().equals(lookingfor)) return ctc;
			if(ctc instanceof CNPJ)
				if(((CNPJ)ctc).getCNPJ().equals(lookingfor)) return ctc;
		}
		return null;
	}

}
