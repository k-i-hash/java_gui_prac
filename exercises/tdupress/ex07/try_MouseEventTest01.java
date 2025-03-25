package ch07;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class try_MouseEventTest01 extends JFrame {
	public static void main(String[] args) {
		new try_MouseEventTest01("MouseEventTest01");
	}
	public try_MouseEventTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.addMouseListener(new MouseHandler());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	class MouseHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent me) {
			System.out.println("Mouse is clicked!");
		}
	}
}
