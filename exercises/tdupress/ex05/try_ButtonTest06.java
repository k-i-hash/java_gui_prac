package tdupress.ex05; // for tdupress

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class try_ButtonTest06 extends JFrame {
	private int count = 0;

	public static void main(String[] args) {
		new try_ButtonTest06("ButtonTest06");	
	}
	public try_ButtonTest06(String title) {
		super(title);
		
		JPanel pane = (JPanel)getContentPane();

		JButton countUpButton = new JButton(new CountUpAction());
		pane.add(countUpButton, BorderLayout.NORTH);

		JButton countDownButton = new JButton(new CountDownAction());
		pane.add(countDownButton, BorderLayout.SOUTH);

		JButton countClearButton = new JButton(new CountClearAction());
		pane.add(countClearButton, BorderLayout.CENTER);

		// add menubar.
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu operationMenu = new JMenu("Operation");
		menuBar.add(operationMenu);

		JMenuItem menuItem;
		
		menuItem = new JMenuItem(new CountUpAction());
		operationMenu.add(menuItem);

		menuItem = new JMenuItem(new CountDownAction());
		operationMenu.add(menuItem);

		operationMenu.addSeparator();

		menuItem = new JMenuItem(new CountClearAction());
		operationMenu.add(menuItem);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}

	class CountUpAction extends AbstractAction {
		CountUpAction() {
			putValue(Action.NAME, "UP");
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			count += 1;
			System.out.println("Now count: " + count);
		}
	}
	class CountDownAction extends AbstractAction {
		CountDownAction() {
			putValue(Action.NAME, "DOWN");
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			count -= 1;
			System.out.println("Now count: " + count);
		}
	}
	class CountClearAction extends AbstractAction {
		CountClearAction() {
			putValue(Action.NAME, "CLEAR");
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			count = 0;
			System.out.println("Count is cleared. Now count: " + count);
		}
	}
}
