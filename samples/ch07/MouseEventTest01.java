package ch07;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest01 extends JFrame {
	public static void main(String[] args) {
		new MouseEventTest01("MouseEventTest01");
	}
	public MouseEventTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.addMouseListener(new MouseHandler()); // リスナを登録
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler implements MouseListener { // リスナの定義
		public void mousePressed(MouseEvent me) { 
			System.out.println("マウスボタンが押された");
		}
		public void mouseReleased(MouseEvent me) {
			System.out.println("マウスボタンが離された");
		}
		public void mouseClicked(MouseEvent me) {
			System.out.println("マウスがクリックされた");
		}
		public void mouseEntered(MouseEvent me) {
			System.out.println("カーソルが入ってきた");
		}
		public void mouseExited(MouseEvent me) {
		System.out.println("カーソルが出ていった");
		}
	}
}