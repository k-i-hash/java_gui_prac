package ch05;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest02 extends JFrame {
	JButton openButton, saveButton, exitButton; // ボタンを入れるフィールド
	public static void main(String[] args) {
		new ButtonTest02("ButtonTest02");
	}
	public ButtonTest02(String title){
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		openButton = new JButton(new OpenAction()); // アクションの生成
		pane.add(openButton); // コンテントペインに追加
		saveButton = new JButton(new SaveAction());
		pane.add(saveButton);
		exitButton = new JButton(new ExitAction());
		pane.add(exitButton);
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