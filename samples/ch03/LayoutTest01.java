package ch03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTest01 extends JFrame {
	public static void main(String[] args) {
		new LayoutTest01("LayoutTest01");
	}
	public LayoutTest01(String title){ 
		super(title);

		JPanel pane = (JPanel)getContentPane(); // コンテントペインを得る

		JButton buttonNorth = new JButton("North"); // ボタン生成
		pane.add(buttonNorth, BorderLayout.NORTH); // 配置位置を指定して追加

		JButton buttonWest  = new JButton("West");
		pane.add(buttonWest, BorderLayout.WEST);

		JButton buttonCenter  = new JButton("Center");
		pane.add(buttonCenter, BorderLayout.CENTER);

		JButton buttonEast  = new JButton("East");
		pane.add(buttonEast, BorderLayout.EAST);

		JButton buttonSouth = new JButton("South");
		pane.add(buttonSouth, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}