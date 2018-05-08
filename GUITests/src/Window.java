import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
	

	JMenu jb = new JMenu("Arquivo");
	JMenuItem arquivo = new JMenuItem("Abrir");
	JLabel label = new JLabel("Hello there");
	JTextField name = new JTextField();
	JButton button = new JButton("Confirm");
	
	public Window(String w){
		super(w);
		JPanel jp = (JPanel) this.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.add(jb);
		arquivo.setActionCommand("abrir_arquivo");
		jb.add(arquivo);
		jp.setLayout(new GridLayout(3, 1));
		jp.add(label);
		jp.add(name);
		jp.add(button);
		//button.addActionListener(this);
	}
	
	@Override
	public void acttionPerformed(ActionEvent e){
		String s = nome.getText();
		s = "WELLCOME" + " " + s;
		label.setText(s);
	}

}
