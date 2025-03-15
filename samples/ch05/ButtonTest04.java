package ch05;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest04 extends JFrame {
	JButton openButton, saveButton, exitButton; // ボタンを入れるフィールド
	public static void main(String[] args) {
		new ButtonTest04("ButtonTest04");
	}
	public ButtonTest04(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		openButton = new JButton("開く"); // ボタンの生成
		openButton.addActionListener(
			e -> System.out.println("開くが押されました。"));
		pane.add(openButton); // コンテントペインに追加

		saveButton = new JButton("保存");
		saveButton.addActionListener(
			e -> System.out.println("保存が押されました。"));
		pane.add(saveButton);

		exitButton = new JButton("終了");
		exitButton.addActionListener(
			e -> System.out.println("終了が押されました。"));
		pane.add(exitButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
}