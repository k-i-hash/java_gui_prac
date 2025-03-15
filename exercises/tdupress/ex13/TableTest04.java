package tdupress.ex13; // for tdupress

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class TableTest04 extends JFrame {
	JButton addRowButton; 
	JPanel pane;
	DefaultTableModel model;
	JTable table;

	public static void main(String[] args) {
		new TableTest04("TableTest04 for tdupress");
	}
	public TableTest04(String title) {
		super( title );
		pane = (JPanel) getContentPane();
		String[] columnNames = {"名前", "住所", "電話", "メール"};
		model =  new DefaultTableModel(columnNames, 0);

		table = new JTable();
		JScrollPane scroll = new JScrollPane( table );
		table.setModel( model );
		pane.add( scroll, BorderLayout.CENTER );

		JToolBar tb = new JToolBar();
		addRowButton = new JButton(new AddRowAction());
		tb.add( addRowButton );
		pane.add(tb, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 600, 300 );
		setVisible( true );
	}
	class AddRowAction extends AbstractAction {
		AddRowAction() {
			putValue(NAME, "行の追加");
			putValue(SHORT_DESCRIPTION, "行の追加");
		}
		@Override
		public void actionPerformed( ActionEvent e) {
			Vector<String> newData = new Vector<String>();
			model.addRow(newData);
		}
	}
}