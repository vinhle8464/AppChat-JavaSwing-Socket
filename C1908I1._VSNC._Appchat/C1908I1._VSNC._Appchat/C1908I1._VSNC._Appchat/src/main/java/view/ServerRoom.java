package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import dao.AccountDao;

public class ServerRoom {
	private int port;
	private static String username;
	private Socket socket;
	private static InetAddress host;
	private ServerSocket serversocket;
	public static ArrayList<Socket> listsocket;
	public static ArrayList<ServerRoom> listPortUser;

	public ServerRoom() {}
	public ServerRoom(int port, String account, InetAddress hostuser) {
		
		this.port = port;
		this.username = account;
		this.socket = null;
		this.host = hostuser;
		
	}
	
	public int getPort() {
		return port;
	}



	public void setPort(int port) {
		this.port = port;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}


	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
		
	public InetAddress getHost() {
		return host;
	}
	public void setHost(InetAddress host) {
		this.host = host;
	}
	
	
	public void execute() throws IOException {
		
		if(serversocket == null) {
			while(true) {
			var accoundao = new AccountDao();
			for (String port : accoundao.selAllPortroom()) {
				
				var t = new Thread() {
					@Override
					public void run() {
						try {
							var serversocket = new ServerSocket(Integer.parseInt(port));
							var write = new WriteServer();
							write.start();
							System.out.println("server is listening....." + port);
							
							while(true) {
								 socket = serversocket.accept();
								System.out.println("da ket noi" + socket);
								ServerRoom.listsocket.add(socket);
								
								var read = new ReadServer(socket);
								read.start();
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						
					}
				};
					t.start();
				
				
				
			}
			
			}
		}
			
	}
	
	public void connectserver(String username, Socket socket) {
		
		var listuser = new ArrayList<SocketUsername>();
		
		var socketusername = new SocketUsername();
		
		socketusername.setUsername(username);
		socketusername.setSk(socket);
		
		
		listuser.add(socketusername);
		System.out.println(listuser);
		
		
		
		
		
//		for (ServerRoom serverRoom : ServerRoom.listPortUser) {
//			System.out.println("socket la: " + serverRoom.getSocket() + "   \n username la:  " + serverRoom.getUsername());
//			
//		}

		
		
		
	}
	

	
	public static class SocketUsername{
	
		private Socket sk;
		private String username;
		
		public SocketUsername() {}
		
		public SocketUsername(Socket sk, String username) {
			
			this.sk = sk;
			this.username = username;
		}

		public Socket getSk() {
			return sk;
		}

		public void setSk(Socket sk) {
			this.sk = sk;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		@Override
		public String toString() {
			return "SocketUsername [sk=" + sk + ", username=" + username + "]";
		}

		
		
	}

	
	
	
	public static void main(String[] args) throws IOException {
		ServerRoom.listsocket = new ArrayList<>();
		
		var server = new ServerRoom(15797, username, host);
		server.execute();
	}
	
	
	
////read
class ReadServer extends Thread {
	private  Socket  socket;
	
	public ReadServer(Socket client	) {
		this.socket = client;
	}
	
	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(socket.getInputStream());
			while(true) {
				String sms = dis.readUTF();
				if(sms.contains("exit")) {
					
					ServerRoom.listsocket.remove(socket);
					System.out.println("ngat ket noi voi" + socket);
					dis.close();
					socket.close();
					
					continue;
					
					
				}
			
				for (Socket item : ServerRoom.listsocket) {
					if(item.getPort() != socket.getPort()) {
						
					
					DataOutputStream dos = new DataOutputStream(item.getOutputStream());
					dos.writeUTF(sms);
					}
				}
			}
		} catch (Exception e) {
			try {
				dis.close();
				socket.close();
				
			} catch (Exception e2) {
				System.out.println("ngat ket noi");
			}
		}
	}
}


////write
class WriteServer extends Thread{

	
	@Override
	public void run() {
		DataOutputStream dos = null; 
		
		var scan = new Scanner(System.in);
		
		while(true) {
			String sms = scan.nextLine();
			try {
				for (Socket item : ServerRoom.listsocket) {
					 dos = new DataOutputStream(item.getOutputStream());
					dos.writeUTF("server:" + sms);
					
					}
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		}
	}



	
	
	
}
