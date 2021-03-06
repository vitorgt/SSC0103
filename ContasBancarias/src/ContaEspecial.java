
public class ContaEspecial extends ContaBancaria{

	private double limite;

	public ContaEspecial(String s, double limite) {
		super(s);
		this.limite = limite;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	@Override
	public void saca(double saque) throws IllegalArgumentException {
		if((getSaldo()+limite) > saque){
			setSaldo(getSaldo()-saque);
		}
		else{
			throw new IllegalArgumentException("Limit exceeded");
		}
	}
	@Override
	public void atualiza(double tx){
	}

}
