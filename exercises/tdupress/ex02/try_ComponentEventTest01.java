package tdupress.ex02;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

public class try_ComponentEventTest01 extends JFrame {
	public static void main(String[] args) {
		new try_ComponentEventTest01("ComponentEventTest01");
	}
	public try_ComponentEventTest01(String title) {
		super(title);
		addComponentListener(new ComponentHandler());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
	class ComponentHandler extends ComponentAdapter {
		@Override
		public void componentMoved(ComponentEvent e) {
			System.out.println("移動しました。");
		}
		@Override
		public void componentResized(ComponentEvent e) {
			System.out.println("サイズが変更されました。");
		}
	}
}
