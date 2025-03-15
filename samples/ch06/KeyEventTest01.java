package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest01 extends JFrame {
	public static void main(String[] args) {
		new KeyEventTest01("KeyEventTest01");
	}
	public KeyEventTest01(String title){
		super(title);
		JPanel panel = (JPanel)getContentPane();
		panel.setFocusable(true); // キーイベントを取得できるようにする
		panel.addKeyListener(new KeyHandler()); // キーリスナの設定 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
	class KeyHandler implements KeyListener { // キーリスナの実装
		public void keyPressed(KeyEvent ke) {
			System.out.println("キーが押された");
		}
		public void keyTyped(KeyEvent ke){
			System.out.println("キーがタイプされた");
		}
		public void keyReleased(KeyEvent ke){
			System.out.println("キーが離された");
		}
	}
}