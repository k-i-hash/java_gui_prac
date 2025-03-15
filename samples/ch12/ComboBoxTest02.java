package ch12;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxTest02 extends JFrame {
	public static void main(String[] args) {
		new ComboBoxTest02("ComboBoxTest02");
	}
	public ComboBoxTest02(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		String[] items = {"	BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", 
			"GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", 
			"RED", "WHITE", "YELLOW"}; // 配列で項目を用意
		JComboBox<String> combo = new JComboBox<String>(items); 
		// 配列をとるコンストラクタ
		combo.addItemListener(new ItemHandler()); // リスナの設定
		pane.add(combo, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
	class ItemHandler implements ItemListener {
		public void itemStateChanged(ItemEvent ie) {
			System.out.print(ie.getItem());
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("が選択されました。");
			} else {
				System.out.println("が選択解除されました。");
			}
		}
	}
}