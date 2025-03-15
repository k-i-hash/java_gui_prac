package ch08;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogTest03 extends JFrame {
	JPanel pane;
	JLabel label;
	public static void main(String[] args) {
		new DialogTest03("DialogTest03");
	}
	public DialogTest03(String title) {
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

		addWindowListener(new WindowAdapter() { // 無名内部クラス
			public void windowClosing(WindowEvent we) {
				System.out.println("閉じるが押された。");
				confirmExit(); // 破壊的な行為なのでユーザに確認する
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		// 何もしないように設定
		setSize(400, 300);
		setVisible(true);
	}
	private void confirmExit() { // ダイアログで確認
		String msg = "終了してもよいですか?";
		int ans = JOptionPane.showConfirmDialog(pane, msg); 
		if (ans == 0) {
			System.out.println("終了します。");
			System.exit(0); // プログラムの終了
		}
		System.out.println("終了しません。");
	}
	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("開くが選ばれました。");
		}
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
}