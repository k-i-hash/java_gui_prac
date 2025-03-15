package tdupress.ex07; // for tdupress

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MouseEventTest06 extends JFrame {
	private JPanel pane;
	public static void main(String[] args) {
		new MouseEventTest06("MouseEventTest06 for tdupress");
	}
	public MouseEventTest06(String title) {
		super(title);
		pane = (JPanel)getContentPane();
		pane.addMouseMotionListener(new MouseHandler()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler extends MouseInputAdapter { // リスナの実装
		@Override
		public void mouseDragged(MouseEvent me) { 
		// マウスをドラッグした位置に描画
			Graphics g = pane.getGraphics(); // グラフィックスコンテキストを得る
			int x = me.getX();
			int y = me.getY();
			g.setColor(Color.RED);
			g.fillOval(x, y, 10, 10); // 円を描く
		}
	}
}