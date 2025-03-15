package ch05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ButtonTest03 extends JFrame {
	JButton openButton, saveButton, exitButton; 
	public static void main(String[] args) {
		new ButtonTest03("ButtonTest03");
	}
	public ButtonTest03(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();

		JPanel panel = new JPanel(); // ボタンをまとめるパネル
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		openButton = new JButton(new OpenAction()); 
		panel.add(openButton); 
		saveButton = new JButton(new SaveAction());
		panel.add(saveButton);
		exitButton = new JButton(new ExitAction());
		panel.add(exitButton);
		pane.add(panel, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar(); // ツールバー
		pane.add(toolBar, BorderLayout.NORTH);

		toolBar.add(new OpenAction());
		toolBar.add(new SaveAction());
		toolBar.addSeparator();
		toolBar.add(new ExitAction());

		JMenuBar menuBar = new JMenuBar(); // メニューバー
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("ファイル");
		menuBar.add(menu);

		menu.add(new OpenAction());
		menu.add(new SaveAction());
		menu.addSeparator();
		menu.add(new ExitAction());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}

	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(Action.NAME, "開く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("開くが押されました。");
		}
	}
	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(Action.NAME, "保存");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("保存が押されました。");
		}
	}
	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(Action.NAME, "終了");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("終了が押されました。");
		}
	}
}