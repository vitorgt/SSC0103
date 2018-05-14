import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadoListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		GUIDados.d.elementAt(Integer.parseInt(e.getActionCommand())).setBackground(new Color(175,190,206));
		GUIMain.trocaDados[Integer.parseInt(e.getActionCommand())] = true;
	}

}
