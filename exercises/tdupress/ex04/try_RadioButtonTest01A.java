package tdupress.ex04; // for tdupress

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.awt.Font;

public class try_RadioButtonTest01A extends JFrame {
	public static void main(String[] args) {
		new try_RadioButtonTest01A("RadioButtonTest01A for tdupress");
	}
	public try_RadioButtonTest01A(String title) {
		super(title);
		
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton button = new JRadioButton("Male");
		pane.add(button);
		buttonGroup.add(button);

		button = new JRadioButton("Female");
		pane.add(button);
		buttonGroup.add(button);

		button = new JRadioButton("etc");
		pane.add(button);
		buttonGroup.add(button);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}
