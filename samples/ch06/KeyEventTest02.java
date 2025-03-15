package ch06;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest02 extends JFrame {
	public static void main(String[] args) {
		new KeyEventTest02("KeyEventTest02");
	}
	public KeyEventTest02(String title) {
		super(title);
		JPanel panel = (JPanel)getContentPane();
		panel.setFocusable(true);
		panel.addKeyListener(new KeyHandler()); // キーリスナの設定 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
	class KeyHandler extends KeyAdapter { // キーアダプタの継承
	@Override
		public void keyTyped(KeyEvent ke) {
			System.out.println("キーがタイプされた");
		}
	}
}