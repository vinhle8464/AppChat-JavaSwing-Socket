package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AccountDao;
import dao.AdminDao;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DeleAcc extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField txtAccount;
	private JButton btnDel;
	private String username;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleAcc frame = new DeleAcc(null);
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
	 * @param username 
	 */
	public DeleAcc(String account) {
		username = account;
		setUndecorated(true);
		setTitle("DELETE ACCOUNT");
		// tắt những nút tắt phía trên
//		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("logo.png").getImage());
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("DELETE ACCOUNT");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		panel = new JPanel();
		
		lblNewLabel_2 = new JLabel("<html>🔙 </html> ");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
							.addGap(88))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(389, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		
		lblNewLabel_1 = new JLabel(" Account for delete  :");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		
		
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtAccount = new JTextField();
		txtAccount.setForeground(Color.GRAY);
		txtAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAccount.setText("Please enter the account you want to delete :");
		// khi click vào sẽ reset dòng phía trên 
		txtAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAccount.setText("");
				txtAccount.setForeground(Color.BLACK);
			}
		});
		txtAccount.setColumns(10);
		
		btnDel = new JButton("<html>&#128473; Delete</html>");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelActionPerformed(e);
			}
		});
		btnDel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnDel.setBackground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(123)
							.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtAccount, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel_1)
					.addGap(44)
					.addComponent(txtAccount, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void btnDelActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		String thisusername = accountdao.SelAccountAdmin(username);
		
		if(txtAccount.getText().equals(username)) {		
			new AccountDao().DelAccount(txtAccount.getText());
			JOptionPane.showMessageDialog(null, "DELETE SUCCESS !"); 
			new SignIn().setVisible(true);
			this.setVisible(false);
			return;
		}else {
			JOptionPane.showMessageDialog(null, "Please , check your account in text it's wrong");
		}
		
		
	}
}
