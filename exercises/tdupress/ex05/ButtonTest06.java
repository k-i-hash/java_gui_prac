package tdupress.ex05; // for tdupress

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class ButtonTest06 extends JFrame {
	private int count = 0;
	public static void main(String[] args) {
		new ButtonTest06("ButtonTest06 for tdupress");
	}
	public ButtonTest06(String title) {
		super( title );
		JPanel pane = (JPanel)getContentPane();

		JButton plusButton = new JButton(new PlusAction());
		pane.add(plusButton, BorderLayout.NORTH);
		JButton minusButton = new JButton(new MinusAction());
		pane.add(minusButton, BorderLayout.SOUTH);
		JButton clearButton = new JButton( new ClearAction());
		pane.add(clearButton, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("操作");
		menuBar.add(menu);
		menu.add(new PlusAction());
		menu.add(new MinusAction());
		menu.addSeparator();
		menu.add(new ClearAction());    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
		System.out.println("初期値は" + count);
	}
	class PlusAction extends AbstractAction {
		PlusAction() {
			putValue(NAME, "増やす");
			putValue(SHORT_DESCRIPTION, "インクリメント");
		}
		@Override
		public void actionPerformed(ActionEvent ae){
			count++;
			System.out.println("現在値は" + count);
		}
	}
	class MinusAction extends AbstractAction {
		MinusAction() {
			putValue(NAME, "減らす");
			putValue(SHORT_DESCRIPTION, "デクリメント");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			count--;
			System.out.println("現在値は" + count);
		}
	}
	class ClearAction extends AbstractAction {
		ClearAction() {
			putValue(NAME, "クリア");
			putValue(SHORT_DESCRIPTION, "クリア");
		}
		@Override
		public void actionPerformed(ActionEvent ae){
			count = 0;
			System.out.println("現在値は" + count);
		}
	}
}