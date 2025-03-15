package ch02; // これ以降、ch + 章番号 の名前を使う

import javax.swing.JFrame;	// Swing の JFrame を使用

public class FrameTest01 {
public static void main(String[] args) {	
	JFrame frame = new JFrame("FrameTest01"); 
	// JFrameクラスのインスタンスを生成
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	// ウィンドウを閉じる設定
	frame.setSize(640, 480); // サイズを設定
	frame.setVisible(true); // 画面上に見えるように設定
	// プログラムは終了せずにイベントループに入る
	}
}