package ch03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTest01 extends JFrame {
	public static void main(String[] args) {
		new MenuTest01("MenuTest01");
	}
	public MenuTest01(String title){
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}