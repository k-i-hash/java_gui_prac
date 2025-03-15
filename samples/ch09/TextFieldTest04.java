package ch09;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.PlainDocument;

public class TextFieldTest04 extends JFrame {
	public static void main(String[] args) {
		new TextFieldTest04("TextFieldTest04");
	}
	public TextFieldTest04( String title ){
		super( title );
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		PlainDocument pd = new PlainDocument(); // 共通のドキュメント

		JTextField tf1 = new JTextField();
		tf1.setDocument(pd); // 同一のドキュメントを設定
		tf1.setBorder(new TitledBorder("テキストフィールド1"));
		pane.add(tf1);

		JTextField tf2 = new JTextField();
		tf2.setDocument(pd); // 同一のドキュメントを設定
		tf2.setBorder(new TitledBorder("テキストフィールド2"));
		pane.add(tf2);

		JTextField tf3 = new JTextField();
		tf3.setDocument(pd); // 同一のドキュメントを設定
		tf3.setBorder(new TitledBorder("テキストフィールド3"));
		pane.add(tf3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	}
}