package ch10;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest03 extends JFrame {
	public static void main(String[] args) {
		new ListTest03("ListTest03");
	}
	public ListTest03(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		String[] items = {"C++", "C#", "Java", "Lisp", 	"Perl", "PHP", 
			"Prolog", "Python", "Ruby", "Smalltalk"};
		DefaultListModel<String> listModel 
			= new DefaultListModel<String>();
		for (String element : items) {
			listModel.addElement(element);
		}
		JList<String> list = new JList<String>(listModel);
		JScrollPane sp = new JScrollPane(list);
		pane.add(sp);
		list.addListSelectionListener(new ListEventHandler()); 
		// リスナの設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
	class ListEventHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent le) {
			JList<?> list = (JList<?>)le.getSource();
			if (le.getValueIsAdjusting() == false) { // 選択が確定したか
				int index = list.getSelectedIndex();
				System.out.println(index + ":" 
					+ list.getSelectedValue());
				DefaultListModel<?> listModel 
					= (DefaultListModel<?>)list.getModel();
				System.out.println(index + ":" 
					+ listModel.get(index));
				System.out.println(index + ":" 
					+ listModel.getElementAt(index));
			}
		}
	}
}