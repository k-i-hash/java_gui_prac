package tdupress.ex09;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.text.PlainDocument;
import javax.swing.AbstractAction;

public class try_TextFieldTest05 extends JFrame {
	private JTextField textInput;
	private JTextField textCopied;
	public static void main(String[] args) {
		new try_TextFieldTest05("TextFieldTest05");
	}
	public try_TextFieldTest05(String title) {
		super(title);

		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	
		textInput = new JTextField();
		textInput.setBorder(new TitledBorder("Original Text"));
		textInput.addActionListener(new TextActionHandler());
		pane.add(textInput);

		textCopied = new JTextField();
		textCopied.setBorder(new TitledBorder("Copied Text"));
		pane.add(textCopied);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	class TextActionHandler extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent ae) {
			textCopied.setText(textInput.getText());
			textInput.setText("");
		}
	}
}
