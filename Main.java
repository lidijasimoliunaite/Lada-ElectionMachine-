import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private JTextField textField_group;
	private JTextField textField_lastname;
	private JTextField textField_firstname;
	private JTextField textField_id;
	private JTable table;
	private JComboBox comboBox;

	public Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
public Connection getConnection() {
		    return null;
		}
	}
	String query = "SELECT * FROM users";
	String query = "SELECT * FROM users2";
	private JTextField textField_newid;
	public ArrayList<UserInfo> getUsersList(String query){
		ArrayList<UserInfo> usersList = new ArrayList<UserInfo>();
		Connection connection = getConnection();
public Connection getConnection() {
			rs = st.executeQuery(query);
			UserInfo user;
			while(rs.next()) {
				user = new UserInfo(rs.getInt("user_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("groupid"),rs.getInt("result"));
				user = new UserInfo(rs.getInt("user_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("groupid"),rs.getInt("result"),rs.getString("newid"));
				usersList.add(user);		
			}
		} catch (Exception e) {
public Connection getConnection() {
	public void DisplayInTable(String OrderQuery) {
		ArrayList<UserInfo> list = getUsersList(OrderQuery);
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"user-id","firstname","lastname","groupid","result"});
		model.setColumnIdentifiers(new Object[] {"firstname","lastname","groupid","result","KEY"});
		Object[] row = new Object[5];
		for(int i=0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getFirstName();
			row[2] = list.get(i).getLastName();
			row[3] = list.get(i).getGroup();
			row[4] = list.get(i).getResult();
			row[0] = list.get(i).getFirstName();
			row[1] = list.get(i).getLastName();
			row[2] = list.get(i).getGroup();
			row[3] = list.get(i).getResult();
			row[4] = list.get(i).getNewId();
			model.addRow(row);
		}
		table.setModel(model);
private void initialize() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
                textField_id.setText(model.getValueAt(i,0).toString());
                textField_firstname.setText(model.getValueAt(i,1).toString());
                textField_lastname.setText(model.getValueAt(i,2).toString());
                textField_group.setText(model.getValueAt(i,3).toString());
                textField_firstname.setText(model.getValueAt(i,0).toString());
                textField_lastname.setText(model.getValueAt(i,1).toString());
                textField_group.setText(model.getValueAt(i,2).toString());
                textField_newid.setText(model.getValueAt(i,4).toString());
			}
		});
		table.setToolTipText("");
 public void mouseClicked(MouseEvent e) {
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Group", "Result"
				"First Name", "Last Name", "Group", "Result", "KEY"
			}
		));

		JButton btnAddUser = new JButton("ADD user");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO users(firstname, lastname, groupid) VALUES ('"+textField_firstname.getText()+"','"+textField_lastname.getText()+"','"+textField_group.getText()+"')";
				executeSQLQuery(sql, "Inserted");
				    int letterIndex = (int)(Math.random() * 9999 + 1000);
				    int letterIndex2 = (int)(Math.random() * 9999 + 1000);
				    int letterIndex3 = (int)(Math.random() * 99 + 10);
				    String strI = Integer.toString(letterIndex)+Integer.toString(letterIndex2)+Integer.toString(letterIndex3);
				    Connection connection = getConnection();
				    Statement stmt;
					try {
						stmt = connection.createStatement();
					    ResultSet rs = stmt.executeQuery("SELECT * FROM users2 WHERE newid = '"+strI+"'");
					    while(rs.next()) {
					   letterIndex = (int)(Math.random() * 9999 + 1000);
					   letterIndex2 = (int)(Math.random() * 9999 + 1000);
					   letterIndex3 = (int)(Math.random() * 99 + 10);
					   strI = Integer.toString(letterIndex)+Integer.toString(letterIndex2)+Integer.toString(letterIndex3);
					    }
					String sql = "INSERT INTO users2(firstname, lastname, groupid, result, newid) VALUES ('"+textField_firstname.getText()+"','"+textField_lastname.getText()+"','"+textField_group.getText()+"','0','"+strI+"')";
					executeSQLQuery(sql, "Inserted");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

			}
		});
		btnAddUser.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
public void actionPerformed(ActionEvent e) {
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "UPDATE users SET firstname='"+textField_firstname.getText()+"', lastname='"+textField_lastname.getText()+"', groupid='"+textField_group.getText()+"' WHERE user_id='"+textField_id.getText()+"'";
				String sql = "UPDATE users2 SET firstname='"+textField_firstname.getText()+"', lastname='"+textField_lastname.getText()+"', groupid='"+textField_group.getText()+"' WHERE newid='"+textField_newid.getText()+"'";
				executeSQLQuery(sql, "Updated");
			}
		});
 public void actionPerformed(ActionEvent e) {
		JButton btnRemoveUser = new JButton("remove user");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String sql = "DELETE FROM users WHERE user_id='"+textField_id.getText()+"'";
			    String sql = "DELETE FROM users2 WHERE newid='"+textField_newid.getText()+"' AND firstname='"+textField_firstname.getText()+"'";
				executeSQLQuery(sql, "Deleted");
			}
		});
public void actionPerformed(ActionEvent e) {
		comboBox.setBounds(146, 280, 233, 30);

		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Artiom\\Desktop\\Files for study and other\\LADA logotypes\\java.png"));
		lblNewLabel.setBounds(17, 29, 426, 123);
		frame.getContentPane().add(lblNewLabel);

		JButton btnSortAz = new JButton("Sort A-Z");
		btnSortAz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "SELECT * FROM users2 ORDER by firstname";
				DisplayInTable(query);
			}
		});
		btnSortAz.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
		btnSortAz.setBounds(493, 10, 203, 47);
		frame.getContentPane().add(btnSortAz);

		JButton btnNewCostumers = new JButton("New costumers");
		btnNewCostumers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "SELECT * FROM users2 ORDER by regtime DESC";
				DisplayInTable(query);
			}
		});
		btnNewCostumers.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 16));
		btnNewCostumers.setBounds(739, 10, 193, 47);
		frame.getContentPane().add(btnNewCostumers);

		textField_newid = new JTextField();
		textField_newid.setEditable(false);
		textField_newid.setBounds(140, 162, 243, 29);
		frame.getContentPane().add(textField_newid);
		textField_newid.setColumns(10);

		JLabel lblCostumerKey = new JLabel("Costumer key:");
		lblCostumerKey.setFont(new Font("Soup of Justice (cyrillic by shurupkin)", Font.PLAIN, 18));
		lblCostumerKey.setBounds(17, 162, 123, 29);
		frame.getContentPane().add(lblCostumerKey);
	}
}

}