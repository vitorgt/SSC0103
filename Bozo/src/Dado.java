
/**
 * Simula um dado de número de lados variados.
 * Ao criar o objeto é possível estabelecer o número de lados.
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
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
	 * Não tem função real dentro da classe.
	 * Foi usada apenas para testar os métodos implementados
	 * @param args - sem uso
	 */
	public static void main(String[] args) {
	}

	/**
	 * Recupera o último número selecionado.
	 * @return o número do último lado selecionado.
	 */
	public int getLado() {
		return ultimoGerado;
	}

	/**
	 * Simula a rolagem do dado por meio de um gerador aleatório.
	 * O número selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return o número que foi sorteado
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
	 * Cria objeto com um número qualquer de lados
	 * @param n - número de lados do dado
	 */
	public Dado(int n) {
		this.numeroLados = n;
	}

	/**
	 * Transforma representação do dado em String.
	 * É mostrada uma representação do dado que está para cima.
	 * Note que só funciona corretamente para dados de 6 lados.
	 */
	@Override
		public String toString() {
			if(numeroLados < 7 && numeroLados > 0){
				if(ultimoGerado == 1) return d1;
				else if(ultimoGerado == 2) return d2;
				else if(ultimoGerado == 3) return d3;
				else if(ultimoGerado == 4) return d4;
				else if(ultimoGerado == 5) return d5;
				else if(ultimoGerado == 6) return d6;
			}
			return (Integer.toString(ultimoGerado));
		}

}
