/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Fabio e Vitor
 */

import java.io.IOException;

public class Bozo {

	/**
	 * Método inicial do programa.
	 * Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa uma rodada do jogo.
	 * Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher.
	 * No final das rodadas a pontuação total é exibida.
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		RolaDados rola = new RolaDados(5);
		Placar placar = new Placar();

		System.out.println(placar);

		for(int i=1;i<=10;i++){ // 10 rodadas
			System.out.printf("****** Rodada %d\nPressione ENTER para lançar os dados\n",i);
			String aux = EntradaTeclado.leString();

			for(int t = 0;t<2;t++){
				if(t == 0) rola.Rolar();
				System.out.printf("Digite os números dos dados que quiser TROCAR. Separados por espaços.\n");
				String trocarDados = EntradaTeclado.leString();
				boolean trocar[] = {false, false, false, false,false};
				String txtNum = "";
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
				rola.Rolar(trocar);
			}

			System.out.printf("\n\n\n");
			System.out.println(placar);

			System.out.print("Escolha a posição que quer ocupar com essa jogada ===> ");
			int pos = EntradaTeclado.leInt();

			placar.add(pos, rola.getResultadosDados());
			System.out.println(placar);
		}
		System.out.printf("Placar final: %d\n",placar.getScore());
	}

}
