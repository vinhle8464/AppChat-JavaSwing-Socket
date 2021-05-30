package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.mindrot.jbcrypt.BCrypt;

import common.ConnectDB;
import dao.AccountDao;
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
import java.util.Arrays;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class ForgotPass extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btnSignIn;
	private JTextField txtEmail;
	private JTextField txtCode;
	private JLabel lblNewLabel;
	private int code;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ForgotPass frame = new ForgotPass();
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
	 */
	public ForgotPass() {
		setUndecorated(true);
		setTitle("Forgot Password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel()
		;
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		setIconImage(new ImageIcon("logo.png").getImage());
		
		lblNewLabel_1 = new JLabel("Forgot Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.BOLD, 30));
		
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
		
		lblNewLabel = new JLabel("<html>🔙 </html> ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickBack(e);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(66)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addGap(63))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
      
		btnSignIn = new JButton("SUBMIT")
           ;
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setBackground(new Color(30, 144, 255));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 rbtSignInActionPerformed(e);
			}
		});
		btnSignIn.setBounds(10, 298, 355, 41);
		btnSignIn.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		panel_1.setLayout(null);
		panel_1.add(btnSignIn);
		
		txtEmail = new JTextField();	
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {	
				txtEmail.setForeground(Color.BLACK);
			}
		});
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmail.setText("");
				txtEmail.setForeground(Color.BLACK);
			}
		});		
		txtEmail.setText("Enter Your Email");
//		txtUserName.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(txtUserName.getText().equals("Enter UserName")) {
//					txtUserName.setText("");
//					
//				}
//				txtUserName.setForeground(Color.BLACK);
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(txtUserName.getText().equals("")) {
//					txtUserName.setText("Enter UserName");
//					
//				}
//				txtUserName.setForeground(Color.GRAY);
//			}
//			
//		});
		
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setBounds(10, 64, 262, 33);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setText("Enter Code");
		txtCode.setForeground(Color.GRAY);
		txtCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCode.setColumns(10);
		txtCode.setBounds(10, 180, 355, 33);
		panel_1.add(txtCode);
		txtCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCode.setText("");
				txtCode.setForeground(Color.BLACK);
			}
		});	
		txtCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {	
				txtCode.setForeground(Color.BLACK);
			}
		});
		
		JButton btnSendEmail = new JButton("Send");
		btnSendEmail.setForeground(new Color(255, 255, 255));
		btnSendEmail.setBackground(new Color(30, 144, 255));
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendEmailActionPerformed(e);
			}
		});
		
		btnSendEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSendEmail.setBounds(288, 66, 77, 30);
		panel_1.add(btnSendEmail);
		
		lblNewLabel_2 = new JLabel("EMAIL :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 21, 98, 22);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CODE :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 130, 89, 22);
		panel_1.add(lblNewLabel_3);
		panel.setLayout(gl_panel);
	}
	private void clickBack(MouseEvent e) {  
		this.dispose();
		new SignIn().setVisible(true);
	}
	
	private void rbtSignInActionPerformed(ActionEvent e) {  

		if(txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter your Email");	
		}else if( CheckForm.checkEmail(txtEmail.getText())==false) {
			JOptionPane.showMessageDialog(this,"Email is not in the correct format");	
		}else {
			
			if(Integer.parseInt(txtCode.getText()) == this.code) {
				var accountdao = new AccountDao();
				
				
				String pass = accountdao.SendPass(txtEmail.getText());				
				String hash = BCrypt.hashpw(pass, BCrypt.gensalt(4));		
				
				
				
				accountdao.UpdatePassEmail(hash, txtEmail.getText());
				JOptionPane.showMessageDialog(this,"We just sent an email to your new password, please check your email");
			}
			
		}
	}

	protected void btnSendEmailActionPerformed(ActionEvent e) {
		var AccountDao = new AccountDao();
		 code = AccountDao.SendCode(txtEmail.getText());
		 JOptionPane.showMessageDialog(null, "We just sent your email a number to activate your new password !");
		 
		 
		 
	}
}
