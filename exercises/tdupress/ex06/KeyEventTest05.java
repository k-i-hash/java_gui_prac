package tdupress.ex06; // for tdupress

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest05 extends JFrame {
	private char keyChar;
	private JPanel pane, testPanel;
	public static void main(String[] args) {
		new KeyEventTest05("KeyEventTest05 for tdupress");
	}
	public KeyEventTest05(String title) {
		super(title);
		pane = (JPanel)getContentPane();

		testPanel = new TestPanel(); // 描画用パネルの生成
		testPanel.setFocusable(true); // パネルでキーボード入力を扱う場合に必要
		testPanel.addKeyListener(new KeyHandler()); // リスナの設定

		pane.add(testPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}
	class TestPanel extends JPanel { // 独自のパネルを定義
		@Override
		public void paintComponent(Graphics g) { // ここに描画したい内容を書く
			super.paintComponent(g); // 背景を再描画する
			g.setColor(Color.black); // 色を設定
			int x = pane.getWidth() / 2;
			int y = pane.getHeight() / 2;
			g.drawString(String.valueOf(keyChar), x, y); // 文字を描く
		}
	}
	class KeyHandler extends KeyAdapter { // キーアダプタの継承
		@Override
		public void keyPressed(KeyEvent ke) {
			keyChar = ke.getKeyChar();
			testPanel.repaint(); // パネルを明示的に再描画
		}
	}
}