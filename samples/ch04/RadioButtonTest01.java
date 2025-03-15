package ch04;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest01 extends JFrame {
	public static void main(String[] args) {
		new RadioButtonTest01("RadioButtonTest01");
	}
	public RadioButtonTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ButtonGroup buttonGroup = new ButtonGroup(); // ボタングループの生成
		JRadioButton button = new JRadioButton("りんご");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton("みかん");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton("いちご");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}