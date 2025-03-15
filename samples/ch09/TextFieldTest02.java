package ch09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TextFieldTest02 extends JFrame {
	public static void main(String[] args) {
		new TextFieldTest02("TextFieldTest02");
	}
	public TextFieldTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		JTextField tf = new JTextField(); 
		tf.setBorder(new TitledBorder("テキストを入力してエンター"));
		tf.addActionListener(new TextActionHandler()); 
		// アクションリスナの設定
		pane.add(tf);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 100);
		setVisible(true); 
	}
	class TextActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JTextField field = (JTextField)ae.getSource();
			String string = field.getText();
			System.out.println("入力されたテキスト: " + string);
		}
	}
}