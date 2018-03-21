
/**
 * Esta classe representa o placar de um jogo de Bozó.
 * Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Fabio e Vitor
 *
 */
public class Placar {

	private int[] placar = {-1, -1,-1, -1,-1, -1,-1, -1,-1, -1};

	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar.
	 * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 * @param posicao - Posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados - um array de inteiros, de tamanho 5. Cada posição corresponde a um valor de um dado. Supões-se que cada dado pode ter valor entre 1 e 6.
	 * @throws IllegalArgumentException - Se a posição estiver ocupada ou se for passado um valor de posição inválido, essa exceção é lançada. Não é feita nenhuma verificação quanto ao tamanho do array nem quanto ao seu conteúdo.
	 */
	public void add(int posicao, int[] dados) {
		if(placar[posicao-1] != -1 || posicao < 1 || posicao > 10) {
			throw new IllegalArgumentException("Parametros invalidos"); 
		}

		int[] qtd = {0,0,0,0,0,0}; // quantidade de vezes temos um dado com tal valor
		int dupla = 0,tripla = 0, quadra = 0, quina = 0;

		for(int i=0;i<dados.length;i++){
			int p = dados[i]-1; // referente a cada dado [0,5]
			qtd[p]++;
			if(qtd[p] == 2) dupla++;
			else if(qtd[p] == 3) tripla++;
			else if(qtd[p] == 4) quadra++;
			else if(qtd[p] == 5) quina++;
		}

		if(posicao <= 6){
			placar[posicao-1] = posicao*qtd[posicao-1];
		}else if (posicao == 7) {
			if((tripla >=1 && dupla >=2) || quina == 1){ // 1 tripla e 2 duplas, pq a tripla tb conta como dupla, ou quina (3 e 2) do mesmo
				placar[posicao-1] = 15;
			}else {
				placar[posicao-1] = 0;
			}
		}else if(posicao == 8){
			//verifica sequencia
			boolean seq = true;
			for(int i=0;i<5;i++){
				if(qtd[i] == 0) { // quebrou a sequencia de 1 a 5
					seq = false;
					break;
				}
			}
			if(!seq){
				seq = true;
				for(int i=1;i<6;i++){
					if(qtd[i] == 0) { // quebrou a sequencia de 2 a 6
						seq = false;
						break;
					}
				}
			}

			if(seq){
				placar[posicao-1] = 20;
			}else {
				placar[posicao-1] = 0;
			}

		}else if(posicao == 9){
			if(quadra >=1){
				placar[posicao-1] = 30;
			}else{
				placar[posicao-1] = 0;
			}
		}else if(posicao == 10){
			if(quina >=1){
				placar[posicao-1] = 40;
			}else{
				placar[posicao-1] = 0;
			}
		}

	}

	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 * @return O valor da soma.
	 */
	public int getScore(){
		int resp = 0;
		for(int i=0;i<placar.length;i++){
			if(placar[i] != -1) resp+=placar[i];
		}
		return resp;
	}

	/**
	 * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas.
	 */
	@Override
		public String toString(){
			String[] val = new String[10];

			for(int i=0;i<10;i++){
				if(placar[i] == -1){
					val[i] = "(" + Integer.toString(i+1) + ")";
				}else {
					val[i] = Integer.toString(placar[i]);
				}
			}

			String strplacar = "\n";
			strplacar += val[0]+"    |   "+val[6]+"    |   "+val[3]+"\n";
			strplacar += "--------------------------\n";
			strplacar += val[1]+"    |   "+val[7]+"    |   "+val[4]+"\n";
			strplacar += "--------------------------\n";
			strplacar += val[2]+"    |   "+val[8]+"    |   "+val[5]+"\n";
			strplacar += "--------------------------\n";
			strplacar += "       |   "+val[9]+"   |\n";
			strplacar += "       +----------+\n";
			return strplacar;
		}

}
