package ch13;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest03 extends JFrame {
	String[][] data = null;
	String[] names = null;
	JTable table = null;
	DefaultTableModel model = null;
	JFrame frame = null;
	public static void main(String[] args) {
		new TableTest03("TableTest03");
	}
	public TableTest03(String title) {
		super(title);
		frame = this;
		JPanel pane = (JPanel)getContentPane();
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		JMenu fileMenu = new JMenu("ファイル");
		mb.add(fileMenu);
		fileMenu.add(new OpenAction());
		fileMenu.add(new SaveAction());
		fileMenu.addSeparator();
		fileMenu.add(new ExitAction());
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(table);
		pane.add(sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setVisible(true);
	}
	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fileChooser = new JFileChooser("."); 
			int ans = fileChooser.showOpenDialog(frame); 
			if(ans != JFileChooser.APPROVE_OPTION) {
				return; 
			}
			File file = fileChooser.getSelectedFile();
			String fileName = file.getAbsolutePath(); 
			frame.setTitle(fileName);
			readData(fileName); // ファイルから読み込むメソッド
		}
	}
	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(Action.NAME, "保存");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fileChooser = new JFileChooser("."); 
			int ans = fileChooser.showSaveDialog(frame); 
			if(ans != JFileChooser.APPROVE_OPTION) {
				return; 
			}
			File file = fileChooser.getSelectedFile();
			String fileName = file.getAbsolutePath(); 
			frame.setTitle(fileName);
			writeData(fileName); // ファイルに書き出すメソッド
		}
	}
	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			String msg = "終了してもよいですか?";
			int ans = JOptionPane.showConfirmDialog(frame, msg); 
			if (ans == 0) {
				System.exit(0);
			}
		}
	}
	private void readData(String csvFileName){
		try {
			File file = new File(csvFileName);
			BufferedReader reader 
				= new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "Shift-JIS"));
			String line = reader.readLine();
			String[] row = line.split(",");
			model = new DefaultTableModel(row, 0);
			while ((line = reader.readLine() ) != null) {
				row = line.split(","); // 1行のデータをカンマで分割
				model.addRow(row); // 配列で1行追加
			}
			table.setModel(model);
			reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} 
	private void writeData(String csvFileName) {
		try {
			File file = new File(csvFileName);
			PrintWriter writer 
				= new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(
						file), "Shift-JIS")));
			int rowNum = model.getRowCount(); // 行の数
			int colNum = model.getColumnCount(); // 列の数
			for (int i=0; i<colNum; i++) {
				writer.print(model.getColumnName(i));
				if (i < colNum-1) { // 表頭の最後のデータでなければ
					writer.print(","); // データにカンマを連結
				}
			}
			writer.println();
			for (int i=0; i<rowNum; i++) {
				for (int j=0; j<colNum; j++) {
					writer.print(model.getValueAt(i, j));
					if (j < colNum-1) { // 行の最後のデータでなければ
						writer.print(","); // データにカンマを連結
					}
				}
				writer.println();
			}
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}