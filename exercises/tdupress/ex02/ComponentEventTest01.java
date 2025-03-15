package tdupress.ex02; // for tdupress

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class ComponentEventTest01 extends JFrame {
	public static void main(String[] args) {
		new ComponentEventTest01("ComponentEventTest01 for tdupress");
	}

	public ComponentEventTest01(String title) {
		super( title );
		addComponentListener(new ComponentEventHandler()); 
		// コンポーネントリスナの設定 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	class ComponentEventHandler extends ComponentAdapter { 
		// コンポーネントリスナ
		@Override
		public void componentMoved(ComponentEvent ce){
			System.out.println("移動しました。");
			Point p = ce.getComponent().getLocation();
			System.out.println("新しい位置は"+ p.x +","+ p.y +"です。");
		}
		@Override
		public void componentResized(ComponentEvent ce){
			System.out.println("サイズが変更されました。");
			Dimension d = ce.getComponent().getSize();
			System.out.println("新しい大きさは"
				+ d.width + "," + d.height + "です。");
		}
	}
}