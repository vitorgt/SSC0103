
public class Contas {

	private ContaBancaria contas[] = new ContaBancaria[100];
	private int nContas = 0;

	public Contas() {
	}

	public static void main(String[] args) throws Exception {
		int op = 0;
		Contas ct = new Contas();

		while (true) {
			op = ct.leOpcao();
			switch (op)
			{
				case 1: 
					System.out.println("Numero da conta: ");
					int conta = EntradaTeclado.leInt();
					System.out.println("Nome do correntista: ");
					String s = EntradaTeclado.leString();
					System.out.println("Dia de vencimento: ");
					int dia = EntradaTeclado.leInt();
					ContaPoupanca cp = new ContaPoupanca(s, conta, dia);
					ct.add(cp);
					System.out.println("************ Conta criada.**************");
					break;

				case 2: 
					System.out.println("Numero da conta: ");
					conta = EntradaTeclado.leInt();
					System.out.println("Nome do correntista: ");
					s = EntradaTeclado.leString();
					System.out.println("Limite de saque: ");
					double limite = EntradaTeclado.leDouble();
					ContaEspecial ce = new ContaEspecial(s, conta, limite);
					ct.add(ce);
					System.out.println("************ Conta criada.**************");
					break;
				case 3:
					System.out.println("Numero da conta: ");
					conta = EntradaTeclado.leInt();
					System.out.println("Valor a sacar: ");
					double valor = EntradaTeclado.leDouble();
					ContaBancaria search;
					search = ct.procura(conta);
					if ( search != null ) {
						try {
							search.saca(valor);
							System.out.println("****************** Saque realizado ***********");
						} catch (Exception e) {
							System.out.println("****************** Saque não realizado ***********");
							System.out.println(e.getMessage());
						}
					}
					else {
						System.out.println("************* Conta não existe **************");
						break;
					}

					break;
				case 4:
					System.out.println("Numero da conta: ");
					conta = EntradaTeclado.leInt();
					System.out.println("Valor a depositar: ");
					valor = EntradaTeclado.leDouble();
					search = ct.procura(conta);
					if ( search != null ) {
						search.deposita(valor);
						System.out.println("****************** Depósito realizado ***********");
					}
					else {
						System.out.println("************* Conta não existe **************");
						break;
					}
					break;
				case 6: 
					ct.printSaldos();
					break;
				case 5:
					System.out.println("Qual o valor da taxa? ");
					double tx = EntradaTeclado.leDouble();
					ct.atualizaPoupança(tx);
					System.out.println("Saldos atualizados");
					break;
				case 7:
					System.out.println("Terminando o programa....");
					return;
			}
			System.out.println("Digite ENTER para continuar");
			EntradaTeclado.leString();
			System.out.println("\n\n");
		}

	}

	private int leOpcao() {
		System.out.println("1) Criar poupança\n2) Criar conta especial\n3) Realizar saque\n4) Realizar deposito\n"
				+ "5) Atualizar poupanças\n6) Mostrar saldos\n7) Sair");
		int k = -1;
		while (true)
		{
			System.out.println("Digite a opção desejada ===> ");
			try {
				k = EntradaTeclado.leInt();
				if ( k > 0 && k < 8 )
					return k;
			}
			catch (Exception e) {
				;
			}
		}
	}

	private void add(ContaBancaria cb) {
		contas[nContas++] = cb;		
	}

	private void printSaldos() {
		for (ContaBancaria ctb : contas)
		{
			if ( ctb == null ) break;
			System.out.println("Numero da conta "+((ctb instanceof ContaPoupanca) ? "poupança" : "especial")+": "+ ctb.getNumConta());
			System.out.println("Titular: " + ctb.getNomeCliente());
			System.out.println("Saldo: " + ctb.getSaldo());
			System.out.println();
		}
	}

	private void atualizaPoupança(double tx) {
		for (ContaBancaria ctb : contas)
		{
			if ( ctb == null ) break;

			if ( ctb instanceof ContaPoupanca )
				((ContaPoupanca)ctb).atualiza(tx);
		}
	}

	private ContaBancaria procura(int conta) {
		for (ContaBancaria ctb: contas )
		{
			if ( ctb == null ) break;

			if (conta == ctb.getNumConta())
				return ctb;
		}
		return null;
	}

}
