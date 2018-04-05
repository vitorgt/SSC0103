
public class ContaPoupancaSimples extends ContaPoupanca{

	public ContaPoupancaSimples(String s, int dia) {
		super(s, dia);
	}
	public void atualiza(double tx) {
		setSaldo(getSaldo()*(1+tx));
	}

}
