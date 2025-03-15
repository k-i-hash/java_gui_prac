package ch09;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class TextAreaTest01 extends JFrame {
	public static void main(String[] args){
		new TextAreaTest01("TextAreaTest01");
	}
	public TextAreaTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JTextArea ta1 = new JTextArea(); // パラメータなしコンストラクタ
		ta1.setBorder(new TitledBorder("JTextArea()"));
		pane.add(ta1);

		JTextArea ta2 = new JTextArea(10, 40); // 行数、列数指定
		ta2.setBorder(new TitledBorder("JTextArea(10, 40)"));
		pane.add(ta2);

		JTextArea ta3 = new JTextArea(10, 40);
		JScrollPane sp = new JScrollPane(ta3); // スクロールペインで包む
		sp.setBorder(new TitledBorder("JScrollPaneで包む")); 
		pane.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 600);
		setVisible(true);
	}
}