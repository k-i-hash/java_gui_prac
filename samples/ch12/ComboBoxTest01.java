package ch12;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxTest01 extends JFrame {
	public static void main(String[] args) {
		new ComboBoxTest01("ComboBoxTest01");
	}
	public ComboBoxTest01(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		String[] items = {"	BLACK", "BLUE", "CYAN", "DARK_GRAY", 
			"GRAY",	"GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", 
			"PINK", "RED", "WHITE", "YELLOW"}; // 配列で項目を用意
		JComboBox<String> combo = new JComboBox<String>(items); 
		// 配列をとるコンストラクタ
		pane.add(combo, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
}