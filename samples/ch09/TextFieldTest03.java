package ch09;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldTest03 extends JFrame {
	public static void main(String[] args) {
		new TextFieldTest03("TextFieldTest03");
	}
	public TextFieldTest03(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		JTextField tf = new JTextField();
		tf.setDocument(new PhoneNumberDocument()); 
		// 独自のドキュメントモデルを設定
		tf.setBorder(new TitledBorder("携帯電話番号"));
		pane.add(tf);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}

	class PhoneNumberDocument extends PlainDocument { 
		String validValues = "0123456789-"; // 有効な文字のみの文字列
		int maxLength = 13; // 文字列の最大長さ

		@Override
		public void insertString(int offset, String str, 
			AttributeSet a) {
				if (validValues.indexOf(str) == -1) {
					System.out.println("無効文字の入力: " + str);
					return;
				}
				int length = getLength();
				if (length >= maxLength) {
					System.out.println("長さの超過:" + length);
					return;
				}
				try{
					super.insertString(offset, str, a); 
					// スーパクラスのメソッドを呼び出し
				} catch(BadLocationException ex) {
					System.out.println(ex);
				}
		}
	}
}