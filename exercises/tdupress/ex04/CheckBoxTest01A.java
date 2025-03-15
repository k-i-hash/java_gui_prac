package tdupress.ex04; // for tdupress

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest01A extends JFrame {
	public static void main(String[] args) {
		new CheckBoxTest01A("CheckBoxTest01A for tdupress");
	}
	public CheckBoxTest01A(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		JCheckBox button = new JCheckBox("チャーシュー");
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox("煮玉子");
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox("海苔");
		pane.add(button); // コンテントペインに追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}