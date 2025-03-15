package ch05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest01 extends JFrame {
	JButton openButton, saveButton, exitButton; // ボタンを入れるフィールド
	public static void main(String[] args) {
		new ButtonTest01("ButtonTest01");
	}
	public ButtonTest01(String title){
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ActionListener listener = new ActionHandler(); // リスナの生成
		openButton = new JButton("開く"); // ボタンの生成
		pane.add(openButton); // コンテントペインに追加
		openButton.addActionListener(listener); // リスナの設定
		saveButton = new JButton("保存");
		pane.add(saveButton);
		saveButton.addActionListener(listener);
		exitButton = new JButton("終了");
		pane.add(exitButton);
		exitButton.addActionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton source = (JButton)ae.getSource(); 
			// イベントソースを得る
			if (source == openButton) { // どのボタンだったか
				System.out.println("開くが押されました。");
			} else if (source == saveButton) {
				System.out.println("保存が押されました。");
			} else if (source == exitButton) {
				System.out.println("終了が押されました。");
			}
		}
	}
}