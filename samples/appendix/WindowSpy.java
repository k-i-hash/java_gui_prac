package appendix;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class WindowSpy extends JFrame {
	JTextField tf;
	JButton b;
	JTree tree;
	JFrame target;
	DefaultMutableTreeNode root;
	public static void main(String[] args) {
		new WindowSpy("WindowSpy");
	}
	public WindowSpy(String title) {
		super(title);
		JPanel pane = (JPanel)getContentPane();
		tf = new JTextField();
		tf.setBorder(new TitledBorder("パッケージ名.クラス名"));
		b = new JButton("開く");
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(tf);
		box.add(b);
		pane.add(box, BorderLayout.NORTH);
		b.addActionListener(new ActionHandler());
		tree = new JTree();
		JScrollPane sp = new JScrollPane(tree);
		pane.add(sp, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}
	private void addComponentName(Component c, 
		DefaultMutableTreeNode parent) {
			String name = c.toString();
			DefaultMutableTreeNode current 
				= new DefaultMutableTreeNode(name);
			parent.add(current);
			if (c instanceof Container) { 
			// コンテナはコンポーネントを持つことができる
				Container cont = (Container)c;
				Component[] components = cont.getComponents();
				if (c instanceof JMenu) { // メニューもたどりたい
					JMenu menu = (JMenu)c;
					components = menu.getMenuComponents();
				}
				for (Component comp : components) { 
				// 子コンポーネントを再帰的にたどる
					addComponentName(comp, current);	
				}
		} 
		return;
	}
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String targetName = tf.getText();
			try { // クラス名からインスタンスを生成
				target = (JFrame)Class.forName(targetName).
					getConstructor(String.class).
					newInstance("WindowSpy");
			} catch (ClassNotFoundException e) {
				System.out.println(targetName + "が見つかりません。");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!target.isVisible()) { // ウィンドウが可視化されていなければ
				target.setVisible(true); // 可視化する
			}
			root = new DefaultMutableTreeNode(targetName);
			addComponentName(target, root);
			tree.setModel(new DefaultTreeModel(root));
			for (int row=0; row < tree.getRowCount(); row++) { 
			// ノードを展開表示
				tree.expandRow(row);
			}
		}
	}
}