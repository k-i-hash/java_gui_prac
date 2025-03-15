package ch05;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxTest02 extends JFrame {
	public static void main(String[] args) {
		new CheckBoxTest02("CheckBoxTest02");
	}
	public CheckBoxTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		JCheckBox button = new JCheckBox(new AppleAction());
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox(new OrangeAction());
		pane.add(button); // コンテントペインに追加
		button = new JCheckBox(new StrawberryAction());
		pane.add(button); // コンテントペインに追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 150);
		setVisible(true);
	}
	class AppleAction extends AbstractAction {
		AppleAction() {
			putValue(Action.NAME, "りんご");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JCheckBox cb = (JCheckBox)ae.getSource(); 
			// イベントソースを得る
			if (cb.isSelected()) { // 選択か解除かのチェック
				System.out.println((String)getValue(Action.NAME) 
					+" が選択された");
			} else {
				System.out.println((String)getValue(Action.NAME) 
					+" が選択解除された");
			}
		}
	}
	class OrangeAction extends AbstractAction {
		OrangeAction() {
			putValue(Action.NAME, "みかん");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JCheckBox cb = (JCheckBox)ae.getSource(); 
			// イベントソースを得る
			if (cb.isSelected()) {
				System.out.println((String)getValue(Action.NAME) 
					+" が選択された");
			} else {
				System.out.println((String)getValue(Action.NAME) 
					+" が選択解除された");
			}
		}
	}
	class StrawberryAction extends AbstractAction {
		StrawberryAction() {
			putValue(Action.NAME, "いちご");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			JCheckBox cb = (JCheckBox)ae.getSource(); 
			// イベントソースを得る
			if (cb.isSelected()) {
				System.out.println((String)getValue(Action.NAME) 
					+" が選択された");
			} else {
				System.out.println((String)getValue(Action.NAME) 
					+" が選択解除された");
			}
		}
	}
}