package ch12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ComboBoxTest05 extends JFrame {
	JPanel pane;
	public static void main(String[] args) {
		new ComboBoxTest05("ComboBoxTest05");
	}
	public ComboBoxTest05(String title) {  
		super(title);
		pane = (JPanel)getContentPane();
		JComboBox<Colors> combo 
			= new JComboBox<Colors>(Colors.values()); 
		combo.addItemListener(new ItemHandler());
		combo.setRenderer(new ColorCellRenderer());
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
		PINK(Color.PINK), RED(Color.RED), WHITE(Color.WHITE), 
		YELLOW(Color.YELLOW);
		Color color;
		Icon icon;
		private Colors(Color color) {
			this.color = color;
			icon = new ColorIcon(color);
		}
		class ColorIcon implements Icon { // 独自のアイコンクラス
			static final int WIDTH  = 50;
			static final int HEIGHT = 20;
			private Color color;
			public ColorIcon(Color color) {
				this.color = color;
			}
			public void paintIcon(Component c, Graphics g, int x, 
				int y) {
					g.setColor(color); // 色の設定
					g.fillRect(x, y, WIDTH, HEIGHT); 
					// 塗りつぶしの矩形を描画
			}
			public int getIconWidth() { 
				return WIDTH;
			}
			public int getIconHeight() {
				return HEIGHT;
			}
		}
	}
	class ColorCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, 
			Object value, int index, boolean isSelected, 
			boolean cellHasFocus) {
				Colors colors = (Colors)value;
				if(isSelected) {
					setOpaque(true); 
					setBackground(list.getSelectionBackground());
				} else {
					setOpaque(false); 
				}
				setText(colors.toString()); // 文字列を設定
				setIcon(colors.icon); // アイコンを設定
				return this;
		}
	}
}