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
import helper.CheckForm;

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
import java.sql.DriverManager;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class SignInAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btnSignIn;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInAdmin frame = new SignInAdmin();
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
	public SignInAdmin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setIconImage(new ImageIcon("logo.png").getImage());
		panel = new JPanel()
		;
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		setIconImage(new ImageIcon("unnamed.png").getImage());
		
		lblNewLabel = new JLabel("") {
            ImageIcon icon = new ImageIcon("unnamed.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
		
		lblNewLabel_1 = new JLabel("SignIn For Admin");
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
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(167))
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
		btnSignIn.setBounds(109, 201, 152, 36);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel_1.setLayout(null);
		panel_1.add(btnSignIn);
		
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
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(txtUserName.getText().equals("Enter UserName")) {
//					txtUserName.setText("");
//					
//				}
//				txtUserName.setForeground(Color.BLACK);
//			}
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
		txtUserName.setBounds(10, 41, 371, 33);
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
		passwordField.setBounds(10, 99, 371, 33);
		 passwordField.setEchoChar((char)0);
		 passwordField.addFocusListener(new FocusAdapter() {
//				@Override
//				public void focusGained(FocusEvent e) {
//					if(txtUserName.getText().equals("Enter UserName")) {
//						txtUserName.setText("");
//						
//					}
//					txtUserName.setForeground(Color.BLACK);
//				}
				@Override
				public void focusLost(FocusEvent e) {
					if(passwordField.getText().equals("")) {
						passwordField.setText("Enter Password");
						
					}
					passwordField.setForeground(Color.GRAY);
				}
				
			});
		panel_1.add(passwordField);
		panel.setLayout(gl_panel);
	}
	
	private void rbtHienActionPerformed(ActionEvent e) {  
		 passwordField.setEchoChar((char)0);
		}
	protected void clickabc(MouseEvent e) {
			passwordField.setText("");
			passwordField.setEchoChar('●');
			passwordField.setForeground(Color.BLACK);
		
	}

	private void rbtSignInActionPerformed(ActionEvent e) {  
		var admindao = new AdminDao();
		var acc = new Account();
		if(txtUserName.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your username");	
		}else if( CheckForm.checkUsername(txtUserName.getText())==false) {
			JOptionPane.showMessageDialog(this,"UserName must be from 6 to 20 character and not contain the character special, the blank space");	
		}else if(passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your password");	
		}else if( CheckForm.checkPassword(passwordField.getText())==false) {
			JOptionPane.showMessageDialog(this,"Your password must be from 6 to 20 character and not contain the character special, the blank space");	
		}else {	
			
			
			String thispass = String.valueOf( passwordField.getPassword());
			String account = admindao.SelAccountAdmin(txtUserName.getText());
			String pass = admindao.SelPassAdmin(account); 
			String classify = admindao.SelClassifyAdmin(account);
			
			boolean match = BCrypt.checkpw(thispass, pass);
			if(txtUserName.getText().equals("Enter UserName") || passwordField.getText().equals("Enter Password")) {
				JOptionPane.showMessageDialog(null, "Username or password is empty");
			}
			
			if(account.equals(txtUserName.getText()) && match == true && classify.equals("A")) {
				Admin ad = new Admin();
				ad.setVisible(true);
				this.setVisible(false);
				
				JOptionPane.showMessageDialog(null, "Login success admin");
				
			} else if(account.equals(txtUserName.getText()) && match == true && classify.equals("M")) {
				Manager mn = new Manager();
				mn.setVisible(true);
				this.setVisible(false);
				
				JOptionPane.showMessageDialog(null, "Login success manager");
			}else if(account.equals(txtUserName.getText()) && match == true && classify.equals("L")) {
//				Leader ld = new Leader();
//				ld.setVisible(true);
//				this.setVisible(false);
				
				//JOptionPane.showMessageDialog(null, "Login success Leader");
			}else {
				JOptionPane.showMessageDialog(null, "Wrong account");
			}
			
			}
		}
}
