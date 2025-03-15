package ch08;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogTest04 extends JFrame {
	JPanel pane;
	JLabel label; // 画像を表示するためのラベル
	public static void main(String[] args) {
		new DialogTest04("DialogTest04");
	}
	public DialogTest04(String title){
		super(title);

		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar); 

		JMenu fileMenu = new JMenu("File"); 
		menuBar.add(fileMenu); 

		fileMenu.add(new OpenAction()); 
		fileMenu.addSeparator(); 
		fileMenu.add(new ExitAction()); 

		pane = (JPanel)getContentPane();
		label = new JLabel();
		pane.add(label);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("閉じるが押された。");
				confirmExit();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	private void confirmExit() {
		String msg = "終了してもよいですか?";
		int ans = JOptionPane.showConfirmDialog(pane, msg); 
		if (ans == 0) {
			System.out.println("終了します。");
			System.exit(0);
		}
		System.out.println("終了しません。");
	}
	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("終了が選ばれました。");
			confirmExit();
		}
	}
	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("開くが選ばれました。");
			JFileChooser fileChooser = new JFileChooser("."); 
			// カレントディレクトリを指定
			int ans = fileChooser.showOpenDialog(label); 
			// ファイルダイアログを開く
			if(ans != JFileChooser.APPROVE_OPTION) { 
			// OKでなければ何もしない
				return; 
			}
			File file = fileChooser.getSelectedFile(); 
			// 選択されたファイルを得る
			String fileName = file.getAbsolutePath(); 
			// ファイルの絶対パスを得る
			ImageIcon image = new ImageIcon(fileName); 
			// 画像アイコンを生成
			label.setIcon(image); // ラベルに画像を設定
		}
	}
}