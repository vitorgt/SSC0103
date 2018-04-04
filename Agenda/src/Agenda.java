
public class Agenda{

	private Contacts contacts[] = new Contacts[100];
	private int nContacts = 0;

	public Agenda(){
	}

	public static void main(String[] args){
		int op = 0;
		Agenda a = new Agenda();
		while(1){
			op 
		}
	}

	private int readOption(){
		System.out.println("1) Add by CPF\n2) Add by CNPJ\n3) Remove\n4) Search by CPF\n5) Search by CNPJ\n6) View all contacts");
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
			if(!ctc) break;
			if(ctc instanceof CPF){
			}
			else if(ctc instanceof CNPJ){
			}
		}
	}

}
