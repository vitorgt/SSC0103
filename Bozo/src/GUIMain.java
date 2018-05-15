import java.awt.Color;

import javax.swing.JOptionPane;

/**
 * @author Fabio Fogarin Destro 10284667
 * @author Vitor Gratiere Torres 10284952
 */
public class GUIMain {
	
	private static GUIBozo bozo = null;
	private static GUIDados dados = null;
	public static RolaDados rola = null;
	public static Placar placar = null;
	public static int i = 0;
	public static int rodada = 0;
	public static boolean[] trocaDados = null;

	public static void main(String[] args) throws InterruptedException {
		trocaDados = new boolean[5];
		rola  = new RolaDados(5);
		placar = new Placar();
		bozo = new GUIBozo();
		dados = new GUIDados();
		limpaTroca();
		
		JOptionPane.showMessageDialog(null, "Clique nos dados que deseja trocar,\nem seguida rolar para efetuar troca.\nClique no tabuleiro para selecionar a\nposicao que deseja fazer a jogada");
	}
	
	public static void limpaTroca(){
		for(int i = 0; i < 5; i++){
			GUIMain.trocaDados[i] = false;
			GUIDados.d.elementAt(i).setBackground(new Color(216,235,255));
		}
		
	}

}
