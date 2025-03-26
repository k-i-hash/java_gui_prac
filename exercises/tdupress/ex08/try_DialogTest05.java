package tdupress.ex08;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import javax.swing.JOptionPane;

import javax.swing.Action;
import javax.swing.AbstractAction;

public class try_DialogTest05 extends JFrame {
	private JPanel pane;

	public static void main(String[] args) {
		new try_DialogTest05("DialogTest05");
	}
	public try_DialogTest05(String title) {
		super(title);

		pane = (JPanel)getContentPane();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu dialogMenu = new JMenu("Confirm Dialog");
		menuBar.add(dialogMenu);

		dialogMenu.add(new OpenDialog());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 360);
		setVisible(true);
	}
	private void confirmDialog() {
		String title = "Java Question";
		String msg = "Do you like Java language?";
		int ans = JOptionPane.showConfirmDialog(pane, msg, title, JOptionPane.YES_NO_OPTION);
		confirmDialogAnswer(ans);	
	}
	private void confirmDialogAnswer(int ans) {
		String title = "Java Answer";
		String msg = (ans == 0) ? "You like Java." : "You don't like Java.";
		int ansOutput = JOptionPane.showConfirmDialog(pane, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	class OpenDialog extends AbstractAction {
		OpenDialog() {
			putValue(Action.NAME, "Open");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			confirmDialog();
		}
	}
}
