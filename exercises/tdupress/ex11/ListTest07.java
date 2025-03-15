package tdupress.ex11; // for tdupress

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest07 extends JFrame {
	JList<String> list;
	DefaultListModel<String> listModel;
	JTextField tf;
	public static void main(String[] args) {
		new ListTest07("ListTest07 for tdupress");
	}
	public ListTest07(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.addListSelectionListener(new ListEventHandler());
		JScrollPane sp = new JScrollPane(list);
		sp.setBorder(new TitledBorder("項目一覧"));
		pane.add(sp, BorderLayout.CENTER);
		tf = new JTextField(10);
		tf.setBorder(new TitledBorder("項目"));
		pane.add(tf, BorderLayout.SOUTH);
		JToolBar tb = new JToolBar();
		tb.add(new AddAction());
		tb.add(new SetAction());
		tb.add(new RemoveAction());
		tb.add(new PreviousAddAction());
		tb.add(new NextAddAction());
		pane.add(tb, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}
	class AddAction extends AbstractAction {
		AddAction() {
			putValue(NAME, "追加");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
		String text = tf.getText();
			listModel.addElement(text); // 項目の追加
			tf.setText("");
		}
	}
	class SetAction extends AbstractAction {
		SetAction() {
			putValue(NAME, "変更");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			String text = tf.getText();
			int index = list.getSelectedIndex();
			listModel.set(index, text); // 項目の変更
			tf.setText("");
		}
	}
	class RemoveAction extends AbstractAction {
		RemoveAction() {
			putValue(NAME, "削除");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int index = list.getSelectedIndex();
			if (index < 0) {
				return;
			}
			listModel.remove(index); // 項目の削除
		}
	}
	class ListEventHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent le) {
			if (le.getValueIsAdjusting() == false) {
				int index = list.getSelectedIndex();
				if (index < 0) {
					return;
				}
				String text = listModel.get(index);
				tf.setText(text);
			}
		}
	}
	class PreviousAddAction extends AbstractAction {
		PreviousAddAction() {
			putValue(NAME, "前に追加");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int index = list.getSelectedIndex();
			String text = tf.getText();
			if (index < 0) {
				return;
			}
			list.clearSelection();
			listModel.insertElementAt(text, index); // 項目の追加
			tf.setText("");
		}
	}
	class NextAddAction extends AbstractAction {
		NextAddAction() {
			putValue(NAME, "次に追加");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			int index = list.getSelectedIndex();
			String text = tf.getText();
			if (index < 0) {
				return;
			}
			list.clearSelection();
			listModel.insertElementAt(text, index + 1); // 項目の追加
			tf.setText("");
		}
	}
}