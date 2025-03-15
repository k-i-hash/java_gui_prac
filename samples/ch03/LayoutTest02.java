package ch03;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTest02 extends JFrame {
	public static void main(String[] args) {
		new LayoutTest02("LayoutTest02");
	}
	public LayoutTest02(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new FlowLayout()); // レイアウトを指定

		for(int i=0; i<12; i++) {
			pane.add(new JButton(Integer.toString(i))); 
			// ボタンの生成と追加
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}