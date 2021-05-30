package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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
import entity.MessageChat;
import view.ChatPanel.LoadImage;
import view.ChatPanel.ReadClient;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLayeredPane;

public class ChatPanel extends JFrame {

	
	 String filename=null;
		byte[] person_image=null;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tableSearch;
	private JPanel panel;
	private JTextField txtSearch;
	private JPanel panel_1;
	private JLabel lblImage;
	private JTextArea txtMess;
	private JTextField txtChat;
	private JButton btnSend;
	private JButton btnAccount;
	private JMenuBar menuBar;
	private JButton btnChangePass;
	private JButton btnSignOut;
	private String username;
	private JPanel panel_2;
	private JLabel lblLoad;
	private JPanel panel_3;
	private JLabel lblThisImg;

//--
	private  InetAddress host;
	  int port;
	public Socket socket;
	private JButton btnDeleAcc;
	private JLayeredPane layeredPane;
	private JPanel panelSearch;
	private JPanel panelRequestFriend;
	private JScrollPane scrollPane_1;
	private JTable tableRequestFriend;
	private JPanel panelMessage;
	private JScrollPane scrollPane_2;
	private JTable tableMessage;
	private JLabel lblFriend;
	private JLabel lblAccount;
	private JLabel lblFriendChat;
	private JButton btnCreateGroup;
	private JTextField txtGroup;
	private JButton btnJoinGruop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatPanel frame = new ChatPanel(null);
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
	 * @param account 
	 */
	public ChatPanel(String account) {
	//	setUndecorated(true);
		
		username = account;
	
		setTitle("ChatPanel" );
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 822);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnAccount = new JButton("Account");
		btnAccount.setBackground(new Color(30, 144, 255));
		btnAccount.setForeground(new Color(255, 255, 255));
		btnAccount.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar.add(btnAccount);
		
