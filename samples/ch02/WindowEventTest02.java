package ch02;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowEventTest02 extends JFrame {
	public static void main(String[] args) {
		new WindowEventTest02("WindowEventTest02"); 
	}
	public WindowEventTest02( String title ){ 
		super(title);
		addWindowListener(new WindowEventHandler()); // リスナの設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
	class WindowEventHandler extends WindowAdapter { // アダプタを継承
		@Override
		public void windowClosing(WindowEvent we) {
			System.out.println("ウインドウが閉じつつある");
		}
	}
}