package ch09;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.PlainDocument;

public class TextAreaTest02 extends JFrame {
	JTextArea ta;
	TextAreaTest02 frame;

	public static void main(String[] args) {
		new TextAreaTest02("無題");
	}
	public TextAreaTest02(String title) {
		super(title);
		frame = this;
		JPanel pane = (JPanel)getContentPane();

		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		pane.add(sp);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("ファイル");
		menuBar.add(file);
		JMenu edit = new JMenu("編集");
		menuBar.add(edit);
		file.add(new NewAction("新規作成"));
		file.add(new OpenAction("開く..."));
		file.add(new SaveAction("保存..."));
		edit.add(new CutAction("切り取り"));
		edit.add(new CopyAction("コピー"));
		edit.add(new PasteAction("貼り付け"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}
	class NewAction extends AbstractAction {
		NewAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			new TextAreaTest02("無題"); // 新しくウィンドウを開く
		}
	}
	class OpenAction extends AbstractAction {
		OpenAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fc = new JFileChooser(".");
			int ans = fc.showOpenDialog(frame);
			File file = fc.getSelectedFile();
			if (ans != JFileChooser.APPROVE_OPTION || file == null) {
				return;
			}
			frame.setTitle(file.getName());
			try {
				FileReader reader = new FileReader(file);
				ta.read(reader, new PlainDocument()); 
				// ファイルから読み込む
				reader.close();
			} catch(FileNotFoundException ex) {
				ex.printStackTrace();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	class SaveAction extends AbstractAction {
		SaveAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fc = new JFileChooser(".");
			int ans = fc.showSaveDialog(frame);
			File file = fc.getSelectedFile();
			if (ans != JFileChooser.APPROVE_OPTION || file == null) {
				return;
			}
			frame.setTitle(file.getName());
			try {
				FileWriter writer = new FileWriter(file);
				ta.write(writer); // ファイルに書き出す
				writer.close();
			} catch(FileNotFoundException ex) {
				ex.printStackTrace();
			} catch(IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	class CutAction extends AbstractAction {
		CutAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			ta.cut(); // カット
		}
	}

	class CopyAction extends AbstractAction {
		CopyAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			ta.copy(); // コピー
		}
	}

	class PasteAction extends AbstractAction {
		PasteAction(String text) {
			super(text);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			ta.paste(); // ペースト
		}
	}
}