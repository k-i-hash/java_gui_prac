package ch12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxTest03 extends JFrame {
	JPanel pane;
	public static void main(String[] args) {
		new ComboBoxTest03("ComboBoxTest03");
	}
	public ComboBoxTest03(String title) {  
		super(title);
		pane = (JPanel)getContentPane();
		JComboBox<Colors> combo 
			= new JComboBox<Colors>(Colors.values()); 
		combo.addItemListener(new ItemHandler());
		pane.add(combo, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	class ItemHandler implements ItemListener {
		public void itemStateChanged(ItemEvent ie) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				Colors selectedColor = (Colors)ie.getItem();
				pane.setBackground(selectedColor.color);
			} 
		}
	}
	enum Colors {
		BLACK(Color.BLACK), BLUE(Color.BLUE), CYAN(Color.CYAN), 
		DARK_GRAY(Color.DARK_GRAY), GRAY(Color.GRAY), 
		GREEN(Color.GREEN), LIGHT_GRAY(Color.LIGHT_GRAY), 
		MAGENTA(Color.MAGENTA), ORANGE(Color.ORANGE), 
		PINK(Color.PINK), 	RED(Color.RED), WHITE(Color.WHITE), 
		YELLOW(Color.YELLOW);
		Color color;
		private Colors(Color color) {
			this.color = color;
		}
	}
}