		btnChangePass = new JButton("ChangPass");
		btnChangePass.setBackground(new Color(30, 144, 255));
		btnChangePass.setForeground(new Color(255, 255, 255));
		btnChangePass.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChangePass.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				btnChangePassActionPerformed(e);
			}
		});
		menuBar.add(btnChangePass);
		
		btnSignOut = new JButton("SignOut");
		btnSignOut.setBackground(new Color(30, 144, 255));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignOut.setForeground(new Color(255, 255, 255));
		btnSignOut.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				btnSignOutActionPerformed(e);
			}
		});
		
		btnDeleAcc = new JButton("DeleAcc");
		btnDeleAcc.setForeground(new Color(255, 255, 255));
		btnDeleAcc.setBackground(new Color(30, 144, 255));
		btnDeleAcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleAccActionPerformed(e);
			}
		});
		menuBar.add(btnDeleAcc);
		menuBar.add(btnSignOut);
		btnAccount.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				btnAccountActionPerformed(e);
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("logo.png").getImage());
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "YOU", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CHATTING", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel_1.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		lblImage = new JLabel("");
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblImageMouseClicked(e);
			}
		});
		
		txtMess = new JTextArea();
		txtMess.setBackground(new Color(240, 255, 255));
		
		txtChat = new JTextField();
		txtChat.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBackground(new Color(30, 144, 255));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		
		lblFriend = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMess, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFriend))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtChat, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
					.addGap(18))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFriend))
					.addGap(26)
					.addComponent(txtMess, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtChat, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(33))
		);
		panel_1.setLayout(gl_panel_1);
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		
		lblThisImg = new JLabel("");
	
		
		layeredPane = new JLayeredPane();
	
		
		lblAccount = new JLabel("New label");
		lblAccount.setText(username);
		
		btnCreateGroup = new JButton("Create Group");
		btnCreateGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateGroupActionPerformed(e);
			}
		});
		
		txtGroup = new JTextField();
		txtGroup.setColumns(10);
		
		btnJoinGruop = new JButton("Join");
		btnJoinGruop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJoinGruopActionPerformed(e);
			}
		});
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCreateGroup)
							.addGap(12)
							.addComponent(txtGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnJoinGruop)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
								.addGap(1))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblThisImg, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblAccount)
								.addGap(215))
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblThisImg, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(55)
							.addComponent(lblAccount)))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateGroup)
						.addComponent(txtGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnJoinGruop))
					.addGap(33)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		panelMessage = new JPanel();
		panelMessage.setBackground(Color.WHITE);
		panelMessage.setBounds(0, 0, 332, 460);
		layeredPane.add(panelMessage);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(Color.CYAN);
		GroupLayout gl_panelMessage = new GroupLayout(panelMessage);
		gl_panelMessage.setHorizontalGroup(
			gl_panelMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMessage.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelMessage.setVerticalGroup(
			gl_panelMessage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMessage.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableMessage = new JTable();
		tableMessage.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		tableMessage.setRowMargin(10);
		tableMessage.setRowHeight(90);
		tableMessage.setBackground(Color.CYAN);
		tableMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMessageMouseClicked(e);
			}
		});
		tableMessage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(tableMessage);
		panelMessage.setLayout(gl_panelMessage);
		
		panelRequestFriend = new JPanel();
		panelRequestFriend.setBackground(Color.WHITE);
		panelRequestFriend.setBounds(0, 0, 332, 460);
		layeredPane.add(panelRequestFriend);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.CYAN);
		GroupLayout gl_panelRequestFriend = new GroupLayout(panelRequestFriend);
		gl_panelRequestFriend.setHorizontalGroup(
			gl_panelRequestFriend.createParallelGroup(Alignment.LEADING)
				.addGap(0, 332, Short.MAX_VALUE)
				.addGroup(gl_panelRequestFriend.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelRequestFriend.setVerticalGroup(
			gl_panelRequestFriend.createParallelGroup(Alignment.LEADING)
				.addGap(0, 460, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panelRequestFriend.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		
		tableRequestFriend = new JTable();
		tableRequestFriend.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		tableRequestFriend.setRowMargin(10);
		tableRequestFriend.setRowHeight(90);
		tableRequestFriend.setBackground(Color.CYAN);
		tableRequestFriend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableRequestFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableRequestFriendMouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(tableRequestFriend);
		panelRequestFriend.setLayout(gl_panelRequestFriend);
		
		panelSearch = new JPanel();
		panelSearch.setBackground(Color.WHITE);
		panelSearch.setBounds(3, 3, 332, 460);
		layeredPane.add(panelSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.CYAN);
		
		tableSearch = new JTable();
		tableSearch.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		tableSearch.setRowMargin(10);
		tableSearch.setRowHeight(90);
		tableSearch.setBackground(Color.CYAN);
		tableSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		
		tableSearch.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tableSearch.setAutoCreateRowSorter(true);
		
		
		scrollPane.setViewportView(tableSearch);
		GroupLayout gl_panelSearch = new GroupLayout(panelSearch);
		gl_panelSearch.setHorizontalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelSearch.setVerticalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSearch.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		panelSearch.setLayout(gl_panelSearch);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});

		txtSearch.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		lblLoad = new JLabel("<html>&#128491;</html>");
		lblLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLoadMouseClicked(e);
			}
		});
//		lblLoad.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				lblLoadMouseClicked(e);
//			}
//		});
		lblLoad.setBackground(new Color(240, 255, 255));
		lblLoad.setForeground(new Color(255, 255, 255));
		lblLoad.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFriendChat = new JLabel("<html>&#128108;</html>");
		lblFriendChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFriendChatMouseClicked(e);
			}
		});
		lblFriendChat.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFriendChat.setBackground(new Color(30, 144, 255));
		lblFriendChat.setForeground(new Color(255, 255, 255));
		lblFriendChat.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFriendChat)
						.addComponent(lblLoad, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoad, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblFriendChat, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
	
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
			var dao = new AccountDao();

			
				byte[] img = dao.SelImage(username);
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblThisImg.getWidth(), lblThisImg.getHeight(),Image.SCALE_SMOOTH));
							
				lblThisImg.setIcon(imageIcon);			
			}
	}

	
