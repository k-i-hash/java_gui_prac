package tdupress.ex09; // for tdupress

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TextFieldTest05 extends JFrame {
	JTextField tf1, tf2;

	public static void main(String[] args) {
		new TextFieldTest05("TextFieldTest05 for tdupress");
	}
	public TextFieldTest05(String title) {
		super( title );
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		tf1 = new JTextField();
		tf1.setBorder( new TitledBorder("コピー元"));
		tf1.addActionListener(new ActionHandler());
		pane.add(tf1);

		tf2 = new JTextField();
		tf2.setBorder(new TitledBorder("コピー先"));
		pane.add(tf2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(150, 120);
		setVisible(true);
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			tf2.setText(tf1.getText());
			tf1.setText("");
		}
	}
}