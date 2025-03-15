package ch06;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest04 extends JFrame {
	private int currentX = 100, currentY = 100; // 現在の座標を保持
	private TestPanel testPanel; // 作成したパネルを入れる
	public static void main(String[] args) {
		new KeyEventTest04("KeyEventTest04");
	}
	public KeyEventTest04(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		testPanel = new TestPanel(); // 描画用パネルの生成
		testPanel.setFocusable(true); // パネルでキーボード入力を扱う場合に必要
		testPanel.addKeyListener(new KeyHandler()); // リスナの設定

		pane.add(testPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class TestPanel extends JPanel { // 独自のパネルを定義
		@Override
		public void paintComponent(Graphics g) { // ここに描画したい内容を書く
			super.paintComponent(g); // 背景を再描画する
			g.setColor(Color.blue); // 色を設定
			g.fillOval(currentX, currentY, 10, 10); // 塗りつぶしの円を描く
		}
	}
	class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent ke) {
			int keyCode = ke.getKeyCode();
			switch (keyCode) { // キーによって
				case KeyEvent.VK_UP: // ↑
					currentY -= 2;
					break;
				case KeyEvent.VK_DOWN: // ↓
					currentY += 2;
					break;
				case KeyEvent.VK_LEFT: // ←
					currentX -= 2;
					break;
				case KeyEvent.VK_RIGHT: // →
					currentX += 2;
					break;
				default:
					break;
			}
			testPanel.repaint(); // パネルを明示的に再描画
		}
	}
}