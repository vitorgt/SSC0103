
public class ContaPoupanca extends ContaBancaria{

	private int vencimento;

	public ContaPoupanca(String s, int conta, int dia) {
		super(s, conta);
		this.vencimento = dia;
	}
	public int getVencimento() {
		return vencimento;
	}
	public void setVencimento(int vencimento) {
		this.vencimento = vencimento;
	}
	public void atualiza(double tx) {
		setSaldo(getSaldo()*(1+(tx/100)));
	}

}
