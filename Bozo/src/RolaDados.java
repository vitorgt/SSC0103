/**
 * Essa e uma classe auxiliar que permite gerencia um conjunto de varios dados simultaneamente.
 * Operacoes como rolar alguns dos dados ou exibir o resultado de todos eles, sao implementadas.
 * @author Fabio e Vitor
 *
 */
public class RolaDados {

	private int numeroDados;
	private Dado dados[];
	private int resultadosDados[];

	public int[] getResultadosDados() {
		return resultadosDados;
	}

	public void setResultadosDados(int[] resultadosDados) {
		this.resultadosDados = resultadosDados;
	}

	/**
	 * Construtor que cria e armazena varios objetos do tipo Dado.
	 * Usa para isso o construtor padrao daquela classe, ou seja, um dado de 6 lados e gerando sempre uma semente aleatoria para o gerador de numeros aleatorios.
	 * Os dados criados podem ser referenciados por numeros, entre 1 e n.
	 * @param n - Numero de dados a serem criados.
	 * @throws InterruptedException
	 */
	public RolaDados(int n) throws InterruptedException{
		this.numeroDados = n;
		this.dados = new Dado[numeroDados];
		this.resultadosDados = new int[numeroDados];
		for(int i = 0; i < numeroDados; i++){
			dados[i] = new Dado();
			Thread.sleep(10);
		}
	}

	/**
	 * Rola todos os dados.
	 * @return Retorna o valor de cada um dos dados, inclusive os que nao foram rolados. Nesse caso, o valor retornado e o valor anterior que ele ja possuia.
	 */
	public int[] Rolar(){
		for(int i = 0; i < numeroDados; i++){
			resultadosDados[i] = dados[i].rolar();
		}
		for(int i = 0; i < numeroDados; i++){
			System.out.printf("%d       ", i+1);
		}
		System.out.println("");
		for(int j = 0; j < 5; j++){
			for(int i = 0; i < numeroDados; i++){
				System.out.printf(dados[i].toString().substring((7*j)+j, (7*(j+1))+j)+" ");
			}
			System.out.println("");
		}
		return resultadosDados;
	}

	/**
	 * Rola alguns dos dados.
	 * @param quais - E um array de booleanos que indica quais dados devem ser rolados. Cada posicao representa um dos dados. Ou seja, a posicao 0 do array indica se o dado 1 deve ser rolado ou nao, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que nao foram rolados. Nesse caso, o valor retornado e o valor anterior que ele ja possuia.
	 */
	public int[] Rolar(boolean quais[]){
		for(int i = 0; i < numeroDados; i++){
			if(quais[i])
				this.resultadosDados[i] = dados[i].rolar();
		}
		System.out.println(this);
		return resultadosDados;
	}

	/**
	 * Rola alguns dos dados.
	 * @param s - E um String que possui o numero dos dados a serem rolados. Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados. Os numeros devem ser separados por espacos. Se o valor passado no string estiver fora do intervalo valido, ele e ignorado simplesmente.
	 * @return Retorna o valor de cada um dos dados, inclusive os que nao foram rolados. Nesse caso, o valor retornado e o valor anterior que ele ja possuia.
	 */
	public int[] Rolar(String s){
		boolean trocar[] = new boolean[numeroDados];
		for(int i = 0; i < numeroDados; i++){
			trocar[i] = false;
		}
		String txtNum = "";
		for(int j = 0; j < s.length(); j++){
			if(s.charAt(j) != ' ') txtNum+= s.charAt(j);
			else {
				int valAt = Integer.parseInt(txtNum);
				txtNum = "";
				trocar[valAt-1] = true;
			}
		}
		if(s.length() > 0){
			int valAt = Integer.parseInt(txtNum);
			trocar[valAt-1] = true;
		}
		for(int i = 0; i < numeroDados; i++){
			if(trocar[i])
				this.resultadosDados[i] = dados[i].rolar();
		}
		System.out.println(this);
		return resultadosDados;
	}


	/**
	 * Usa a representacao em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horisontalmente.
	 */
	@Override
		public String toString(){
			String S = "";
			for(int i = 0; i < numeroDados; i++){
				S += (i+1)+"       ";
			}
			S += "\n";
			for(int j = 0; j < 5; j++){
				for(int i = 0; i < numeroDados; i++){
					S += dados[i].toString().substring((7*j)+j, (7*(j+1))+j)+" ";
				}
				S += "\n";
			}
			return S;
		}

	/**
	 * Nao tem funcao real dentro da classe.
	 * Foi usada apenas para testar os metodos implementados
	 * @param args - sem uso
	 */
	public static void main(String[] args){

	}

}
