
public class ContaBancaria {
	private int conta;
	private double saldo;
	private String correntista;

	public ContaBancaria(String correntista, int conta) {
		this.conta = conta;
		this.saldo = 0;
		this.correntista = correntista;
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
}
