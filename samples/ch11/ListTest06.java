package ch11;
// Eclipse で開くと import文が自動的に補完されるので、本と行数がずれます
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class ListTest06 extends JFrame {
	JList<String> list;
	DefaultListModel<String> listModel;
	JTextField tf;
	public static void main(String[] args) {
		new ListTest06("ListTest06");
	}
	public ListTest06(String title) {
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
		pane.add(tb, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,200);
		setVisible(true);
	}
	class AddAction extends AbstractAction {
		AddAction() {
			putValue(NAME, "追加");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ここを作る

		}
	}
	class SetAction extends AbstractAction {
		SetAction() {
			putValue(NAME, "変更");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ここを作る

		}
	}
	class RemoveAction extends AbstractAction {
		RemoveAction() {
			putValue(NAME, "削除");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ここを作る

		}
	}
	class ListEventHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent le) {
		if (le.getValueIsAdjusting() == false) {
			// ここを作る

			}
		}
	}
}