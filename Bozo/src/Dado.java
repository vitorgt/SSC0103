/**
 * Simula um dado de numero de lados variados.
 * Ao criar o objeto e possivel estabelecer o numero de lados.
 * A rolagem do dado e feita por meio de um gerador de numeros aleatorios (Random).
 * @author Fabio e Vitor
 *
 */
public class Dado {

	private int numeroLados;
	private int ultimoGerado;
	private Random r = new Random();
	private String d1 = "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
	private String d2 = "+-----+\n|*    |\n|     |\n|    *|\n+-----+";
	private String d3 = "+-----+\n|*    |\n|  *  |\n|    *|\n+-----+";
	private String d4 = "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+";
	private String d5 = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
	private String d6 = "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+";

	/**
	 * Recupera o ultimo numero selecionado.
	 * @return o numero do ultimo lado selecionado.
	 */
	public int getLado() {
		return ultimoGerado;
	}

	/**
	 * Simula a rolagem do dado por meio de um gerador aleatorio.
	 * O numero selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return o numero que foi sorteado
	 */
	public int rolar() {
		this.ultimoGerado = r.getIntRand(numeroLados)+1;
		return ultimoGerado;
	}

	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado() {
		this.numeroLados = 6;
	}

	/**
	 * Cria objeto com um numero qualquer de lados
	 * @param n - numero de lados do dado
	 */
	public Dado(int n) {
		this.numeroLados = n;
	}

	/**
	 * Transforma representacao do dado em String.
	 * E mostrada uma representacao do dado que esta para cima.
	 * Note que so funciona corretamente para dados de 6 lados.
	 */
	@Override
		public String toString() {
			if(numeroLados < 7 && numeroLados > 0){
				if(ultimoGerado == 1) return d1;
				else if(ultimoGerado == 2) return d2;
				else if(ultimoGerado == 3) return d3;
				else if(ultimoGerado == 4) return d4;
				else if(ultimoGerado == 5) return d5;
				else return d6;
			}
			return (Integer.toString(ultimoGerado));
		}

}
