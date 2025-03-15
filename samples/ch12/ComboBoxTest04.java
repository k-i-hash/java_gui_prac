package ch12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboBoxTest04 extends JFrame {
	JComboBox<String> combo;
	public static void main(String[] args) {
		new ComboBoxTest04("ComboBoxTest04");
	}
	public ComboBoxTest04(String title) {  
		super(title);
		JPanel pane = (JPanel)getContentPane();
		combo = new JComboBox<String>(); // 配列をとるコンストラクタ
		combo.addItemListener(new ListHandler());
		combo.setEditable(true);
		ComboBoxEditor editor = combo.getEditor();
		editor.addActionListener(new EditorHandler());
		pane.add(combo, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100,200);
		setVisible(true);
	}
	class EditorHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JTextField tf = (JTextField)ae.getSource();
			String item = tf.getText();
			combo.addItem(item); // 末尾に追加
			combo.setSelectedItem(item); // 選択状態に
			System.out.println(item + "が追加されました。");
		}
	}
	class ListHandler implements ItemListener {
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