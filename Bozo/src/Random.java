
/**
 * gerador simples de números aleatórios.
 * @author Fabio e Vitor
 */
import java.util.Calendar;

public class Random {

	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023;

	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente.
	 * @param k - O valor inicial da semente.
	 */
	public Random (int k) {
		xi = k;
	}

	/**
	 * Construtor que usa uma semente aleatória, adquerida usando o método Calendar.getTimeInMillis().
	 */
	public Random() {
		Calendar cal = Calendar.getInstance();
		xi = -cal.getTimeInMillis();
	}

	/**
	 * Retorna um número aleatório no intervalo (0,1[
	 * @return o número gerado.
	 */
	public double getRand() {
		xi = (a + m*xi) % p;
		double d = xi;
		return d/p;
	}

	/**
	 * Retorna um valor inteiro no intervalo (0,max[
	 * @param n - O valor limite para a geração do número inteiro
	 * @return o número gerado
	 */
	public int getIntRand(int n) {
		double d = getRand() * n;
		return (int)d;
	}

	/**
	 * Permite alterar a semente de geração de números aleatórios.
	 * Supostamente deve ser chamada antes de iniciar a geração, mas se for chamado a qualquer instante, reseta o valor da semante
	 * @param x - o valor da nova semente de geração
	 */
	public void setSemente(int x) {
		xi = x;
	}

}
