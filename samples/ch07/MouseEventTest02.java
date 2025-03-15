package ch07;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest02 extends JFrame {
	public static void main(String[] args) {
		new MouseEventTest02("MouseEventTest02");
	}
	public MouseEventTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.addMouseListener(new MouseHandler());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler extends MouseAdapter { 
		@Override
		public void mouseClicked(MouseEvent me) {
			System.out.println("マウスがクリックされた");
			System.out.println("x座標は" + me.getX() + " y座標は" 
				+ me.getY());
			System.out.println("点は" + me.getPoint());
			System.out.println("スクリーン上のx座標は" 
				+ me.getXOnScreen());
			System.out.println("スクリーン上のy座標は" 
				+ me.getYOnScreen());
		}
	}
}