package ch13;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest02 extends JFrame {
	String[][] data = {
		{"1", "伊藤", "いとう", "84", "71", "79", "48", "98"},
		{"2", "加藤", "かとう", "42", "96", "34", "73", "64"},
		{"3", "小林", "こばやし", "47", "14", "44", "86", "60"},
		{"4", "佐藤", "さとう", "47", "16", "79", "90", "93"},
		{"5", "鈴木", "すずき", "87", "24", "63", "79", "50"},
		{"6", "高橋", "たかはし", "56", "74", "58", "62", "46"},
		{"7", "田中", "たなか", "66", "50", "63", "93", "43"},
		{"8", "中村", "なかむら", "45", "29", "75", "40", "43"},
		{"9", "山本", "やまもと", "77", "68", "59", "45", "80"},
		{"10", "渡辺", "わたなべ", "74", "55", "98", "74", "48"}
	};
	String[] names = {
		"番号", "名前", "読み", "国語", "数学", "理科", "社会", "英語"
	};
	public static void main(String[] args) {
		new TableTest02("TableTest02");
	}
	public TableTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		DefaultTableModel model =  new DefaultTableModel(names, 0); 
		// 表頭のみでデータなしのモデルを生成
		for(int i=0; i<data.length; i++) {
			model.addRow(data[i]); // モデルに1行ずつデータを追加
		}
		JTable table = new JTable(model); // モデルを与えるコンストラクタ
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(table);
		pane.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setVisible(true);
	}
}