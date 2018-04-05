
public abstract class ContaBancaria {

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

}
