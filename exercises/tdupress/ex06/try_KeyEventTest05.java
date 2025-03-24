
package tdupress.ex06; // for tdupress

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class try_KeyEventTest05 extends JFrame {
	private char keyChar;
	private JPanel pane, outputPanel;
	public static void main(String[] args) {
		new try_KeyEventTest05("KeyEventTest05");
	}
	public try_KeyEventTest05(String title) {
		super(title);

		pane = (JPanel)getContentPane();
		outputPanel = new OutputPanel();
		outputPanel.setFocusable(true);
		outputPanel.addKeyListener(new KeyHandler());

		pane.add(outputPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	class OutputPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			int x = pane.getWidth() / 2;
			int y = pane.getHeight() / 2;
			g.drawString(String.valueOf(keyChar), x, y);
		}
	}
	class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent ke) {
			keyChar = ke.getKeyChar();
			outputPanel.repaint();
		}
	}
}
