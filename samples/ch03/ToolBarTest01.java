package ch03;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBarTest01 extends JFrame {
	public static void main(String[] args) {
		new ToolBarTest01("ToolBarTest01");
	}
	public ToolBarTest01(String title){
		super(title);

		JPanel pane = (JPanel)getContentPane();

		JToolBar toolbar = new JToolBar(); // ツールバーの生成
		pane.add(toolbar, BorderLayout.NORTH); 
		// コンテントペインの上部に追加

		toolbar.add(new JButton("Open")); 
		// ツールバーにコンポーネントを追加
		toolbar.add(new JButton("Save"));
		toolbar.addSeparator();
		toolbar.add(new JButton("Exit"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}