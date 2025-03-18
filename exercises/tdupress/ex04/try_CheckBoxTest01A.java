package tdupress.ex04; // for tdupress

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class try_CheckBoxTest01A extends JFrame {
	public static void main(String[] args) {
		new try_CheckBoxTest01A("CheckBoxTest01A for tdupress");
	}
	public try_CheckBoxTest01A(String title) {
		super(title);

		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JCheckBox checkBox = new JCheckBox("studing English");
		pane.add(checkBox);

		checkBox = new JCheckBox("playing Game");
		pane.add(checkBox);

		checkBox = new JCheckBox("going to the School");
		pane.add(checkBox);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}
