import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Fabio Fogarin Destro 10284667
 * @author Vitor Gratiere Torres 10284952
 */
public class GUIDados {
	
	public static Vector<JButton> d = null;

	public GUIDados() {
		
		JFrame frmDados = new JFrame("Dados");
		frmDados.setVisible(true);
		frmDados.setSize(400, 100);
		frmDados.setLocation(300, 600);
		frmDados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = (JPanel) frmDados.getContentPane();
		jp.setLayout(new GridLayout(1, 5));
		
		d = new Vector<JButton>();
		Vector<DadoListener> lis = new Vector<DadoListener>();

		GUIMain.rola.Rolar();
		for(int i = 0; i < 5; i++) {
			d.add(new JButton(Integer.toString(GUIMain.rola.getResultadosDados()[i])));
			lis.add(new DadoListener());
			d.elementAt(i).addActionListener(lis.elementAt(i));
			jp.add(d.elementAt(i));
			d.elementAt(i).setActionCommand(Integer.toString(i));
			d.elementAt(i).setBackground(new Color(216,235,255));
		}
		
	}

}
