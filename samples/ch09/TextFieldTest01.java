package ch09;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TextFieldTest01 extends JFrame {
	public static void main(String[] args){
		new TextFieldTest01("TextFieldTest01");
	}
	public TextFieldTest01(String title) {
		super( title );
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JTextField tf1 = new JTextField(); 
		pane.add(tf1);

		JPanel subpane = new JPanel(); // ラベルとテキストフィールドをまとめるパネル
		subpane.setLayout(new GridLayout(1,2));
		subpane.add(new JLabel("テキストフィールド2"));
		JTextField tf2 = new JTextField(); 
		subpane.add(tf2); 
		pane.add(subpane);

		JTextField tf3 = new JTextField(); // パラメータなしコンストラクタ
		tf3.setBorder(new TitledBorder("テキストフィールド3"));
		pane.add(tf3);

		JTextField tf4 = new JTextField("初期値"); 
		// 初期文字列を与えるコンストラクタ
		tf4.setBorder(new TitledBorder("テキストフィールド4"));
		pane.add(tf4);

		JTextField tf5 = new JTextField(10); // 桁数指定コンストラクタ
		tf5.setBorder(new TitledBorder("テキストフィールド5"));
		pane.add(tf5);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	}
}