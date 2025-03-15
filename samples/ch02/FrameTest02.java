package ch02;

import javax.swing.JFrame;

public class FrameTest02 extends JFrame { // JFrame を継承したクラスとして定義
	public static void main(String[] args) {
		new FrameTest02("FrameTest02"); // インスタンスを生成
	}
	public FrameTest02(String title) { // コンストラクタ
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
}