package tdupress.ex07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class try_MouseEventTest06 extends JFrame {
	private JPanel pane;

	public static void main(String[] args) {
		new try_MouseEventTest06("MouseEventTest06");
	}
	public try_MouseEventTest06(String title) {
		super(title);
		
		pane = (JPanel)getContentPane();
		pane.addMouseMotionListener(new MouseHandler());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	class MouseHandler extends MouseInputAdapter {
		@Override
		public void mouseDragged(MouseEvent me) {
			Graphics g = pane.getGraphics();
			int x = me.getX();
			int y = me.getY();
			g.setColor(Color.red);
			g.fillOval(x, y, 10, 10);
		}
	}
}
