package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import dao.AdminDao;
import dao.AccountDao;
import entity.Account;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JButton btnLoad;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JTextField txtxfd;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField txtFullname;
	private JLabel lblGender;
	private JLabel lblAdddress;
	private JTextField txtAddr;
	private JLabel lblEmail;
	private JLabel lblNewLabel_1;
	private JTextField txtPhone;
	private JLabel lblPhone;
	private JLabel lblNewLabel_2;
	private JDateChooser dateChooser;
	private JLabel lblDob;
	private JTextField txtEmail;
	private JButton btnReset;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel panel_3;
	private JTextField txtGender;
	private JLabel lblNewLabel_3;
	private JTextField txtAcc;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtClassify;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		//setUndecorated(true);
		setResizable(false);
		setTitle("Admin ✿◕ ‿ ◕✿ " );
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 808);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("logo.png").getImage());
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Search :", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		
		lblNewLabel = new JLabel("Fullname :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblAdddress = new JLabel("Adddress :");
		lblAdddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_1 = new JLabel("");
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dateChooser = new JDateChooser();
		
		lblDob = new JLabel("Date of Birth :");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(30, 144, 255));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		btnReset.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		
		txtGender = new JTextField();
		txtGender.setColumns(10);
		
		lblNewLabel_3 = new JLabel("User Account :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAcc = new JTextField();
		txtAcc.setColumns(10);
		
		lblNewLabel_6 = new JLabel("CLassify :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtClassify = new JTextField();
		txtClassify.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(259)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)))
					.addGap(141))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(272, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtGender, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdddress, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(301, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtAddr, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(318, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(271, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addContainerGap(293, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtAcc, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(149))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addContainerGap(327, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtClassify, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblGender)
					.addGap(13)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAdddress))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(78)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAddr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addGap(18)
					.addComponent(lblDob)
					.addGap(18)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPhone)
					.addGap(18)
					.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEmail)
					.addGap(18)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(txtAcc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addGap(18)
					.addComponent(txtClassify, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(52))
		);
		panel_1.setLayout(gl_panel_1);
		
		lblNewLabel_5 = new JLabel("ACCOUNT INFORMATION :");
		lblNewLabel_5.setForeground(new Color(30, 144, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 18));
		
		lblNewLabel_7 = new JLabel("<html>🔙 </html> ");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7MouseClicked(e);
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		txtxfd = new JTextField();
		txtxfd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		txtxfd.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		btnLoad = new JButton("<html> LOAD</html> ");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoad.setForeground(new Color(255, 255, 255));
		btnLoad.setBackground(new Color(30, 144, 255));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});
		
		panel_3 = new JPanel();
		
		btnAdd = new JButton("+ Add");
		btnAdd.setBackground(Color.GREEN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});

		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(171)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtxfd, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtxfd, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoad))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	//click button lo
	protected void btnLoadActionPerformed(ActionEvent e) {
	AdminDao dao = new AdminDao ();
		
		LoadAdmin(dao);
		
		
		}

	private void LoadAdmin(AdminDao dao) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Fullname");
		model.addColumn("Gender");
		model.addColumn("Adddress");
		model.addColumn("Dob");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("Account");
		model.addColumn("Classify");
		
		for(Account acc :dao.getListAppChat()) {
			model.addRow(new Object[] {acc.getId_acc(),acc.getFullname(),acc.getGender(), acc.getAddr() , acc.getDob(), acc.getPhone(),acc.getEmail(),acc.getAccount(),acc.getClassify() });	
		}
		table.setModel(model);
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		String find = txtxfd.getText();
		DefaultRowSorter<?,?> sorter = (DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int rowindex = table.getSelectedRow();
		
		txtFullname.setText(table.getValueAt(rowindex,1).toString());
		txtGender.setText(table.getValueAt(rowindex,2).toString());
		txtAddr.setText(table.getValueAt(rowindex,3).toString());
		
		
		try {
			dateChooser.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowindex, 4).toString())
					);
			
			
			}catch(ParseException e1) {
				
				e1.printStackTrace();
			}
		txtPhone.setText(table.getValueAt(rowindex, 5).toString());
		txtEmail.setText(table.getValueAt(rowindex, 6).toString());
		txtAcc.setText(table.getValueAt(rowindex, 7).toString());		
		txtClassify.setText(table.getValueAt(rowindex, 8).toString());
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		var accdao = new AccountDao();
		var dao = new AdminDao();
		var acc = new Account();
		if(txtFullname.getText().equals("")
				||(dateChooser.getDate().equals("")||(txtPhone.getText().equals("")||(txtEmail.getText().equals("")
						||(txtAddr.getText().equals("")||(txtGender.getText().equals(""))))))){
			JOptionPane.showMessageDialog(this, "Please enter your information!");
			
		}if(txtClassify.getText().equals("U") || txtClassify.getText().equals("A") || txtClassify.getText().equals("M")  ) {
		
		
		
		acc.setFullname(txtFullname.getText());
		acc.setGender(txtGender.getText());
		acc.setDob(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		acc.setPhone(txtPhone.getText());
		acc.setEmail(txtEmail.getText());
		acc.setAddr(txtAddr.getText());
		acc.setAccount(txtAcc.getText());
		acc.setClassify(txtClassify.getText());
		
		
		
		
		dao.AddAccount(acc);
		
		
			
			
			
			String pass = accdao.SendPass(txtEmail.getText());				
			String hash = BCrypt.hashpw(pass, BCrypt.gensalt(4));		
			
			
			
			accdao.UpdatePassEmail(hash, txtEmail.getText());
		
	
		JOptionPane.showMessageDialog(null, "Add a successful account");
		}else {
			JOptionPane.showMessageDialog(this, "Classify must be Admin(A),User(U) or Manager(M) !");
		}
		
	}
	
	//
	protected void btnResetActionPerformed(ActionEvent e) {
		txtFullname.setText("");
		txtGender.setText("");
		txtAddr.setText("");
		txtAcc.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		dateChooser.setDate(null);
		txtClassify.setText("");
		
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		AdminUpdateAccount Up = new AdminUpdateAccount();
		Up.setVisible(true);
//		this.setVisible(false);
		
	}
	protected void lblNewLabel_7MouseClicked(MouseEvent e) {
		this.dispose();
		new SignInAdmin().setVisible(true);
	}
}