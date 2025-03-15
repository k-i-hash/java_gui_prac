package ch07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MouseEventTest05 extends JFrame {
	private Point startPoint = new Point(-1, -1); // 線分の始点
	private Point endPoint = new Point(-1, -1); // 線分の終点
	private Point currentPoint = new Point(-1, -1); // 現在の点
	private Point previousPoint = new Point(-1, -1); // 一つ前の点
	private JPanel pane;

	public static void main(String[] args) {
		new MouseEventTest05("MouseEventTest05");
	}
	public MouseEventTest05(String title) {
		super(title);
		pane = (JPanel) getContentPane();
		pane.addMouseListener(new MouseHandler()); // リスナを設定
		pane.addMouseMotionListener(new MouseHandler()); // リスナを設定
		pane.setBackground(Color.white); // 背景を白に
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler extends MouseInputAdapter {
		@Override
 		public void mousePressed(MouseEvent me) {
			startPoint = me.getPoint(); // 始点の設定
			previousPoint = startPoint; // 最初は一つ前の点も同じに
		}
		@Override
		public void mouseReleased(MouseEvent me) {
			endPoint = me.getPoint(); // 終点の設定
			Graphics g = pane.getGraphics(); 
			g.drawLine(startPoint.x, startPoint.y, endPoint.x, 
				endPoint.y); // 確定の直線を描く
		}
		@Override
		public void mouseDragged(MouseEvent me) {
			currentPoint = me.getPoint();
			Graphics g = pane.getGraphics(); 
			g.setXORMode(Color.yellow); // XORモードで描画する
			g.drawLine(startPoint.x, startPoint.y, 
				previousPoint.x, previousPoint.y); 
				// 以前に描いた直線が消える
			g.drawLine(startPoint.x, startPoint.y, 
				currentPoint.x, currentPoint.y); 
				// 新しく直線を描く
			previousPoint = currentPoint; // 現在の点を一つ前の点に設定
		} 
	}
}