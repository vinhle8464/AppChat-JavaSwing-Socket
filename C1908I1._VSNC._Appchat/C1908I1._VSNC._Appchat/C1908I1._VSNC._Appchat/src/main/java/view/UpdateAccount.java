package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import common.ConnectDB;
import dao.AccountDao;
import entity.Account;
import helper.CheckForm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class UpdateAccount extends JFrame {

	
	String filename=null;
	byte[] person_image=null;
	
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFullname;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox cbbGender;
	private JLabel lblNewLabel_3;
	private JTextField textPhone;
	private JLabel lblNewLabel_4;
	private JTextField textEmail;
	private JLabel lblNewLabel_5;
	private JButton btnUpdate;
	private JLabel lblNewLabel_6;
	private JTextField textAddr;
	private Account acc;
	private SignIn sign;
	private String username;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JLabel lblimg;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateAccount frame = new UpdateAccount(null);
//					frame.setLocationRelativeTo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param account 
	 */
	public UpdateAccount(String account) {
		username = account;
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 702);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(new ImageIcon("logo.png").getImage());
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		dateChooser = new JDateChooser();
		
		textFullname = new JTextField();
		textFullname.setColumns(10);
		
		lblNewLabel = new JLabel("FULLNAME :");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		lblNewLabel_1 = new JLabel("DATE OF BIRTH :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		lblNewLabel_2 = new JLabel("GENDER :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		cbbGender = new JComboBox();
		cbbGender.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "---", "MALE", "FEMALE", "OTHER", "---"}));
		
		lblNewLabel_3 = new JLabel("PHONE NUMBER :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		
		lblNewLabel_4 = new JLabel("EMAIL :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		lblNewLabel_5 = new JLabel("UPDATE ACCOUNT");
		lblNewLabel_5.setForeground(new Color(30, 144, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnUpdate = new JButton("CONFIRM");
		btnUpdate.setBackground(new Color(30, 144, 255));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_6 = new JLabel("ADDRESS :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		textAddr = new JTextField();
		textAddr.setColumns(10);
		
		lblNewLabel_7 = new JLabel("<html>🔙 </html> ");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7MouseClicked(e);
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		btnNewButton = new JButton("📸 Choose an image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		
		lblimg = new JLabel("New label");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(138)
							.addComponent(btnUpdate))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(127)
							.addComponent(lblimg, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addGap(153))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(textEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(textPhone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(cbbGender, Alignment.LEADING, 0, 226, Short.MAX_VALUE)
						.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(textFullname, Alignment.LEADING, 226, 226, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, Alignment.LEADING)
						.addComponent(textAddr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
					.addGap(92))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel_5)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(lblNewLabel_5)
					.addGap(28)
					.addComponent(lblimg, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbbGender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textAddr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdate)
					.addGap(22))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		var loadimage = new LoadImage(username);
		loadimage.start();
	}
	
	
	
	//code moi	
class LoadImage extends Thread{
		
		private String username;
		
		
		public LoadImage() {}
		public LoadImage(String username) {
			
			this.username = username;
		}

		@Override
		public void run() {
			var dao = new AccountDao();

			byte[] img = dao.SelImage(username);
			
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH));
			
			lblimg.setIcon(imageIcon);
			
			
			
			
			var accountdao = new AccountDao();
			
			
			
			for (Account acc  : accountdao.getListInfoAccount(username)) {
				textFullname.setText(acc.getFullname());
				textAddr.setText(acc.getAddr());
				textEmail.setText(acc.getEmail());
				textPhone.setText(acc.getPhone());
				dateChooser.setDate(Date.valueOf(acc.getDob()));
				cbbGender.setSelectedItem(acc.getGender().toString());
			}
			
		}

	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		var account = new Account();
		if(textFullname.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your fullname");	
		}else if( CheckForm.checkFullname(textFullname.getText())==false) {
			JOptionPane.showMessageDialog(this,"Fullname must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(dateChooser.equals("") || cbbGender.getSelectedItem().equals("SELECT") || textAddr.getText().equals("") || textPhone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill it out completely ");
		}else if(textEmail.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Please enter your email");
		}else if( CheckForm.checkEmail(textEmail.getText())==false) {
			JOptionPane.showMessageDialog(this,"Email is not in the correct format");	
		}else {
		
		
		account.setPicture(person_image);
		account.setFullname(textFullname.getText());
		account.setDob(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		account.setGender(cbbGender.getSelectedItem().toString());
		account.setPhone(textPhone.getText());
		account.setEmail(textEmail.getText());
		account.setAddr(textAddr.getText());
				
		
		}
		new AccountDao().UpdateAccount(account,cbbGender.getSelectedItem().toString(),username);
		
	}
	protected void lblNewLabel_7MouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		filename = f.getAbsolutePath();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(),Image.SCALE_SMOOTH));
		lblimg.setIcon(imageIcon);
		try {
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new  ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for(int readNum;(readNum=fis.read(buf)) != -1;) {
				bos.write(buf,0,readNum);
				
			}
			person_image=bos.toByteArray();
			
		} catch (Exception e2) {
			JOptionPane.showInternalMessageDialog(null, e);
		}
	}
}
