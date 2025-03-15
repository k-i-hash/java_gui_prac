package ch02;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowEventTest03 extends JFrame {
	public static void main(String[] args) {
		new WindowEventTest03("WindowEventTest03"); 
	}
	public WindowEventTest03(String title){ 
		super( title );
		addWindowListener( new WindowAdapter() { // 無名内部クラス
			public void windowClosing(WindowEvent we) {
				System.out.println("ウインドウが閉じつつある");
			}
		} ); // リスナの設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
}