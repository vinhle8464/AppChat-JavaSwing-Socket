package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import dao.AccountDao;
import entity.Account;

import entity.MessageChat;
import helper.CheckForm;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Color;

public class AddFriend extends JFrame {

	private JPanel contentPane;
	private JLabel lblIamge;
	private JLabel lblUsername;
	private JButton btnAddFriend;
	private JButton btnNewButton_1;
	private String username;
	private String namefriend;
	private JLayeredPane layeredPane;
	private JPanel panelAddFriend;
	private JPanel panelUnfriend;
	private JButton btnUnfriend;
	private JPanel panelAcceptFriend;
	private JPanel panelCancel;
	private JButton btnCancel;
	private JButton btnAcceptFriend;
	private JButton btnRefuse;
	private Integer portchat;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddFriend frame = new AddFriend(null,null);
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
	public AddFriend(String account, String friendname) {
		setUndecorated(true);
		username = account;
		namefriend = friendname;
		System.out.println(friendname);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("logo.png").getImage());
		setContentPane(contentPane);
		
		lblIamge = new JLabel("New label");
		lblIamge.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblUsername = new JLabel("New label");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setText(friendname);
		
		btnNewButton_1 = new JButton("<html>🔙 </html> ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		
		layeredPane = new JLayeredPane();
		
		JLabel lblNewLabel = new JLabel(" sent you a friend's invitation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addGap(59)
					.addComponent(lblIamge, GroupLayout.PREFERRED_SIZE, 196, Short.MAX_VALUE)
					.addGap(142))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIamge, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		panelAcceptFriend = new JPanel();
		panelAcceptFriend.setBounds(6, 6, 418, 115);
		layeredPane.add(panelAcceptFriend);
		
		btnAcceptFriend = new JButton("Accept");
		btnAcceptFriend.setBackground(new Color(30, 144, 255));
		btnAcceptFriend.setForeground(new Color(255, 255, 255));
		btnAcceptFriend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAcceptFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptFriendActionPerformed(e);
			}
		});
		
		btnRefuse = new JButton("Delete");
		btnRefuse.setForeground(new Color(255, 255, 255));
		btnRefuse.setBackground(new Color(30, 144, 255));
		btnRefuse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefuseActionPerformed(e);
			}
		});
		GroupLayout gl_panelAcceptFriend = new GroupLayout(panelAcceptFriend);
		gl_panelAcceptFriend.setHorizontalGroup(
			gl_panelAcceptFriend.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAcceptFriend.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelAcceptFriend.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAcceptFriend, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRefuse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAcceptFriend.setVerticalGroup(
			gl_panelAcceptFriend.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelAcceptFriend.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAcceptFriend, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnRefuse, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelAcceptFriend.setLayout(gl_panelAcceptFriend);
		panelAcceptFriend.setVisible(false);
		
		panelCancel = new JPanel();
		panelCancel.setBounds(6, 6, 418, 115);
		layeredPane.add(panelCancel);
		
		btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
		GroupLayout gl_panelCancel = new GroupLayout(panelCancel);
		gl_panelCancel.setHorizontalGroup(
			gl_panelCancel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCancel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelCancel.setVerticalGroup(
			gl_panelCancel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCancel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelCancel.setLayout(gl_panelCancel);
		
		panelAddFriend = new JPanel();
		panelAddFriend.setBounds(6, 6, 418, 115);
		layeredPane.add(panelAddFriend);
		
					btnAddFriend = new JButton("Add Friend");
					GroupLayout gl_panelAddFriend = new GroupLayout(panelAddFriend);
					gl_panelAddFriend.setHorizontalGroup(
						gl_panelAddFriend.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelAddFriend.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnAddFriend, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
								.addContainerGap())
					);
					gl_panelAddFriend.setVerticalGroup(
						gl_panelAddFriend.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelAddFriend.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnAddFriend, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addContainerGap())
					);
					panelAddFriend.setLayout(gl_panelAddFriend);
					btnAddFriend.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnAddFriendActionPerformed(e);
						}
					});
		
		panelUnfriend = new JPanel();
		panelUnfriend.setBounds(6, 6, 418, 115);
		layeredPane.add(panelUnfriend);
		
		btnUnfriend = new JButton("Unfriend");
		btnUnfriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUnfriendActionPerformed(e);
			}
		});
		GroupLayout gl_panelUnfriend = new GroupLayout(panelUnfriend);
		gl_panelUnfriend.setHorizontalGroup(
			gl_panelUnfriend.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelUnfriend.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUnfriend, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelUnfriend.setVerticalGroup(
			gl_panelUnfriend.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUnfriend.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUnfriend, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(20))
		);
		panelUnfriend.setLayout(gl_panelUnfriend);
		contentPane.setLayout(gl_contentPane);
		
		var accountdao = new AccountDao();
		
		panelAddFriend.setVisible(true);
		panelUnfriend.setVisible(false);
		panelCancel.setVisible(false);
		
		for (String account_two : accountdao.checklistfriend(accountdao.selIDaccount(username), username)) {
			if(account_two.equals(namefriend)) {
				if(accountdao.selStatusOne(accountdao.selIDaccount(username), username, namefriend).equals("1") && accountdao.selStatusTwo(accountdao.selIDaccount(username), username, namefriend).equals("0")) {
				panelAddFriend.setVisible(false);
				panelAcceptFriend.setVisible(false);
				panelUnfriend.setVisible(false);
				panelCancel.setVisible(true);
			}else if(accountdao.selStatusOne(accountdao.selIDaccount(username), username, namefriend).equals("1") && accountdao.selStatusTwo(accountdao.selIDaccount(username), username, namefriend).equals("1")) {
				panelAddFriend.setVisible(false);
				panelAcceptFriend.setVisible(false);
				panelUnfriend.setVisible(true);
				panelCancel.setVisible(false);
			}else if(accountdao.selStatusOne(accountdao.selIDaccount(username), username, namefriend).equals("0") && accountdao.selStatusTwo(accountdao.selIDaccount(username), username, namefriend).equals("1")) {
				panelAddFriend.setVisible(false);
				panelAcceptFriend.setVisible(true);
				panelUnfriend.setVisible(false);
				panelCancel.setVisible(false);
			}
			
			}
		}
		
		var loadimage = new LoadImage(username);
		loadimage.start();

		
	}
	
	class LoadImage extends Thread{
		
		private String username;
		
		
		public LoadImage() {}
		public LoadImage(String username) {
			
			this.username = username;
		}

		@Override
		public void run() {
			var accountdao = new AccountDao();

			
				byte[] img = accountdao.SelImage(namefriend);
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblIamge.getWidth(), lblIamge.getHeight(),Image.SCALE_SMOOTH));
							
				lblIamge.setIcon(imageIcon);			
		
		}	
	}
	protected void btnAddFriendActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		
		accountdao.addfirend(accountdao.selIDaccount(username), username, namefriend, "1", "0");
		accountdao.addfirend(accountdao.selIDaccount(namefriend), namefriend, username, "0", "1");
		
		panelAddFriend.setVisible(false);
		panelAcceptFriend.setVisible(false);
		panelUnfriend.setVisible(false);
		panelCancel.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Successfully!");
		
	}
		
		
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	protected void btnUnfriendActionPerformed(ActionEvent e) {
		
		var accountdao = new AccountDao();
		
		accountdao.refuseFriend(accountdao.selIDaccount(username), username, namefriend);
		accountdao.refuseFriend(accountdao.selIDaccount(namefriend), namefriend, username);
		
		panelAddFriend.setVisible(true);
		panelAcceptFriend.setVisible(false);
		panelUnfriend.setVisible(false);
		panelCancel.setVisible(false);
		
		
		JOptionPane.showMessageDialog(null, "Successfully!");
		
	}
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		
		accountdao.refuseFriend(accountdao.selIDaccount(username), username, namefriend);
		accountdao.refuseFriend(accountdao.selIDaccount(namefriend), namefriend, username);
		
		panelAddFriend.setVisible(true);
		panelAcceptFriend.setVisible(false);
		panelUnfriend.setVisible(false);
		panelCancel.setVisible(false);
		
		
		JOptionPane.showMessageDialog(null, "Successfully!");
	}
	
	protected void btnRefuseActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		
		accountdao.refuseFriend(accountdao.selIDaccount(username), username, namefriend);
		accountdao.refuseFriend(accountdao.selIDaccount(namefriend), namefriend, username);
		
		panelAddFriend.setVisible(true);
		panelAcceptFriend.setVisible(false);
		panelUnfriend.setVisible(false);
		panelCancel.setVisible(false);
		
		
		JOptionPane.showMessageDialog(null, "Successfully!");
	}
	
	protected void btnAcceptFriendActionPerformed(ActionEvent e) {
		
		var accountdao = new AccountDao();
		
		accountdao.acceptFriend(accountdao.selIDaccount(username), username, namefriend);
		accountdao.acceptFriend(accountdao.selIDaccount(namefriend), namefriend, username);
		
		panelAddFriend.setVisible(false);
		panelAcceptFriend.setVisible(false);
		panelUnfriend.setVisible(true);
		panelCancel.setVisible(false);
					
				    	Integer random_int = null;
				        int min = 1;
				        int max = 55000;
				         portchat = (int)(Math.random() * (max - min + 1) + min);
				        
							accountdao.insertport(username, namefriend, "1", "1", portchat.toString());
					         	
		JOptionPane.showMessageDialog(null, "Successfully!");
		
	}
}
