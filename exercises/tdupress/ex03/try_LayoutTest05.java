package ex03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class try_LayoutTest05 extends JFrame {
	public static void main(String[] args) {
		new try_LayoutTest05("LayoutTest05");
	}
	public try_LayoutTest05(String title){ 
		super(title);

		JPanel pane = (JPanel)getContentPane(); // コンテントペインを得る

		JButton buttonNorth = new JButton("North"); // ボタン生成
		pane.add(buttonNorth, BorderLayout.NORTH); // 配置位置を指定して追加

		JButton buttonWest  = new JButton("West");
		pane.add(buttonWest, BorderLayout.WEST);

		// JButton buttonCenter  = new JButton("Center");
		// pane.add(buttonCenter, BorderLayout.CENTER);

		JButton buttonEast  = new JButton("East");
		pane.add(buttonEast, BorderLayout.EAST);

		JButton buttonSouth = new JButton("South");
		pane.add(buttonSouth, BorderLayout.SOUTH);

		JPanel panelCenter = new JPanel();
		pane.add(panelCenter, BorderLayout.CENTER);

		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(new JButton("north"), BorderLayout.NORTH);
		panelCenter.add(new JButton("west"), BorderLayout.WEST);
		panelCenter.add(new JButton("center"), BorderLayout.CENTER);
		panelCenter.add(new JButton("east"), BorderLayout.EAST);
		panelCenter.add(new JButton("south"), BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}
