package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import common.ConnectDB;
import dao.AccountDao;
import dao.AdminDao;
import entity.Account;
import entity.MessageChat;
import helper.CheckForm;

import view.ForgotPass;
import view.ServerRoom;
import view.SignUp;

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
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btnSignIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	//---
	
	private static InetAddress host;
	private static int port;
	private static Socket socket;
	private static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel()
		;
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		setIconImage(new ImageIcon("logo.png").getImage());
		
		lblNewLabel = new JLabel("") {
            ImageIcon icon = new ImageIcon("unnamed.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
		
		lblNewLabel_1 = new JLabel("SignIn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		panel_1 = new JPanel() {
            ImageIcon icon = new ImageIcon("bg1.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
		panel_1.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(541))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(108)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(737, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(312))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
      
		btnSignIn = new JButton("Sign in")
           ;
		btnSignIn.setBackground(new Color(30, 144, 255));
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 rbtSignInActionPerformed(e);
			}
		});
		btnSignIn.setBounds(112, 241, 152, 36);
		btnSignIn.setFont(new Font("Sylfaen", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("You don't have an account ?");
		lblNewLabel_2.setBounds(10, 339, 178, 20);
		
		JLabel lblNewLabel_3 = new JLabel("<html><u> SignUp Now</u></html> ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(169, 343, 78, 13);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3(e);
				
			}
		});
		lblNewLabel_3.setForeground(Color.BLUE);
		
		JRadioButton rbtHien = new JRadioButton("Visibly");
		rbtHien.setBounds(10, 138, 88, 21);
		rbtHien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   if (rbtHien.isSelected()) {
					   rbtHienActionPerformed(e);
				   } else {
					   passwordField.setEchoChar('●');
				   }
				
			}
		});
		
		panel_1.setLayout(null);
		panel_1.add(btnSignIn);
		panel_1.add(rbtHien);
		panel_1.add(lblNewLabel_2);
		panel_1.add(lblNewLabel_3);
		
		txtUserName = new JTextField();	
		txtUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUserName.setText("");
				txtUserName.setForeground(Color.BLACK);
			}
		});
		txtUserName.setText("Enter UserName");
		txtUserName.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().equals("")) {
					txtUserName.setText("Enter UserName");
					
				}
				txtUserName.setForeground(Color.GRAY);
			}
			
		});
		
		txtUserName.setForeground(Color.GRAY);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUserName.setBounds(10, 41, 361, 33);
		panel_1.add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickabc(e);
			}
		});
		passwordField.setText("Enter Password");
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(10, 99, 361, 33);
		 passwordField.setEchoChar((char)0);
		 passwordField.addFocusListener(new FocusAdapter() {

				@Override
				public void focusLost(FocusEvent e) {
					if(passwordField.getText().equals("")) {
						passwordField.setText("Enter Password");
						
					}
					passwordField.setForeground(Color.GRAY);
				}
				
			});
		panel_1.add(passwordField);
		JLabel lblNewLabel_4 = new JLabel("<html><u> Forgot Password</u></html> ");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rbtFPActionPerformed(e);
			}
		});
		lblNewLabel_4.setBounds(255, 139, 116, 19);
		panel_1.add(lblNewLabel_4);
		panel.setLayout(gl_panel);
		
		username = txtUserName.getText();
		
	}
	
	
	
	
	
	protected void lblNewLabel_3(MouseEvent e) {
		new SignUp().setVisible(true);
		this.setVisible(false);
	}
	
	private void rbtHienActionPerformed(ActionEvent e) {  
		 passwordField.setEchoChar((char)0);
		}
	protected void clickabc(MouseEvent e) {
			passwordField.setText("");
			passwordField.setEchoChar('●');
			passwordField.setForeground(Color.BLACK);
		
	}
	private void rbtFPActionPerformed(MouseEvent e) {  
		 new ForgotPass().setVisible(true);
		 this.setVisible(false);
		}
	private void rbtSignInActionPerformed(ActionEvent e) {  
		var admindao = new AdminDao();
		var accountdao = new AccountDao();
		var acc = new Account();
		
		String username = accountdao.SelAccountAdmin(txtUserName.getText());
		if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your username");	
		}else if( CheckForm.checkUsername(txtUserName.getText())==false) {
			JOptionPane.showMessageDialog(this,"UserName must be from 3 to 20 character and not contain the character special, the blank space");	
		}else if(passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(passwordField.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 3 to 20 character and not contain the character special, the blank space");	
		}if(txtUserName.getText().equals(username)) {
			
			
			String thispass = String.valueOf( passwordField.getPassword());
			String account = admindao.SelAccountAdmin(txtUserName.getText());
			String pass = admindao.SelPassAdmin(account);
			String classify = admindao.SelClassifyAdmin(account);
			String statusacc = accountdao.SelStatusAcc(account);
			
			boolean match = BCrypt.checkpw(thispass, pass);
			if(statusacc.equals("1") ) {
				if(txtUserName.getText().equals(account)) {
					
					 if ( match == true && classify.equals("U")) {
			        	new AdminDao().SelPassAdmin(String.valueOf(passwordField.getPassword()));
			        	
		
			    
			        	JOptionPane.showMessageDialog(null, "Login successfully");		        	
			        	new ChatPanel(txtUserName.getText()).setVisible(true);
						this.setVisible(false);	
					        }else {	
					        	JOptionPane.showMessageDialog(null, "Wrong Passwword or UserName !");
					        }

					}else {
						JOptionPane.showMessageDialog(null, "Account does not exist");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Account does not exist");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Account does not exist");

			}
	}
}


