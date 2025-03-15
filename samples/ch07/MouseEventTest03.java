package ch07;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest03 extends JFrame {
	public static void main(String[] args) {
		new MouseEventTest03("MouseEventTest03");
	}
	public MouseEventTest03(String title){
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.addMouseMotionListener(new MouseMotionHandler()); 
		// リスナの設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseMotionHandler implements MouseMotionListener { 
		public void mouseMoved(MouseEvent me) { // マウスの移動
			int x = me.getX();
			int y = me.getY();
			System.out.println("マウスが動いた x=" + x + " y=" + y);
		}
		public void mouseDragged(MouseEvent me) { // マウスのドラッグ
			int x = me.getX();
			int y = me.getY();
			System.out.println("マウスがドラッグされた x=" 
				+ x + " y=" + y);
		}
	}
}