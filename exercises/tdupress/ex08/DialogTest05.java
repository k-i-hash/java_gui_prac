package tdupress.ex08; // for tdupress

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class DialogTest05 extends JFrame {
	JPanel pane;
	public static void main(String[] args) {
		new DialogTest05("DialogTest05 for tdupress");
	}
	public DialogTest05(String title) {  
		super( title );
		pane = (JPanel)getContentPane();
		JToolBar tool = new JToolBar();
		pane.add( tool, BorderLayout.NORTH );
		tool.add( new DialogC("Confirm Dialog"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 550, 300 );
		setVisible( true );
	}
	class DialogC extends AbstractAction {
		DialogC(String text){
			super(text);
		}
		public void actionPerformed(ActionEvent e){
			String msg = "Java は好きですか?";
			int ans = JOptionPane.showConfirmDialog(pane, msg, 
				"Java Question", JOptionPane.YES_NO_OPTION);
			if (ans == 0) {
				msg = "Java は好きです";
			} else {
				msg = "Java は好きではありません";
			}
			JOptionPane.showMessageDialog(pane, msg, "Java Answer", 
				JOptionPane.WARNING_MESSAGE);
		}
	}
}