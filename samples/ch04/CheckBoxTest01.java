package ch04;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest01 extends JFrame {
	public static void main(String[] args) {
		new CheckBoxTest01("CheckBoxTest01");
	}
	public CheckBoxTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		JCheckBox button = new JCheckBox("りんご");
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox("みかん");
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox("いちご");
		pane.add(button); // コンテントペインに追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}