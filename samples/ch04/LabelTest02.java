package ch04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelTest02 extends JFrame {
	public static void main(String[] args) {
		new LabelTest02("LabelTest02"); 
	}
	public LabelTest02(String title) { // コンストラクタ
		super(title	);
		JPanel pane = (JPanel)getContentPane();
		JLabel label = new JLabel("出口");  // 文字列を指定してラベルを生成
		label.setIcon(new ImageIcon("exit.png")); // アイコンを設定
		pane.add(label); // ラベルをコンテントペインに追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}
}