import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import BozoException.BozoException;

public class BozoListener implements ActionListener{
	
	private enum Pos {Ás,Duque,Terno,Quadra,Quina,Sena,Full,Seguida,Quadrada,General,Rolar};
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		try {
			Integer.parseInt(e.getActionCommand());
			JOptionPane.showMessageDialog(null, "Posição já ocupada");
			GUIMain.i = 0;
		}
		catch (Exception ee) {
			if(e.getActionCommand().equals("Rolar")) {
				if(GUIMain.i < 2) {
					JOptionPane.showMessageDialog(null, Character.toString((char)('1'+GUIMain.i))+"a vez rolando os dados");
					int[] temp = GUIMain.rola.Rolar(GUIMain.trocaDados);
					GUIMain.i += 1;
					for(int i = 0; i < 5; i++)
						GUIDados.d.elementAt(i).setText(Integer.toString(temp[i]));
					GUIMain.limpaTroca();
				}
				else {
					JOptionPane.showMessageDialog(null, "Já rolou os dados duas vezes, proibido rolar denovo");
				}
			}
			else if(!e.getActionCommand().equals("Bozo Game :)")){
				int i = Pos.valueOf(e.getActionCommand()).ordinal();
				try {
					GUIMain.placar.add(i+1, GUIMain.rola.getResultadosDados());
				} catch (BozoException e1) {}
				GUIBozo.b.elementAt(i).setText(Integer.toString(GUIMain.placar.getPlacar()[i]));
				GUIBozo.b.elementAt(i).setBackground(new Color(204,204,204));
				
				GUIMain.i = 0;
				GUIMain.rodada += 1;
				GUIMain.limpaTroca();
				
				int[] temp = GUIMain.rola.Rolar();
				for(int j = 0; j < 5; j++)
					GUIDados.d.elementAt(j).setText(Integer.toString(temp[j]));
				
				//GUIMain.rola.Rolar();
				if(GUIMain.rodada == 10){
					JOptionPane.showMessageDialog(null, "Placar final: " + GUIMain.placar.getScore());
				}
			}
		}
	}

}