// Load info account to table
	private void LoadAcc(AdminDao dao) {		
			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch (column) {
					case 0: return ImageIcon.class;
					case 1: return String.class;
					default: return String.class;
					}
				}
				};
		model.addColumn("");
		model.addColumn("");
		
		for(Account acc :dao.getListInfoAccount(txtSearch.getText())) {		
		
			model.addRow(new Object[] {new ImageIcon(new ImageIcon(acc.getImage()).getImage().getScaledInstance(140,130,Image.SCALE_SMOOTH)), acc.getAccount() });	
		}
		tableSearch.setModel(model); 
		panelSearch.setVisible(true);
		panelRequestFriend.setVisible(false);
		panelMessage.setVisible(false);
		
	}
	
	// action txtSearch
	protected void txtSearchActionPerformed(ActionEvent e) {
		if(txtSearch.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter UserName !");
		}else {AdminDao dao = new AdminDao ();
		LoadAcc (dao);}
		
		
	}
	
	// mouse click table to show info user
	protected void tableMouseClicked(MouseEvent e) {
		
		int rowindex = tableSearch.getSelectedRow();
		String friendname = tableSearch.getValueAt(rowindex,1).toString();
		
		new AddFriend(username,friendname).setVisible(true);
	
	}
	
	
	// Load info user send add friend
	private void LoadRequestFriend() {	
		
		var accountdao = new AccountDao();
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0: return ImageIcon.class;
				case 1: return String.class;
				default: return String.class;
				}
			}
			};
			
	model.addColumn("");
	model.addColumn("");
	
	for(String account :accountdao.selRequestFriend(username)) {		
	
		for(Account acc :accountdao.getListInfoAcc(account)) {		
			
			model.addRow(new Object[] {new ImageIcon(new ImageIcon(acc.getImage()).getImage().getScaledInstance(140,130,Image.SCALE_SMOOTH)), acc.getAccount() });	
		}
		
	}
	tableRequestFriend.setModel(model);  
	panelSearch.setVisible(false);
	panelMessage.setVisible(false);
	panelRequestFriend.setVisible(true);
	
}
	// button run LoadRequestFriend
	protected void lblFriendChatMouseClicked(MouseEvent e) {
		LoadRequestFriend();
	}
	
	// mosue click tableRequestFriend
	protected void tableRequestFriendMouseClicked(MouseEvent e) {
		int rowindex = tableRequestFriend.getSelectedRow();
		String friendname = tableRequestFriend.getValueAt(rowindex,1).toString();
		
		new AddFriend(username,friendname).setVisible(true);
	
	}

	
	//Load friend message
	private void LoadMessage() {	
		
		var accountdao = new AccountDao();
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0: return ImageIcon.class;
				case 1: return String.class;
				default: return String.class;
				}
			}
			};
			
	model.addColumn("");
	model.addColumn("");
	
	for(String account :accountdao.selFriend(username)) {		

		for(Account acc :accountdao.getListInfoAcc(account)) {		
			
	
			model.addRow(new Object[] {new ImageIcon(new ImageIcon(acc.getImage()).getImage().getScaledInstance(140,130,Image.SCALE_SMOOTH)), acc.getAccount() });	
		}
		
	}
	tableMessage.setModel(model);  
	panelSearch.setVisible(false);
	panelRequestFriend.setVisible(false);
	panelMessage.setVisible(true);
	
}
	
	// button run load friend message

	protected void lblLoadMouseClicked(MouseEvent e) {
		LoadMessage();
		
		
	}
	
	// mouse click table friend message
	protected void tableMessageMouseClicked(MouseEvent e) {
			
		var accountdao = new AccountDao();
		
			int rowindex = tableMessage.getSelectedRow();
			String nameFirend = tableMessage.getValueAt(rowindex,1).toString();
			lblFriend.setText(nameFirend);
			
			byte[] img = accountdao.SelImage(tableMessage.getValueAt(rowindex,1).toString());
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH));
			lblImage.setIcon(imageIcon);
			
			
			var message = new MessageChat();
			message.setId_acc(accountdao.selIDaccount(username));
			message.setMessage(txtMess.getText());
			
			LocalDateTime myObj = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = myObj.format(formatter);
	        message.setTime_send(formatDateTime);
	        message.setAcc_one(username);
	        message.setAcc_two(nameFirend);
	        message.setStatus_mess("1");
			if(txtMess.getText() != "") {
				accountdao.InsertMess(message);
			}
			txtMess.setText("");
			txtMess.append(accountdao.selMessage(accountdao.selIDaccount(username), username, nameFirend));
			DataOutputStream dos = null; 
			
