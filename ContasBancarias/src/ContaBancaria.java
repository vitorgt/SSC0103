
public abstract class ContaBancaria implements Comparable<ContaBancaria> {

	public static int n = 0;
	private int conta;
	private double saldo;
	private String correntista;

	public ContaBancaria(String correntista) {
		this.n++;
		this.conta = getQuantidadeContas();
		System.out.println(getQuantidadeContas());
		this.saldo = 0;
		this.correntista = correntista;
	}
	
	public static int getQuantidadeContas(){
		return n;
	}
	
	public int getNumConta() {
		return conta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getNomeCliente() {
		return correntista;
	}
	
	public void deposita(double deposito){
		if(deposito > 0){
			this.saldo += deposito;
		}
	}
	
	protected void saca(double saque) throws IllegalArgumentException {
		if(saldo > saque){
			this.saldo -= saque;
		}
		else{
			throw new IllegalArgumentException("Insufficient funds");
		}
	}
	
	public abstract void atualiza(double tx);
	
	@Override
	public int compareTo(ContaBancaria b){
		if(b == null){
			System.out.println("if null");
			return 0;
		}
		if(		this instanceof ContaEspecial && b instanceof ContaEspecial ||
				this instanceof ContaPoupancaOuro && b instanceof ContaPoupancaOuro ||
				this instanceof ContaPoupancaSimples && b instanceof ContaPoupancaSimples){
			System.out.println("primeiro if");
			if(this.getSaldo() == b.getSaldo()) return 0;
			if(this.getSaldo() < b.getSaldo()) return -1;
			return 1;
			
		}
		else{
			System.out.println("segundo if");
			if(		this instanceof ContaEspecial && b instanceof ContaPoupancaOuro ||
					this instanceof ContaPoupancaOuro && b instanceof ContaPoupancaSimples)
				return -1;
			else return 1;
		}
	}

}
