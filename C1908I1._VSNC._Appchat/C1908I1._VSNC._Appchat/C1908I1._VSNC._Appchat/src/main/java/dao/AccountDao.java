package dao;

import java.security.SecureRandom;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.ZoneId;

import javax.swing.Icon;
import javax.swing.JOptionPane;


import org.mindrot.jbcrypt.BCrypt;

import common.ConnectDB;
import entity.Account;
import entity.MessageChat;
import view.UpdateAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AccountDao {
	public void insertAccount(Account acc) {
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call insAcc(?,?,?,?,?,?,?,?,?)}");
				
			)
		{
			cs.setString(1, acc.getFullname());
			cs.setString(2, acc.getAccount());
			cs.setString(3, acc.getEmail());
			cs.setString(4, acc.getPass());
			cs.setString(5, acc.getClassify());
			cs.setDate(6, Date.valueOf(acc.getDob()));
			cs.setString(7, acc.getStatus_acc());
			cs.setBytes(8, acc.getImage());
			cs.setString(9, acc.getDate_create());
			cs.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
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
					pass= rs.getString("pass");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return pass;
	}
	
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
	
	public Integer selectAccount(Account acc,  String classify , String pass) {
		
		Integer getid = null;
		
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call selAcc(?)}")
			) 
		{
			cs.setString(1, classify);
			var rs = cs.executeQuery();
			while(rs.next()) {
				classify= rs.getString("classify");
				getid = rs.getInt("id_acc");
				
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return getid;
	}
	
	public void UpdateAccount(Account acc, String cbbGender,String username) {
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call UpInfoAcc(?,?,?,?,?,?,?,?)}")
			)
		{
			
			cs.setString(1, acc.getFullname());
			cs.setDate(2,Date.valueOf( acc.getDob()));
			cs.setString(3, cbbGender);
			cs.setString(4, acc.getPhone());
			cs.setString(5,acc.getEmail());
			cs.setString(6, acc.getAddr());
			cs.setBytes(7, acc.getImage());
			cs.setString(8, username);
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update Success");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public String SelAccount(String username) {
		String account = null;
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call SelAccountAdmin(?)}")
			)
		
		{
			cs.setString(1,username);
			var rs = cs.executeQuery();
			while(rs.next()) {
				account = rs.getString("account");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public void ChangePassword(String thispassNew, String username) {
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call ChangePass(?,?)}")
			)
		
		{
			cs.setString(1, thispassNew);
			cs.setString(2, username);
			cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Integer SendCode(String email) {
	  	//random code
    	Integer random_int = null;
        int min = 10000;
        int max = 100000;
         random_int = (int)(Math.random() * (max - min + 1) + min);
        
    	
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "appchateproject@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("appchateproject@gmail.com", "Appchat12345");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("We send you a confirm code.");

            // Now set the actual message
            message.setText("Your code is "+random_int + " please do not show it to anyone! \n Thank you.");

          
            // Send message
            Transport.send(message);
         
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		return random_int;

	}
	
	public String SendPass(String email) {
	  	//random code
    	
    		// ASCII range - alphanumeric (0-9, a-z, A-Z)
    		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    		SecureRandom random = new SecureRandom();
    		StringBuilder sb = new StringBuilder();

    		// each iteration of loop choose a character randomly from the given ASCII range
    		// and append it to StringBuilder instance

    		for (int i = 0; i < 10; i++) {
    			int randomIndex = random.nextInt(chars.length());
    			sb.append(chars.charAt(randomIndex));
    		}
    		String RandomPass = sb.toString();

    		
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "appchateproject@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("appchateproject@gmail.com", "Appchat12345");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Change Password.");

            // Now set the actual message
  
            message.setText("Your password is "+RandomPass + " please do not show it to anyone! \n Thank you.");

            
            // Send message
            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		return RandomPass;

	}
	
	public void UpdatePassEmail(String pass,String email) {
		try (
				var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
				var cs = connect.prepareCall("{call UpdatePassSendMail(?,?)}");
			)
		
		{
			cs.setString(1, pass);
			cs.setString(2, email);
			
			cs.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	// check user Exist or not
		public boolean checkAcc(String account) {
			boolean user = false;
			try
			(
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call selAcc(?)}");
			)
			{
				cs.setString(1, account);
				var rs = cs.executeQuery();
			if(rs.next()) {
				user = true;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
		
		//select image
		public byte[] SelImage(String account) {
			byte[] image =null;
			try
			(
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SelImage(?)}");
			)
			{
				cs.setString(1, account);
				var rs = cs.executeQuery();
			if(rs.next()) {
				image = rs.getBytes("img");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return image;
		}
		
		public void SearchAccount(String account) {
			

			try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SearchCustomers(?)}");
					
				) {
				cs.setString(1, account);
				var rs = cs.executeQuery();
				while (rs.next()) {
					var acc = new Account();
					acc.setAccount(rs.getString("account"));
					acc.setAccount(rs.getString("account"));
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//dele account for client
		public void DelAccount(String account) {
			try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call DelAccount(?)}");
			) {
				cs.setString(1, account);
				cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		////// Code mới
		public List<Account> getListInfoAccount(String username) {
			var list = new ArrayList<Account>();

			try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call getListInfoAccount(?)}");
					
				) {
				
				cs.setString(1, username);
				var rs = cs.executeQuery();
				while (rs.next()) {
					var acc = new Account();
				
					acc.setFullname(rs.getString("fullname"));
					acc.setGender(rs.getString("gender"));
					acc.setAddr( rs.getString("addr"));
					acc.setPhone( rs.getString("phonenumber"));
					acc.setDob( rs.getDate("dob").toLocalDate());
					
					acc.setEmail(rs.getString("email"));
				
				list.add(acc);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return list;
		}
		
		//new code
		public String SelStatusAcc(String username) {
			String statusacc = null;
			try (
					var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
					var cs = connect.prepareCall("{call SelStatusAcc(?)}");
					
				)
			{
				cs.setString(1,	username);
				var rs = cs.executeQuery();
				while(rs.next()) {
					statusacc = rs.getString("status_acc");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return statusacc;
		}
		
		///vinh code
		

		
		
				// select status Friend
				public String selStatusOne(int id_acc, String account_one, String account_two) {
					String status = null;
					try
					(
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selStatusFriend(?,?,?)}");
					)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, account_one);
						cs.setString(3, account_two);
						var rs = cs.executeQuery();
					if(rs.next()) {
						status = rs.getString("status_friend_one");
						 
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return status;
				}
				
				public String selStatusTwo(int id_acc, String account_one, String account_two) {
					String status = null;
					try
					(
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selStatusFriend(?,?,?)}");
					)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, account_one);
						cs.setString(3, account_two);
						var rs = cs.executeQuery();
					if(rs.next()) {
						status = rs.getString("status_friend_two");
						 
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return status;
				}
				
				
				
				// add Friend
				public void addfirend(int id_acc, String accountone, String accounttwo, String status_one, String status_two) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call insertfriend(?,?,?,?,?)}");
							
						)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, accountone);
						cs.setString(3, accounttwo);
						cs.setString(4, status_one);
						cs.setString(5, status_two);
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				

				
				// check listfriend
				
				public ArrayList<String> checklistfriend(int id_acc, String account_one) {
					var list = new ArrayList<String>();
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selaccounttwo(?,?)}");
							
						)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, account_one);
						
						var rs = cs.executeQuery();
						while(rs.next()) {
							list.add(rs.getString("account_two"));
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
			
				// select request add friend
				public ArrayList<String> selRequestFriend(String account) {
					var list = new ArrayList<String>();
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selRequestFriend(?)}");
							
						)
					{
						cs.setString(1, account);		
						var rs = cs.executeQuery();
						while(rs.next()) {
							list.add(rs.getString("account_one"));
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return list;
				}
				
				// get list info account
				public List<Account> getListInfoAcc(String username) {
					var list = new ArrayList<Account>();

					try (var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selAcc(?)}");
							
						) {
						
						cs.setString(1, username);
						var rs = cs.executeQuery();
						while (rs.next()) {
							var acc = new Account();
							acc.setId_acc(rs.getInt("id_acc"));							
							acc.setAccount(rs.getString("account"));						
							acc.setPicture(rs.getBytes("img"));
							
						list.add(acc);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
				
				// select Friend
				public ArrayList<String> selFriend(String account) {
					var list = new ArrayList<String>();
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selFriend(?)}");
							
						)
					{
						cs.setString(1, account);		
						var rs = cs.executeQuery();
						while(rs.next()) {
							list.add(rs.getString("account_two"));
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return list;
				}
				
				// accept request add friend
				public void acceptFriend(int id_acc, String accountone, String accounttwo) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call acceptFriend(?,?,?)}");
							
						)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, accountone);
						cs.setString(3, accounttwo);
						
						
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				// Refuse==unfriend request add friend
				public void refuseFriend(int id_acc, String accountone, String accounttwo) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call refusefriend(?,?,?)}");
							
						)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, accountone);
						cs.setString(3, accounttwo);
						
						
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				// select id_acc
				public Integer selIDaccount(String account) {
					Integer user = null;
					try
					(
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selAcc(?)}");
					)
					{
						cs.setString(1, account);
						var rs = cs.executeQuery();
					if(rs.next()) {
						user = rs.getInt("id_acc");
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return user;
				}
				
				
				// update socket Friend
				public void insertSocket(String account, String socket) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call insertSocket(?,?)}");
							
						)
					{
					
						cs.setString(1, account);
						cs.setString(2, socket);
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
				
				//insert message two people
				public void InsertMess(MessageChat mess) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call InsertMess(?,?,?,?,?,?)}");
							
						)
					{
						cs.setInt(1, mess.getId_acc() );
						cs.setString(2, mess.getMessage());
						cs.setString(3, mess.getTime_send());
						cs.setString(4, mess.getAcc_one());
						cs.setString(5, mess.getAcc_two());
						cs.setString(6, mess.getStatus_mess());
					
						
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				//  select message 
				public String selMessage(Integer id_acc, String account_one, String account_two) {
					String mess = null;
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selMessage(?,?,?)}");
							
						)
					{
						cs.setInt(1, id_acc);
						cs.setString(2, account_one );
						cs.setString(3, account_two );
						
						var rs = cs.executeQuery();
						while(rs.next()) {
							mess = rs.getString("mess");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return mess;
				}
				
				
				/// insert room chat
				public void insertRoom(String nameroom, String port) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call insertroom(?,?)}");
							
						)
					{
						cs.setString(1, nameroom );
						cs.setString(2, port);
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			
				//select id room
				public Integer selIdroom(String nameroom) {
					Integer id_room = null;
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selidroom(?)}");
							
						)
					{
						cs.setString(1, nameroom );
						
						var rs = cs.executeQuery();
						while(rs.next()) {
							id_room = rs.getInt("id_room");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return id_room;
				}
				
				
				// select name room
				public String selnameRoom(String nameroom) {
					String id_room = null;
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selnamrroom(?)}");
							
						)
					{
						cs.setString(1, nameroom);
						var rs = cs.executeQuery();
						while(rs.next()) {
							id_room = rs.getString("name_room");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return id_room;
				}
				
				// select port room
				public String selPortRoom(String nameroom) {
					String id_room = null;
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selPortRoom(?)}");
							
						)
					{
						cs.setString(1, nameroom);
						var rs = cs.executeQuery();
						while(rs.next()) {
							id_room = rs.getString("portroom");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return id_room;
				}
				
				
				public void insertmemberroom(int id_room, int id_acc, String message) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call insertmemberroom(?,?,?)}");
							
						)
					{
						cs.setInt(1, id_room );
						cs.setInt(2, id_acc);
						cs.setString(3, message );
						
						
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
				// select all port room
				public ArrayList<String> selAllPortroom() {
					var list = new ArrayList<String>();
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selAllPortroom}");
							
						)
					{	
						var rs = cs.executeQuery();
						while(rs.next()) {
							list.add(rs.getString("portroom"));
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return list;
				}
				
				
				/// select port chat 
				public String selport(String account_one, String account_two) {
					String port = null;
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selport(?,?)}");
							
						)
					{
						cs.setString(1, account_one );
						cs.setString(2, account_two );
						var rs = cs.executeQuery();
						while(rs.next()) {
							port = rs.getString("portchat");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					return port;
				}
				
				
				// select all port
				public ArrayList<String> selAllport() {
					var list = new ArrayList<String>();
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call selAllport}");
							
						)
					{	
						var rs = cs.executeQuery();
						while(rs.next()) {
							list.add(rs.getString("portchat"));
						}
					
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return list;
				}
				
				
				public void insertport(String account_one, String account_two,String statusone, String statustwo, String portchat) {
					try (
							var connect = DriverManager.getConnection(ConnectDB.getConnectionUrl());
							var cs = connect.prepareCall("{call insertport(?,?,?,?,?)}");
							
						)
					{
						
				
						cs.setString(1, account_one );
						cs.setString(2, account_two );
						cs.setString(3, statusone );
						cs.setString(4, statustwo );
						cs.setString(5, portchat );
						
						
						cs.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
	
}
