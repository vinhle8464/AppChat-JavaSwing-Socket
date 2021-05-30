package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import dao.AdminDao;
import entity.Account;

import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUpdateAccount extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtFullname;
	private JLabel lblNewLabel_2;
	private JTextField txtGender;
	private JLabel lblNewLabel_3;
	private JTextField txtAddress;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtPhone;
	private JLabel lblNewLabel_6;
	private JTextField txtEmail;
	private JButton btnUpdate;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_7;
	private JTextField txtID;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminUpdateAccount frame = new AdminUpdateAccount();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminUpdateAccount() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 619);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("logo.png").getImage());
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("UPDATE ACCOUNT");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblNewLabel_1 = new JLabel("FULLNAME :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		
		lblNewLabel_2 = new JLabel("GENDER :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtGender = new JTextField();
		txtGender.setColumns(10);
		
		lblNewLabel_3 = new JLabel("ADDRESS :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		lblNewLabel_4 = new JLabel("DATE OF BIRTH :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_5 = new JLabel("PHONE :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		lblNewLabel_6 = new JLabel("EMAIL :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBackground(new Color(30, 144, 255));
		
		dateChooser = new JDateChooser();
		
		lblNewLabel_7 = new JLabel("ID FOR UPDATE :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		lblNewLabel_8 = new JLabel("<html>🔙 </html> ");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8MouseClicked(e);
			}
		});
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFullname, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGender, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAddress, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtID)))))
					.addContainerGap(116, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(167))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtGender, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnUpdate)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		AdminDao dao = new AdminDao();
		Account acc = new Account();
		if(txtFullname.getText().equals("")
				||(dateChooser.getDate().equals("")||(txtPhone.getText().equals("")||(txtEmail.getText().equals("")
						||(txtAddress.getText().equals("")||(txtGender.getText().equals(""))))))){
			JOptionPane.showMessageDialog(this, "Please enter your information!");
			
		}

		
		acc.setFullname(txtFullname.getText());
		acc.setGender(txtGender.getText());
		acc.setAddr(txtAddress.getText());
		acc.setDob(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		acc.setPhone(txtPhone.getText());
		acc.setEmail(txtEmail.getText());
		
		
		int id = Integer.parseInt( txtID.getText());
		new AdminDao().UpdateAccount(acc, id);
	}
	protected void lblNewLabel_8MouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
}
