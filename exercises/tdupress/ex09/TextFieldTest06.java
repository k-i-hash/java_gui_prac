package tdupress.ex09; // for tdupress

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldTest06 extends JFrame {
	JTextField left, right, answer;
	JButton addition, subtraction, multiplication, division;

	public static void main(String[] args) {
		new TextFieldTest06("TextFieldTest06 for tdupress");
	}

	public TextFieldTest06(String title) {
		super( title );
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BorderLayout());

		left = new JTextField(5);
		left.setBorder(new TitledBorder("整数1"));
		left.setDocument(new NumericDocument());
		pane.add(left, BorderLayout.WEST);

		right = new JTextField(5);
		right.setBorder(new TitledBorder("整数2"));
		right.setDocument(new NumericDocument());
		pane.add(right, BorderLayout.EAST);

		answer = new JTextField(10);
		answer.setBorder(new TitledBorder("答"));
		answer.setEditable(false);
		pane.add(answer, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		addition = new JButton(new AdditionAction());
		panel.add(addition);
		subtraction = new JButton(new SubtractionAction());
		panel.add(subtraction);
		multiplication = new JButton(new MultiplicationAction());
		panel.add(multiplication);
		division = new JButton(new DivisionAction());
		panel.add(division);
		pane.add(panel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 180);
		setVisible(true);
	}
	class AdditionAction extends AbstractAction {
		AdditionAction() {
			putValue(NAME, "+" );
			putValue(SHORT_DESCRIPTION, "足す");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int ans = Integer.parseInt(left.getText()) + Integer.parseInt(right.getText());
			answer.setText(String.valueOf(ans));
		}
	}
	class SubtractionAction extends AbstractAction {
		SubtractionAction() {
			putValue(NAME, "-" );
			putValue(SHORT_DESCRIPTION, "引く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int ans = Integer.parseInt(left.getText()) - Integer.parseInt(right.getText());
			answer.setText(String.valueOf(ans));
		}
	}
	class MultiplicationAction extends AbstractAction {
		MultiplicationAction() {
			putValue(NAME, "*");
			putValue(SHORT_DESCRIPTION, "掛ける");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int ans = Integer.parseInt(left.getText()) * Integer.parseInt(right.getText());
			answer.setText(String.valueOf(ans));
		}
	}
	class DivisionAction extends AbstractAction {
		DivisionAction() {
			putValue(NAME, "/");
			putValue(SHORT_DESCRIPTION, "割る");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int ans = Integer.parseInt(left.getText()) / Integer.parseInt(right.getText());
			answer.setText(String.valueOf(ans));
		}
	}

	class NumericDocument extends PlainDocument { 
		String validValues = "0123456789-";

		@Override
		public void insertString(int offset, String str, AttributeSet a) {
			if(validValues.indexOf(str) == -1) { 
				return;
			}
			try {
				super.insertString(offset, str, a); 
    		}
			catch(BadLocationException e) {
				System.out.println(e);
			}
		}
	}
}