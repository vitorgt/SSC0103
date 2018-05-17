import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Fabio Fogarin Destro 10284667
 * @author Vitor Gratiere Torres 10284952
 */
public class DadoListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(GUIMain.trocaDados[Integer.parseInt(e.getActionCommand())]){
			GUIDados.d.elementAt(Integer.parseInt(e.getActionCommand())).setBackground(new Color(216,235,255));
		}
		else{
			GUIDados.d.elementAt(Integer.parseInt(e.getActionCommand())).setBackground(new Color(175,190,206));
		}
		GUIMain.trocaDados[Integer.parseInt(e.getActionCommand())] = !(GUIMain.trocaDados[Integer.parseInt(e.getActionCommand())]);
	}

}
