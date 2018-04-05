
public abstract class ContaPoupanca extends ContaBancaria{

	private int vencimento;

	public ContaPoupanca(String s, int dia) {
		super(s);
		this.vencimento = dia;
	}
	public int getVencimento() {
		return vencimento;
	}
	public void setVencimento(int vencimento) {
		this.vencimento = vencimento;
	}

}
