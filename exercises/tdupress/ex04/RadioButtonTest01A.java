package tdupress.ex04; // for tdupress

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest01A extends JFrame {
	public static void main(String[] args) {
		new RadioButtonTest01A("RadioButtonTest01A for tdupress");
	}
	public RadioButtonTest01A(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ButtonGroup buttonGroup = new ButtonGroup(); // ボタングループの生成
		JRadioButton button = new JRadioButton("ファーストクラス");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton("ビジネスクラス");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton("エコノミークラス");
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
}