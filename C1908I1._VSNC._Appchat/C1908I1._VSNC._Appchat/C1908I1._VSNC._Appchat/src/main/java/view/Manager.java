package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.AdminDao;

import entity.Account;
import entity.MessageChat;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Manager frame = new Manager();
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
	public Manager() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(new ImageIcon("logo.png").getImage());
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblNewLabel = new JLabel("Manager all account and room chat");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("<html>🔙 </html>");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackActionPerformed(e);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
							.addGap(267))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 983, GroupLayout.PREFERRED_SIZE)
							.addGap(68))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Room", null, panel, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		panel.add(panel_2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		textField.setColumns(10);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBackground(new Color(30, 144, 255));
		btnLoad.setForeground(new Color(255, 255, 255));
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadRoomActionPerformed(e);
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(58)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLoad))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 843, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Account", null, panel_1, null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setToolTipText("");
		panel_2_1.setBorder(new TitledBorder(null, "SEARCH :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2_1);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1ActionPerformed(e);
			}
		});
		textField_1.setColumns(10);
		
		JButton btnLoad_1 = new JButton("LOAD");
		btnLoad_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadAccountActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(58)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLoad_1))
						.addGroup(gl_panel_2_1.createSequentialGroup()
							.addGap(35)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 838, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2_1.createSequentialGroup()
					.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoad_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addGap(54))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		panel_2_1.setLayout(gl_panel_2_1);
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnBackActionPerformed(MouseEvent e) {
		new SignInAdmin().setVisible(true);
		this.dispose();
	}
	// load all room chat
	private void LoadInfoRoom(AdminDao dao) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID_ROOM");
		model.addColumn("NAME_ROOM");
		model.addColumn("STATUS_ROOM");
		model.addColumn("ID_ACC");
		
		
		for(MessageChat mess :dao.getListManager()) {
			model.addRow(new Object[] {mess.getId_room(),mess.getName_room(),mess.getStatus_room(), mess.getId_acc()});	
		}
		table.setModel(model);
	}
	protected void btnLoadRoomActionPerformed(ActionEvent e) {
		AdminDao dao = new AdminDao();
		LoadInfoRoom(dao);	
	}
	// load all account
	private void LoadAcc(AdminDao dao) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id user");
		model.addColumn("fullname");
		model.addColumn("Dob");
		model.addColumn("Gender");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("Addr");
		model.addColumn("Classify");
		model.addColumn("Account creation time");	
		dao.getListAccount().forEach(
			acc -> model.addRow(new Object[] { acc.getId_acc(), acc.getFullname(), acc.getDob(), acc.getGender(), acc.getPhone(), acc.getEmail(), acc.getAddr(), acc.getClassify(), acc.getDate_create()})	
		);	
		table_1.setModel(model);
	}
	protected void btnLoadAccountActionPerformed(ActionEvent e) {
		AdminDao dao = new AdminDao();
		LoadAcc(dao);
	}
	//Search tab account
	protected void textField_1ActionPerformed(ActionEvent e) {
		String find = textField_1.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table_1.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	//Search room manager
	protected void textFieldActionPerformed(ActionEvent e) {
		String find = textField_1.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
}
