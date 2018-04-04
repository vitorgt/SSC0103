
public class Agenda{

	private Contacts contacts[] = new Contacts[100];
	private int nContacts = 0;

	public Agenda(){
	}

	public static void main(String[] args){
		int op = 0;
		Agenda a = new Agenda();
		while(1){
			op = a.readOption();
			switch(op){
				case 1:
					System.out.println("Name: ");
					String a1 = EntradaTeclado.leString();
					System.out.println("Address: ");
					String a2 = EntradaTeclado.leString();
					System.out.println("Email: ");
					String a3 = EntradaTeclado.leString();
					System.out.println("CPF: ");
					String a4 = EntradaTeclado.leString();
					System.out.println("Matrial Status: ");
					String a5 = EntradaTeclado.leString();
					System.out.println("Date of Birth: ");
					String a6 = EntradaTeclado.leString();
					CPF cp = new CPF(a1, a2, a3, a4, a5, a6);
					c.add(cp);
					System.out.println("************** Contact added **************");
					break;
				case 2:
					System.out.println("Name: ");
					String a1 = EntradaTeclado.leString();
					System.out.println("Address: ");
					String a2 = EntradaTeclado.leString();
					System.out.println("Email: ");
					String a3 = EntradaTeclado.leString();
					System.out.println("CNPJ: ");
					String a4 = EntradaTeclado.leString();
					System.out.println("State Registration: ");
					String a5 = EntradaTeclado.leString();
					System.out.println("Official Company Name: ");
					String a6 = EntradaTeclado.leString();
					CNPJ cn = new CNPJ(a1, a2, a3, a4, a5, a6);
					c.add(cn);
					System.out.println("************** Contact added **************");
					break;
				case 3:
					System.out.println("Name: ");
					String remove = EntradaTeclado.leString();
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
					System.out.println((op == 4 ? "Name: ":)+(op == 5 ? "CPF: ":)+(op == 6 ? "CNPJ: ":));
					lookfor = EntradaTeclado.leString();
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
		}
	}

	private int readOption(){
		System.out.println("1) Add by CPF\n2) Add by CNPJ\n3) Remove by Name\n4) Search by Name\n5) Search by CPF\n6) Search by CNPJ\n7) View all contacts");
		int k = -1;
		while(true){
			System.out.println("Type an option: ");
			try{
				k = EntradaTeclado.leInt();
				if(k > 0 && k < 7)
					return k;
			}
			catch(Exceprion e){
				;
			}
		}
	}

	private void add(Contact c){
		contacts[nContacts++] = c;
	}

	private void printContacts(){
		for(Contacts ctc : contacts){
			printContact(ctc);
		}
	}

	private void printContact(Contacts ctc){
		if(!ctc) break;
		if(ctc.isActive()){
			System.out.println("Name: "+ctc.getName());
			System.out.println("Address: "+ctc.getAddress());
			System.out.println("Email: "+ctc.getEmail());
			if(ctc instanceof CPF){
				System.out.println("CPF: "+ctc.getCPF());
				System.out.println("Matrial Status: "+ctc.getMatrial());
				System.out.println("Date of Birth: "+ctc.getBirth());
			}
			else if(ctc instanceof CNPJ){
				System.out.println("CNPJ: "+ctc.getCNPJ());
				System.out.println("State Registration: "+ctc.getEntry());
				System.out.println("Official Company Name: "+ctc.getReason());
			}
		}
	}

	private Contacs search(String lookingfor){
		for(Contacts ctc : contacts){
			if(ctc == null) break;
			if(ctc.getName() == lookingfor) return ctc;
			if(ctc instanceof CPF)
				if(ctc.getCPF() == lookingfor) return ctc;
			if(ctc instanceof CNPJ)
				if(ctc.getCNPJ() == lookingfor) return ctc;
		}
		return null;
	}

}
