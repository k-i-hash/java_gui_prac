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
import javax.swing.JPanel;

public class DialogTest02 extends JFrame {
	JPanel pane;
	JLabel label; // ラベルコンポーネントを入れるフィールド
	public static void main(String[] args) {
		new DialogTest02("DialogTest02");
	}
	public DialogTest02(String title) {
		super(title);
		// 以下、メニューの作成
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar); 

		JMenu fileMenu = new JMenu("File"); 
		menuBar.add(fileMenu); 

		fileMenu.add(new OpenAction()); 
		fileMenu.addSeparator(); 
		fileMenu.add(new ExitAction()); 

		pane = (JPanel)getContentPane();
		label = new JLabel(); // 画像表示用のラベルコンポーネント
		pane.add(label);

		addWindowListener(new WindowAdapter() { // 無名内部クラス
			public void windowClosing(WindowEvent we) {
				System.out.println("閉じるが押された。");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
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
		}
	}
}