package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import dao.AccountDao;
import entity.Account;

import helper.CheckForm;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame {
	String filename=null;
	byte[] person_image=null;
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JTextField txtEmail;
	private JButton btnSignUp;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtUserName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtFullName;
	private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp frame = new SignUp();
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
	public SignUp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel()
		;
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		setIconImage(new ImageIcon("logo.png").getImage());
		
		lblNewLabel_1 = new JLabel("SignUp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(114)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		
		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmail.setText("");
				txtEmail.setForeground(Color.BLACK);
			}
		});
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setText("Enter You Email");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBackground(new Color(30, 144, 255));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 rbtSignUpActionPerformed(e);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
				passwordField.setEchoChar('●');
				passwordField.setForeground(Color.BLACK);
				
			}
		});
		passwordField.setText("Enter Password");
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(10, 99, 262, 33);
		 passwordField.setEchoChar((char)0);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField_1.setText("");
				passwordField_1.setEchoChar('●');
				passwordField_1.setForeground(Color.BLACK);
			}
		});
		passwordField_1.setText("Enter Request Password");
		passwordField_1.setForeground(Color.GRAY);
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_1.setBounds(10, 99, 262, 33);
		 passwordField_1.setEchoChar((char)0);
		
		txtUserName = new JTextField();
		txtUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUserName.setText("");
				txtUserName.setForeground(Color.BLACK);
			}
		});
		txtUserName.setForeground(Color.GRAY);
		txtUserName.setText("Enter UserName");
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUserName.setColumns(10);
		
		lblNewLabel_2 = new JLabel("You have an account ?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_3 = new JLabel("<html><u> SignIn now</u></html> ");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3(e);
			}
		});
		lblNewLabel_3.setForeground(Color.BLUE);
		
		txtFullName = new JTextField();
		txtFullName.setText("Enter FullName");
		txtFullName.setForeground(Color.GRAY);
		txtFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFullName.setColumns(10);
		txtFullName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFullName.setText("");
				txtFullName.setForeground(Color.BLACK);
			}
		});
		
	
		dateChooser = new JDateChooser();
		dateChooser.setDate(new Date());
		dateChooser.setDateFormatString("yyyy-MM-dd");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(61)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEmail)
					.addGap(26))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(4))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}
	protected void lblNewLabel_3(MouseEvent e) {
		new SignIn().setVisible(true);
		this.setVisible(false);
	}
	private void rbtSignUpActionPerformed(ActionEvent e) {
		// avatar
		try {
			File image = new File("avatar.jpg");
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new  ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for(int readNum;(readNum=fis.read(buf)) != -1;) {
				bos.write(buf,0,readNum);
				
			}
			person_image=bos.toByteArray();
			
		} catch (Exception e2) {
			JOptionPane.showInternalMessageDialog(null, e2);
		}
		
		AccountDao dao = new AccountDao();
			Account acc = new Account();
		if(txtFullName.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your name");
		}else if( CheckForm.checkFullname(txtFullName.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your name must be literal and must contain no special characters");
		}else if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your username");
		}else if( CheckForm.checkUsername(txtUserName.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your username must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your email");	
		}else if( CheckForm.checkEmail(txtEmail.getText())==false) {
			JOptionPane.showMessageDialog(this,"Email is not in the correct format");	
		}else if(passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(passwordField.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(passwordField_1.getText().equals("") && passwordField!=passwordField_1) {
			JOptionPane.showMessageDialog(this,"Request password not correct"," Please enter again!", JOptionPane.ERROR_MESSAGE);	
		}else if(dao.checkAcc(txtUserName.getText())) {
			JOptionPane.showMessageDialog(this,"User name already exists"," Please enter again!", JOptionPane.ERROR_MESSAGE);
		}else {			
			acc.setFullname(txtFullName.getText());
			acc.setAccount(txtUserName.getText());
			acc.setEmail(txtEmail.getText());
				String hash = BCrypt.hashpw(passwordField.getText(), BCrypt.gensalt(4));		
			acc.setPass(hash);
			acc.setClassify("U");
			acc.setDob(dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());	
			acc.setStatus_acc("1");
			acc.setPicture(person_image);
				LocalDateTime myObj = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String formatDateTime = myObj.format(formatter);
            acc.setDate_create(formatDateTime);    
			dao.insertAccount(acc);	
				JOptionPane.showMessageDialog(this,"Success !");	
			}
		}
}
