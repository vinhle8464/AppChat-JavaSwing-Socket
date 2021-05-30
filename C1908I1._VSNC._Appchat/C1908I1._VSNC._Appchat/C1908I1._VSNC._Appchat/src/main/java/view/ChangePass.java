package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import dao.AccountDao;
import dao.AdminDao;
import entity.Account;
import helper.CheckForm;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField pwOld;
	private JLabel lblNewLabel_2;
	private JPasswordField pwNew;
	private JLabel lblNewLabel_3;
	private JPasswordField pwNewConfirm;
	private JButton btnChangePass;
	private String username;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePass frame = new ChangePass(null);
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
	public ChangePass(String account) {
//		setUndecorated(true);
		username = account;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(new ImageIcon("logo.png").getImage());
		
		lblNewLabel = new JLabel("CHANGE PASSWORD");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblNewLabel_1 = new JLabel("Old Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pwOld = new JPasswordField();
		
		lblNewLabel_2 = new JLabel("New Password :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pwNew = new JPasswordField();
		
		lblNewLabel_3 = new JLabel("Confirm Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pwNewConfirm = new JPasswordField();
		
		btnChangePass = new JButton("CHANGE PASSWORD");
		btnChangePass.setForeground(new Color(255, 255, 255));
		btnChangePass.setBackground(new Color(135, 206, 250));
		btnChangePass.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePassActionPerformed(e);
			}
		});
		
		lblNewLabel_4 = new JLabel("<html>🔙 </html> ");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_4MouseClicked(e);
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwOld, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwNew, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwNewConfirm, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(83, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(106))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(128)
					.addComponent(btnChangePass)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(lblNewLabel)
					.addGap(29)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(pwOld, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(pwNew, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(pwNewConfirm, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(btnChangePass)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnChangePassActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		var admindao = new AdminDao();
		
		 if(pwOld.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(pwOld.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(pwNew.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(pwNew.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(pwNewConfirm.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(pwNewConfirm.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 6 to 20 character and not contain the character special, the blank space");	
		}else {
		String thispassOld = String.valueOf(pwOld.getPassword());
		
		String thispassNew = BCrypt.hashpw(pwNew.getText(), BCrypt.gensalt(4));
		
		String account = accountdao.SelAccount(username);
		String pass = admindao.SelPassAdmin(account);
		
		boolean match = BCrypt.checkpw( thispassOld, pass );
		
		if(account.equals(username) && match == true &&  pwNew.getText().equals(pwNewConfirm.getText())) {
			new AdminDao().SelPassAdmin(String.valueOf(pwOld.getPassword()));
			accountdao.ChangePassword(thispassNew,username);
			JOptionPane.showMessageDialog(null, "Change Password Success");
		}else {
			JOptionPane.showMessageDialog(null, "Fail , please check your password");
		}
		
		}
		
		
	}
	protected void lblNewLabel_4MouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
}
