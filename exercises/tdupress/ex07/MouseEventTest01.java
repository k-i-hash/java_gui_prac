package tdupress.ex07; // for tdupress

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest01 extends JFrame {
	public static void main(String[] args) {
		new MouseEventTest01("MouseEventTest01 for tdupress");
	}
	public MouseEventTest01(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		pane.addMouseListener(new MouseHandler()); // リスナを登録
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	class MouseHandler extends MouseAdapter { // リスナの定義
		@Override
		public void mouseClicked(MouseEvent me) {
			System.out.println("マウスがクリックされた");
		}
	}
}