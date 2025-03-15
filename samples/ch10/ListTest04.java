package ch10;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest04 extends JFrame {
	public static void main(String[] args) {
		new ListTest04("ListTest04");
	}
	public ListTest04(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		String[] items = {"C++", "C#", "Java", "Lisp", "Perl", 
			"PHP", "Prolog", "Python", "Ruby", "Smalltalk"};
		DefaultListModel<String> listModel 
			= new DefaultListModel<String>();
		for (String element : items) {
			listModel.addElement(element);
		}
		JList<String> list1 = new JList<>(listModel); 
		// 同一のモデルでリスト生成
		JScrollPane sp1 = new JScrollPane(list1);
		pane.add(sp1);
		list1.addListSelectionListener(new ListEventHandler());
		JList<String> list2 = new JList<>(listModel); 
		// 同一のモデルでリスト生成
		list2.setCellRenderer(new UpperCellRenderer()); // レンダラを変更
		JScrollPane sp2 = new JScrollPane(list2);
		pane.add(sp2);
		list2.addListSelectionListener(new ListEventHandler());
		JList<String> list3 = new JList<>(listModel); 
		// 同一のモデルでリスト生成
		list3.setCellRenderer(new LowerCellRenderer()); // レンダラを変更
		JScrollPane sp3 = new JScrollPane(list3);
		pane.add(sp3);
		list3.addListSelectionListener(new ListEventHandler());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150);
		setVisible(true);
	}
	class UpperCellRenderer extends DefaultListCellRenderer { 
		@Override
		public Component getListCellRendererComponent(JList<?> list, 
			Object value, int index, boolean isSelected, 
			boolean cellHasFocus) {
				String s = value.toString().toUpperCase(); // 大文字に変更
				setText(s);
				if (isSelected) {
					setBackground(list.getSelectionBackground());
					setForeground(list.getSelectionForeground());
				} else {
					setBackground(list.getBackground());
					setForeground(list.getForeground());
				}
				setEnabled(list.isEnabled());
				setFont(list.getFont());
				setOpaque(true);
				return this;
		}
	}
	class LowerCellRenderer extends DefaultListCellRenderer { 
		@Override
		public Component getListCellRendererComponent(JList<?> list, 
			Object value, int index, boolean isSelected, 
			boolean cellHasFocus) {
				String s = value.toString().toLowerCase(); // 小文字に変更
				setText(s);
				if (isSelected) {
					setBackground(list.getSelectionBackground());
					setForeground(list.getSelectionForeground());
				} else {
					setBackground(list.getBackground());
					setForeground(list.getForeground());
				}
				setEnabled(list.isEnabled());
				setFont(list.getFont());
				setOpaque(true);
				return this;
		}
	}
	class ListEventHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent le) {
			JList<?> list = (JList<?>)le.getSource();
			if (le.getValueIsAdjusting() == false) {
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