package ch07;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MouseEventTest04 extends JFrame {
	private int x0 = 0, y0 = 0; // 始点の宣言と初期化
	private JPanel pane;
	public static void main(String[] args) {
		new MouseEventTest04("MouseEventTest04");
	}
	public MouseEventTest04(String title) {
		super(title);
		pane = (JPanel)getContentPane();
		pane.addMouseListener(new MouseHandler()); 
		pane.addMouseMotionListener(new MouseHandler()); 
		// 両方に同じリスナを設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler extends MouseInputAdapter { // リスナの実装
		@Override	
		public void mousePressed(MouseEvent me) { 
		// マウスを押した位置が始点
			x0 = me.getX();
			y0 = me.getY();
		}
		@Override
		public void mouseDragged(MouseEvent me) { 
		// マウスをドラッグした位置が終点
			Graphics g = pane.getGraphics(); // グラフィックスコンテキストを得る
			int x = me.getX();
			int y = me.getY();
			g.drawLine(x0, y0, x, y); // 線分を引く
			x0 = x; // 現在の終点を次の始点にする
			y0 = y;
		}
	}
}