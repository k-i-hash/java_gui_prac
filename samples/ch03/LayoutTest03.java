package ch03;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTest03 extends JFrame {
	public static void main(String[] args) {
		new LayoutTest03("LayoutTest03");
	}
	public LayoutTest03(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new GridLayout(4, 3)); // レイアウト方法を指定

		for(int i=0; i<12; i++) {
			pane.add(new JButton(Integer.toString(i))); 
			// ボタン生成と追加
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}