import java.io.IOException;

/**
 * Essa e a classe inicial do programa Bozo. Possui apenas o metodo main, que cuida da execucao do jogo.
 * @author Fabio Fogarin Destro - 10284667 e Vitor Gratiere Torres - 10284952
 */
public class Bozo {

	/**
	 * Metodo inicial do programa.
	 * Ele cuida da execucao do jogo e possui um laco, no qual cada iteracao representa uma rodada do jogo.
	 * Em cada rodada, o jogador joga os dados ate 3 vezes e depois escolhe a posicao do placar que deseja preencher.
	 * No final das rodadas a pontuacao total e exibida.
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		RolaDados rola = new RolaDados(5);
		Placar placar = new Placar();

		System.out.println(placar);

		for(int i=1;i<=10;i++){ // 10 rodadas
			System.out.printf("****** Rodada %d\nPressione ENTER para lancar os dados\n",i);
			String aux = EntradaTeclado.leString(); // serve para ler o enter do usuario
			
			for(int t = 0;t<2;t++){ // duas vezes para mudar os dados
				if(t == 0) rola.Rolar();
				System.out.printf("Digite os numeros dos dados que quiser TROCAR. Separados por espacos.\n");
				String trocarDados = EntradaTeclado.leString();
				boolean trocar[] = {false, false, false, false,false};
				String txtNum = "";
				try{
					for(int j=0;j<trocarDados.length();j++){
						if(trocarDados.charAt(j) != ' ') txtNum+= trocarDados.charAt(j);
						else {
							int valAt = Integer.parseInt(txtNum);
							txtNum = "";
							trocar[valAt-1] = true;
						}
					}
					if(trocarDados.length() > 0){
						int valAt = Integer.parseInt(txtNum);
						trocar[valAt-1] = true;
					}
				}catch(Exception e){
					/* caso algum espaço seja digitado a mais e uma conversão da string "" para int tente acontecer
					evita que o programa pare e continua trocando o que necessário! */
				}
				rola.Rolar(trocar); // troca os dados necessários
			}

			System.out.printf("\n\n\n");
			System.out.println(placar);

			while(true){ // enquanto a posição digitada não for valida
				System.out.print("Escolha a posicao que quer ocupar com essa jogada ===> ");
				int pos = EntradaTeclado.leInt();

				try{
					placar.add(pos, rola.getResultadosDados());
					break; // a posição digitada é valida, sai do Loop
				}catch(Exception e){
					System.out.printf("Valor inválido. Posição ocupada ou inexistente.\n");
				}
			}
			System.out.println(placar);
		}
		System.out.printf("Placar final: %d\n",placar.getScore());
	}

}
