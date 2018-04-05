
public class ContaPoupancaOuro extends ContaPoupanca{

	public ContaPoupancaOuro(String s, int dia) {
		super(s, dia);
	}
	@Override
	public void atualiza(double tx) {
		setSaldo(getSaldo()*(1+1.5*tx));
	}

}
