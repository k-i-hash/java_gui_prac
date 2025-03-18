package ex03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class try_MenuTest02 extends JFrame {
	public static void main(String[] args) {
		new try_MenuTest02("MenuTest02");
	}
	public try_MenuTest02(String title){
		super(title);

		JMenuBar menuBar = new JMenuBar(); // メニューバーの生成
		setJMenuBar(menuBar); // メニューバーの設定

		JMenu fileMenu = new JMenu("File"); // メニューの生成
		menuBar.add(fileMenu); // メニューバーにメニューを追加

		JMenuItem menuItem;    
		menuItem = new JMenuItem("Open"); // メニュー項目の生成
		fileMenu.add(menuItem); // メニューにメニュー項目を追加
		menuItem = new JMenuItem("Save"); // メニュー項目の生成
		fileMenu.add(menuItem); // メニューにメニュー項目を追加
		fileMenu.addSeparator(); // メニューにセパレータを追加
		menuItem = new JMenuItem("Exit"); // メニュー項目の生成
		fileMenu.add(menuItem); // メニューにメニュー項目を追加
		
		// Editメニューの追加
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);

		menuItem = new JMenuItem("Copy");
		editMenu.add(menuItem);
		menuItem = new JMenuItem("Cut");
		editMenu.add(menuItem);
		menuItem = new JMenuItem("Paste");
		editMenu.add(menuItem);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}
