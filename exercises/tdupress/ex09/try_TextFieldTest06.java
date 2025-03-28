package tdupress.ch09;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class try_TextFieldTest06 extends JFrame {
	private JTextArea ta1, ta2, taAns;
	public static void main(String[] args) {
		new try_TextFieldTest06("TextFieldTest06");
	}
	public try_TextFieldTest06 (String title) {
		super(title);

		JPanel pane = (JPanel)getContentPane();
		ta1 = new JTextArea(20, 10);
		ta2 = new JTextArea(20, 10);
		taAns = new JTextArea();
		taAns.setEditable(false);
		JPanel buttonPanel = new JPanel();

		ta1.setBorder(new TitledBorder("Integer 1"));
		ta2.setBorder(new TitledBorder("Integer 2"));
		taAns.setBorder(new TitledBorder("Answer"));

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		JButton plus = new JButton(new CulculateAction("+"));
		JButton minus = new JButton(new CulculateAction("-"));
		JButton multiplication = new JButton(new CulculateAction("*"));
		JButton division = new JButton(new CulculateAction("/"));
		plus.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		minus.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		multiplication.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		division.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		buttonPanel.add(plus);
		buttonPanel.add(minus);
		buttonPanel.add(multiplication);
		buttonPanel.add(division);

		pane.add(ta1, BorderLayout.WEST);
		pane.add(ta2, BorderLayout.EAST);
		pane.add(taAns, BorderLayout.SOUTH);
		pane.add(buttonPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	class CulculateAction extends AbstractAction {
		private String operator;
		private int int1, int2, ans;
		String validValues = "0123456789-";

		CulculateAction(String inputOperator) {
			operator = inputOperator;
			putValue(Action.NAME, operator);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			String input1 = ta1.getText();
			String input2 = ta2.getText();
			if (validValues.indexOf(input1) == -1) {
				System.out.println("Don't use: " + input1);
				return;
			}
			if (validValues.indexOf(input2) == -1) {
				System.out.println("Don't use: " + input2);
				return;
			}
			int1 = Integer.parseInt(input1);
			int2 = Integer.parseInt(input2);

			if (operator == "+") {
				ans = int1 + int2;
			} else if (operator == "-") {
				ans = int1 - int2;
			} else if (operator == "*") {
				ans = int1 * int2;
			} else if (operator == "/") {
				ans = int1 / int2;
			}
			taAns.setText(Integer.toString(ans));
		}
	}
}
