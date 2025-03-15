package tdupress.ex03; // for tdupress

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutTest05 extends JFrame {
	public static void main(String[] args) {
		new LayoutTest05("LayoutTest05 for tdupress");
	}
	public LayoutTest05(String title) {
		super( title );

		JPanel pane = (JPanel)getContentPane();

		JButton buttonNorth = new JButton("North");
		pane.add( buttonNorth, BorderLayout.NORTH );

		JButton buttonSouth = new JButton("South");
		pane.add( buttonSouth, BorderLayout.SOUTH );

		JButton buttonWest  = new JButton("West");
		pane.add( buttonWest, BorderLayout.WEST );

		JButton buttonEast  = new JButton("East");
		pane.add( buttonEast, BorderLayout.EAST );

		JPanel panelCenter  = new JPanel(); // 中央のパネル
		pane.add(panelCenter, BorderLayout.CENTER); 
	    
		panelCenter.setLayout(new BorderLayout()); // レイアウト変更
		panelCenter.add (new JButton("north"), BorderLayout.NORTH);
		panelCenter.add (new JButton("south"), BorderLayout.SOUTH);
		panelCenter.add (new JButton("center"), BorderLayout.CENTER);
		panelCenter.add (new JButton("west"), BorderLayout.WEST);
		panelCenter.add (new JButton("east"), BorderLayout.EAST);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
}