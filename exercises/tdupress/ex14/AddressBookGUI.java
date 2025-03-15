package tdupress.ex14; // for tdupress

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddressBookGUI extends JFrame {
	JTextField nameField, addressField, telField, emailField; 
	DefaultListModel<Address> model;
	JList<Address> list;
	JButton addButton, removeButton, updateButton;
	JPanel pane;

	public static void main(String[] args){
		new AddressBookGUI("AddressBookGUI for tdupress");
	}

	public AddressBookGUI(String title){
		super(title);
		pane = (JPanel)getContentPane();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("ファイル");
		menuBar.add(fileMenu);
		JMenuItem item;
		item = new JMenuItem(new OpenAction());
		fileMenu.add(item);
		item = new JMenuItem(new SaveAction());
		fileMenu.add(item);
		fileMenu.addSeparator();
		item = new JMenuItem(new ExitAction());
		fileMenu.add(item);

		model = new DefaultListModel<Address>();
		list = new JList<Address>(model);
		list.setCellRenderer(new AddressCellRenderer());
		list.addListSelectionListener(new NameSelect());
		JScrollPane sc = new JScrollPane(list);
		sc.setBorder(new TitledBorder("名前一覧"));
		pane.add(sc, BorderLayout.CENTER);

		JPanel fields = new JPanel();
		fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
		nameField = new JTextField(20);
		nameField.setBorder(new TitledBorder("名前"));
		fields.add(nameField);
		addressField = new JTextField(20);
		addressField.setBorder(new TitledBorder("住所"));
		fields.add(addressField);
		telField = new JTextField(20);
		telField.setBorder(new TitledBorder("電話"));
		fields.add(telField);
		emailField = new JTextField(20);
		emailField.setBorder(new TitledBorder("メール"));
		fields.add(emailField);

		addButton = new JButton(new AddAction());
		fields.add(addButton);
		updateButton = new JButton(new UpdateAction());
		fields.add(updateButton);
		removeButton = new JButton(new RemoveAction());
		fields.add(removeButton); 

		pane.add(fields, BorderLayout.EAST);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				String msg = "終了しますか？";
				int ans = JOptionPane.showConfirmDialog(pane, msg);
				if (ans == 0) {
					System.exit(0);
				}
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	class AddressCellRenderer extends DefaultListCellRenderer { 
		@Override
		public Component getListCellRendererComponent( 
				JList<?> list, Object value, int index, 
				boolean isSelected, boolean cellHasFocus) {
			Address anAddress = (Address) value;
			String s = anAddress.getName(); // 名前を表示
			setText(s);
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			setOpaque(true);
			return this;
		}
	}

	class NameSelect implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent lse) {
			if (lse.getValueIsAdjusting() == false) {
				int index = list.getSelectedIndex();
				if (index < 0) { 
					return; 
				};
				Address selectedAddress = (Address) model.get(index);
				nameField.setText(selectedAddress.getName());
				addressField.setText(selectedAddress.getAddress());
				telField.setText(selectedAddress.getTel());
				emailField.setText(selectedAddress.getEmail());
			}
		}
	}

	class OpenAction extends AbstractAction {
		OpenAction() {
			putValue(NAME, "開く");
			putValue(SHORT_DESCRIPTION, "開く");
		}
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fileChooser = new JFileChooser("."); 
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			fileChooser.setDialogTitle("ファイル選択"); 

			int ret = fileChooser.showOpenDialog(pane); 

			if(ret != JFileChooser.APPROVE_OPTION) {
				return; 
			}
			String fileName = fileChooser.getSelectedFile().getAbsolutePath();
			try {
				model.clear();
				File file = new File(fileName);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while((line = reader.readLine()) != null) {
					String[] field = line.split(",");
					model.addElement(new Address(field[0], field[1], field[2], field[3]));
				}
				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	class SaveAction extends AbstractAction {
		SaveAction() {
			putValue(NAME, "保存");
			putValue(SHORT_DESCRIPTION, "保存");
		}
		public void actionPerformed(ActionEvent ae) {
			JFileChooser fileChooser = new JFileChooser("."); 
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			fileChooser.setDialogTitle("ファイル選択"); 

			int ret = fileChooser.showSaveDialog(pane); 

			if(ret != JFileChooser.APPROVE_OPTION) {
				return; 
			}    	    
			String fileName = fileChooser.getSelectedFile().getAbsolutePath();
			try {
				File file = new File(fileName);
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				for (int i=0; i<model.getSize(); i++) {
					Address anAddress = (Address)model.getElementAt(i);
					String name = anAddress.getName();
					String address = anAddress.getAddress();
					String tel = anAddress.getTel();
					String email = anAddress.getEmail();
					writer.println(name + "," + address + "," + tel + "," + email);
			} 
				writer.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	class ExitAction extends AbstractAction {
		ExitAction() {
			putValue(NAME, "終了");
			putValue(SHORT_DESCRIPTION, "終了");
		}
		public void actionPerformed(ActionEvent ae) {
			String msg = "終了しますか？";
			int ans = JOptionPane.showConfirmDialog(pane, msg);
			if (ans == 0) {
				System.exit(0);
			}
		}
	}

	class AddAction extends AbstractAction {
		AddAction() {
			putValue(NAME, "追加");
			putValue(SHORT_DESCRIPTION, "追加");
		}
		public void actionPerformed(ActionEvent ae) {
			String name, address, tel, email;
			name = nameField.getText();
			address = addressField.getText();
			tel = telField.getText();
			email = emailField.getText();
			if (name.length() == 0 || address.length() == 0 || tel.length() == 0 || email.length() == 0) {
				return;
			}
			model = (DefaultListModel<Address>)list.getModel();
			for (int i=0; i<model.getSize(); i++) {
				Address anAddress = (Address)model.getElementAt(i);    	
				if (anAddress.getName().equals(name)) {
					return;
				}
			}
			model.addElement(new Address(name, address, tel, email));
			nameField.setText("");
			addressField.setText("");
			telField.setText("");
			emailField.setText("");
		}
	}

	class UpdateAction extends AbstractAction {
		UpdateAction() {
			putValue(NAME, "更新");
			putValue(SHORT_DESCRIPTION, "更新");
		}
		public void actionPerformed(ActionEvent ae) {
			String name, address, tel, email;
			name = nameField.getText();
			address = addressField.getText();
			tel = telField.getText();
			email = emailField.getText();
			if (name.length() == 0 || address.length() == 0 || tel.length() == 0 || email.length() == 0) {
				return;
			}
			model = (DefaultListModel<Address>)list.getModel();
			for (int i=0; i<model.getSize(); i++) {
				Address anAddress = (Address)model.getElementAt(i);    	
				if (anAddress.getName().equals(name)) {
					anAddress.setAddress(address);
					anAddress.setTel(tel);
					anAddress.setEmail(email);
					return;
				}
			}
		}
	}

	class RemoveAction extends AbstractAction {
		RemoveAction() {
			putValue(NAME, "削除");
			putValue(SHORT_DESCRIPTION, "削除");
		}
		public void actionPerformed(ActionEvent ae) {
			int index = list.getSelectedIndex();
			if (index < 0) {
				return;
			} 
			model = (DefaultListModel<Address>)list.getModel();
			Address anAddress = (Address) model.getElementAt(index);
			String msg = anAddress.getName() + "を削除します。";
			int ans = JOptionPane.showConfirmDialog( pane, msg );
			if (ans == 0) {
				model.remove(index);
			}
		}
	}
}