package ch08;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogTest01 extends JFrame {
	JPanel pane;
	public static void main(String[] args) {
		new DialogTest01("DialogTest01");
	}
	public DialogTest01(String title) {  
		super(title);
		pane = (JPanel)getContentPane();
		pane.add(new JButton(new OpenDialog()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}
	class OpenDialog extends AbstractAction {
		OpenDialog(){
			putValue(NAME, "ダイアログを開く");
		}
		@Override
		public void actionPerformed(ActionEvent ae) { 
		// このメソッド内がポイント
			String msg = "このメッセージが表示されます。"; 
			int ans = JOptionPane.showConfirmDialog(pane, msg); 
			// ダイアログの表示
			System.out.println("回答: " + ans);
		}
	}
}