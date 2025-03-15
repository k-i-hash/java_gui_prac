package tdupress.ex10; // for tdupress

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ListTest05 extends JFrame {
	JList<String> list;
	public static void main(String[] args) {
		new ListTest05("ListTest05 for tdupress");
	}
	public ListTest05(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list = new JList<>(listModel);
		JScrollPane sp = new JScrollPane(list);
		sp.setBorder(new TitledBorder("項目一覧"));
		pane.add(sp);
		JTextField tf = new JTextField(10);
		tf.setBorder(new TitledBorder("項目追加"));
		tf.addActionListener(new ActionEventHandler()); // アクションリスナの設定
		pane.add(tf);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
	class ActionEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			JTextField tf = (JTextField)ae.getSource();
			String text = tf.getText(); // テキストフィールドの文字列を得る
			if (text.length() != 0) {
				DefaultListModel<String> listModel = (DefaultListModel<String>)list.getModel();
				listModel.addElement(text); // リストに項目を追加
				tf.setText("");		
			}
		}
	}
}