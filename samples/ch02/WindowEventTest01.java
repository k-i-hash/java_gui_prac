package ch02;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventTest01 extends JFrame {
	public static void main(String[] args) {
		new WindowEventTest01("WindowEventTest01"); 
	}
	public WindowEventTest01(String title){ 
		super(title);
		addWindowListener(new WindowEventHandler()); // リスナの設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
	class WindowEventHandler implements WindowListener { // インタフェースの実装
		// 内部クラスとしてリスナを実装
		public void windowOpened(WindowEvent we) {
			System.out.println("ウインドウが開いた");
		}
		public void windowClosing(WindowEvent we) {
			System.out.println("ウインドウが閉じつつある");
		}
		public void windowClosed(WindowEvent we) {
			System.out.println("ウインドウが閉じた");
		}
		public void windowIconified(WindowEvent we) {
			System.out.println("ウインドウがアイコン化された");
		}
		public void windowDeiconified(WindowEvent we) {
			System.out.println("ウインドウが非アイコン化された");
		}
		public void windowActivated(WindowEvent we) {
			System.out.println("ウインドウが活性化した");
		}
		public void windowDeactivated(WindowEvent we) {
			System.out.println("ウインドウが非活性化した");
		}
	}
}