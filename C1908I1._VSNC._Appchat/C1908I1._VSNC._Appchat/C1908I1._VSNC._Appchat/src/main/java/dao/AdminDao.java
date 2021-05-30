package dao;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import common.ConnectDB;
import entity.Account;
import entity.MessageChat;
import view.Admin;


public class AdminDao {
	//show infomation of user
	public List<Account> getListAppChat() {
		var list = new ArrayList<Account>();

		try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call Selinfo}");
				var rs = cs.executeQuery();
			) {
			while (rs.next()) {
				var acc = new Account();
				acc.setId_acc(rs.getInt("id_acc"));
				acc.setFullname(rs.getString("fullname"));
				acc.setGender(rs.getString("gender"));
				acc.setAddr( rs.getString("addr"));
				acc.setDob( rs.getDate("dob").toLocalDate());
				acc.setPhone(rs.getString("phonenumber"));
				acc.setEmail(rs.getString("email"));
				acc.setAccount(rs.getString("account"));
				acc.setClassify(rs.getString("classify"));
				acc.setPicture(rs.getBytes("img"));
				
			list.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	////// mới
	public List<Account> getListInfoAccount(String username) {
		var list = new ArrayList<Account>();

		try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call SearchCustomers(?)}");
				
			) {
			
			cs.setString(1, username);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var acc = new Account();
				acc.setAccount(rs.getString("account"));
				acc.setPicture(rs.getBytes("img"));
			
			
			list.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
		//get list all account
				public List<Account> getListAccount() {
					var list = new ArrayList<Account>();

					try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call Selinfo}");
							var rs = cs.executeQuery();
						) {
						while (rs.next()) {
							var acc = new Account();
							acc.setId_acc(rs.getInt("id_acc"));
							acc.setFullname(rs.getString("fullname"));
							acc.setDob(rs.getDate("dob").toLocalDate());
							acc.setGender(rs.getString("gender"));
							acc.setPhone(rs.getString("phonenumber"));
							acc.setEmail(rs.getString("email"));
							acc.setAddr(rs.getString("addr"));
							acc.setClassify(rs.getString("classify"));
							acc.setDate_create(rs.getString("date_create"));
							
						list.add(acc);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					return list;
				}

		
		
		//delete account user
		public void DelAcc(int id) {
			try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call DelAcc(?)}");
			) {
				cs.setInt(1, id);
				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//add account user,admin,manager
		public void AddAccount(Account acc) {
			try (
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call AddAcc(?,?,?,?,?,?,?,?)}");
					
				)
			{
				cs.setString(1, acc.getFullname());
				
				cs.setString(2, acc.getGender());
				cs.setString(3, acc.getAddr());
				cs.setDate(4, Date.valueOf( acc.getDob()));
				cs.setString(5, acc.getPhone());
				cs.setString(6, acc.getEmail());
				cs.setString(7, acc.getAccount());
				cs.setString(8, acc.getClassify());
				
				
				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

		//update account user,admin,manager
		public void UpdateAccount(Account acc, int id) {
			try (
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call UpdateAcc(?,?,?,?,?,?,?)}")
				)
			{
				
				cs.setString(1, acc.getFullname());
				cs.setString(2, acc.getGender());
				cs.setString(3, acc.getAddr());
				cs.setDate(4,Date.valueOf( acc.getDob()));
				
				cs.setString(5, acc.getPhone());
				cs.setString(6,acc.getEmail());
				
				cs.setInt(7, id);
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Update Success");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//		get the account column in sql to catch login error and change password
		public String SelAccountAdmin(String username) {
			String account = null;
			try (
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SelAccountAdmin(?)}");
					
				)
			{
				cs.setString(1,	username);
				var rs = cs.executeQuery();
				while(rs.next()) {
					account = rs.getString("account");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return account;
		}
		
		//get the pass column in sql to catch login error
		public String SelPassAdmin(String password) {
				String pass = null;
				try (
						var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
						var cs = connect.prepareCall("{call SelPassAdmin(?)}");
						
					)
				{
					cs.setString(1,	password);
					var rs = cs.executeQuery();
					while(rs.next()) {
						pass =  rs.getString("pass");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				return pass;
				
		}
		//get the classify column in sql to catch login error
		public String SelClassifyAdmin(String classify) {
			String classi = null;
			try (
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SelClassifyAdmin(?)}");
					
				)
			{
				cs.setString(1,	classify);
				var rs = cs.executeQuery();
				while(rs.next()) {
					classi= rs.getString("classify");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return classi;
		}
		
		//show info room chat for manager
		public List<MessageChat> getListManager() {
			var list = new ArrayList<MessageChat>();

			try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SelInfoRoomChat}");
					var rs = cs.executeQuery();
				) {
				while (rs.next()) {
					var mess = new MessageChat();
					mess.setId_room(rs.getInt("id_room"));
					mess.setName_room(rs.getString("name_room"));
					mess.setStatus_room(rs.getInt("status_room"));
					mess.setId_acc( rs.getInt("id_acc"));
					
					

				list.add(mess);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;
		}
	}

