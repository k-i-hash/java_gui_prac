package ch06;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventTest03 extends JFrame {
	public static void main(String[] args) {
		new KeyEventTest03("KeyEventTest03");
	}
	public KeyEventTest03(String title) {
		super(title);
		JPanel panel = (JPanel)getContentPane();
		panel.setFocusable(true);
		panel.addKeyListener(new KeyHandler()); // キーリスナの設定 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}
	class KeyHandler extends KeyAdapter { // キーアダプタの継承
		@Override
		public void keyPressed(KeyEvent ke) {
			System.out.println("キーが押された");
			char keyChar = ke.getKeyChar();
			System.out.println("文字: "+ keyChar);

			int keyCode = ke.getKeyCode();
			String keyText = KeyEvent.getKeyText(keyCode);
			System.out.println("キーコード: "+ keyCode + " " 
				+ keyText);

			int modifier = ke.getModifiersEx();
			String modifierText 
				= InputEvent.getModifiersExText(modifier);
			System.out.println("モディファイア: "+ modifier + " " 
				+ modifierText);

			if(ke.isShiftDown()) {
				System.out.println("Shiftキーも併用された");
			}
			if(ke.isControlDown()) {
				System.out.println("Controlキーも併用された");
			}
			if(ke.isAltDown() ){
				System.out.println("Altキーも併用された");
			}
		}
	}
}
