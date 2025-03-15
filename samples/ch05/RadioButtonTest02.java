package ch05;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest02 extends JFrame {
	public static void main(String[] args) {
		new RadioButtonTest02("RadioButtonTest02");
	}
	public RadioButtonTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		ButtonGroup buttonGroup = new ButtonGroup(); 
		JRadioButton button = new JRadioButton(new AppleAction());
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton(new OrangeAction());
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		button = new JRadioButton(new StrawberryAction());
		pane.add(button); // コンテントペインに追加
		buttonGroup.add(button); // ボタングループにも追加
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 200, 150 );
		setVisible( true );
	}
	class AppleAction extends AbstractAction {
		AppleAction() {
			putValue(Action.NAME, "りんご");
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println((String)getValue(Action.NAME) 
				+" が選択された");
		}
	}
	class OrangeAction extends AbstractAction {
		OrangeAction() {
			putValue(Action.NAME, "みかん");
		}
		@Override
		public void actionPerformed(ActionEvent ae){
			System.out.println((String)getValue(Action.NAME) 
				+" が選択された");
		}
	}
	class StrawberryAction extends AbstractAction {
		StrawberryAction() {
			putValue(Action.NAME, "いちご");
		}
		@Override
		public void actionPerformed(ActionEvent ae){
			System.out.println((String)getValue(Action.NAME) 
				+" が選択された");
		}
	}
}