//			try {
//				dos = new DataOutputStream(socket.getOutputStream());	
//				dos.writeUTF("exit");
//			} catch (Exception e2) {
//				System.out.println("Exit error!");
//			}
			 port =	Integer.parseInt(accountdao.selport(username, nameFirend).trim());
			
				try {
				
						host = InetAddress.getLocalHost();
						
						socket = new Socket(host,port);
						
						var read = new ReadClient(socket);
						read.start();
						
					
					
				} catch (Exception e2) {
					 System.out.println("Can not connect to server!");
				}
						
						}

	
	
	// click see info friend
	protected void lblImageMouseClicked(MouseEvent e) {
		
		
		new AddFriend(username,lblFriend.getText()).setVisible(true);
	}
	
	
	// button update account
	protected void btnAccountActionPerformed(ActionEvent e) {
		
		new UpdateAccount(username).setVisible(true);

	}
	
	//button change password
	protected void btnChangePassActionPerformed(ActionEvent e) {
		new ChangePass(username).setVisible(true);;
	}
	
	// button delete account
	protected void btnDeleAccActionPerformed(ActionEvent e) {
		new DeleAcc(username).setVisible(true);
		
	}
	
	
	// button Log out
	protected void btnSignOutActionPerformed(ActionEvent e) {
	DataOutputStream dos = null; 
	
		try {
			dos = new DataOutputStream(socket.getOutputStream());	
			dos.writeUTF("exit");
		} catch (Exception e2) {
			System.out.println("Exit error!");
		}
		
		this.setVisible(false);;
		new SignIn().setVisible(true);
	}
	
	//button send message
	protected void btnSendActionPerformed(ActionEvent e) {
		
		
		String name = username;
		if(txtChat.getText().equals("")) {
			
		}else {
			try {
				
				
				var write = new WriteClient(socket, name);
				write.start();
			} catch (Exception e2) {
				System.out.println("Error!");
			}
		}
		
		

	}
	

	
	///read data
	class ReadClient extends Thread {
		private  Socket  socket;
		
		public ReadClient(Socket client	) {
			this.socket = client;
		}
		
		@Override
		public void run() {
			DataInputStream dis = null;
			try {
				dis = new DataInputStream(socket.getInputStream());
				
				while(true) {
					String sms = dis.readUTF();
					txtMess.append(sms);
				}
				
			} catch (Exception e) {
				try {
					dis.close();
					socket.close();
					
				} catch (Exception e2) {
					System.out.println("Disconnect Server Read!");
				}
			}
		}
	}


	////write data
	class WriteClient extends Thread{
		private Socket socket;
		private String name;
		public WriteClient(Socket socket, String name) {
			
			this.socket = socket;
			this.name = name;
		}
		
		@Override
		public void run() {
			DataOutputStream dos = null; 
			
			
			
			try {
				//var client = new Socket(host,port);
				
				dos = new DataOutputStream(socket.getOutputStream());
				//while(true) {
					
					String sms = txtChat.getText();
					dos.writeUTF(name + ":" + sms + "\n");
					txtMess.append(name + ":" + sms + "\n");
					txtChat.setText("");
					
					
				//}
			} catch (Exception e) {
				try {
					dos.close();
					socket.close();
					
				} catch (Exception e2) {
					System.out.println("Disconnect Server Write!");
				}
			}
		}
		
		
		
	}
	protected void btnCreateGroupActionPerformed(ActionEvent e) {
	
		var accoundao = new AccountDao();
//		String nameroom = accoundao.selnameRoom();
		Integer random_int = null;
        int min = 1;
        int max = 55000;
         Integer portchat = (int) (Math.random() * (max - min + 1) + min);
         accoundao.insertRoom(txtGroup.getText(), portchat.toString());
//		if(nameroom.equals(nameroom)) {
//			JOptionPane.showConfirmDialog(null, "NameRoom is used!");
//			
//		}else {
//			
//		}
//		
	}
	protected void btnJoinGruopActionPerformed(ActionEvent e) {
		var accountdao = new AccountDao();
		
//		Integer id_room = accountdao.selIdroom(txtGroup.getText());
//		accountdao.insertmemberroom(id_room, accountdao.selIDaccount(username), null);
//		
		 Integer portroom =	Integer.parseInt(accountdao.selPortRoom(txtGroup.getText()).trim());
		
			try {
			
					host = InetAddress.getLocalHost();
					
					socket = new Socket(host,portroom);
					
					var read = new ReadClient(socket);
					read.start();
					
				
				
			} catch (Exception e2) {
				 System.out.println("Can not connect to server!");
			}	
			JOptionPane.showMessageDialog(null, "Connected to RoomChat!");
	}

	
}