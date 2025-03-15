package ch03;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTest04 extends JFrame {
	public static void main(String[] args) {
		new LayoutTest04("LayoutTest04");
	}
	public LayoutTest04(String title){
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS)); 
		// レイアウト方法
		// pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); 

		for(int i=0; i<12; i++) {
			JButton bt = new JButton(Integer.toString(i)); 
			// ボタンの生成
			pane.add(bt); // ボタンの追加 
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}