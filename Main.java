import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Main {

public void DisplayInTable(String OrderQuery) {
		table.setModel(model);
	}

	public void executeSQLQuery(String sql, String message) {
		Connection conn = getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			if((st.executeUpdate(sql)) == 1) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
			}else {
				JOptionPane.showMessageDialog(null, "Data not"+message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
public Main() {
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("First name:");
		lblUserName.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 18));
		lblUserName.setBounds(26, 201, 110, 38);
private void initialize() {

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
                textField_id.setText(model.getValueAt(i,0).toString());
                textField_firstname.setText(model.getValueAt(i,1).toString());
                textField_lastname.setText(model.getValueAt(i,2).toString());
                textField_group.setText(model.getValueAt(i,3).toString());
			}
		});
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
private void initialize() {
				"First Name", "Last Name", "Group", "Result"
			}
		));

		JButton btnAddUser = new JButton("ADD user");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO users(firstname, lastname, groupid) VALUES ('"+textField_firstname.getText()+"','"+textField_lastname.getText()+"','"+textField_group.getText()+"')";
				executeSQLQuery(sql, "Inserted");
			}
		});
		btnAddUser.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
		btnAddUser.setBounds(17, 333, 132, 48);
		frame.getContentPane().add(btnAddUser);

		JButton btnEditUser = new JButton("Edit user");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "UPDATE users SET firstname='"+textField_firstname.getText()+"', lastname='"+textField_lastname.getText()+"', groupid='"+textField_group.getText()+"' WHERE user_id='"+textField_id.getText()+"'";
				executeSQLQuery(sql, "Updated");
			}
		});
		btnEditUser.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
		btnEditUser.setBounds(159, 333, 132, 48);
		frame.getContentPane().add(btnEditUser);

		JButton btnRemoveUser = new JButton("remove user");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String sql = "DELETE FROM users WHERE user_id='"+textField_id.getText()+"'";
				executeSQLQuery(sql, "Deleted");
			}
		});
		btnRemoveUser.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
		btnRemoveUser.setBounds(301, 333, 132, 48);
		frame.getContentPane().add(btnRemoveUser);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "CA00CH45-3001", "YH00BM47-3004", "KV00CP21-3001"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_group.setText(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(146, 280, 233, 30);
		frame.getContentPane().add(comboBox);

		frame.getContentPane().add(comboBox);
	}

}