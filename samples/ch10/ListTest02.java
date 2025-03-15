package ch10;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListTest02 extends JFrame {
	public static void main(String[] args) {
		new ListTest02("ListTest02");
	}
	public ListTest02(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		String[] items = {"C++", "C#", "Java", "Lisp", 
			"Perl", "PHP", "Prolog", "Python", "Ruby", 
			"Smalltalk"};
		DefaultListModel<String> listModel 
			= new DefaultListModel<String>(); // リストモデルを生成
		for (String element : items) {
			listModel.addElement(element); // リストモデルに項目を追加
		}
		JList<String> list = new JList<String>(listModel); 
		// モデルをとるコンストラクタ
		JScrollPane sp = new JScrollPane(list);
		pane.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
}