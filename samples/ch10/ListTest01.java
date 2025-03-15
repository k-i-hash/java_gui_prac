package ch10;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListTest01 extends JFrame {
	public static void main(String[] args) {
		new ListTest01("ListTest01");
	}
	public ListTest01(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		String[] items = {"C++", "C#", "Java", "Lisp", 
			"Perl", "PHP", "Prolog", "Python", "Ruby", 
			"Smalltalk"}; // 配列で項目を用意
		JList<String> list = new JList<String>(items); 
		// 配列をとるコンストラクタ
		JScrollPane sp = new JScrollPane(list); // スクロールペインで包む
		pane.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
}