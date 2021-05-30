package entity;

import java.net.Socket;
import java.time.LocalDate;
import java.util.Arrays;

public class MessageChat {

	
	private int id_mess;
	private int id_acc;
	
	private String message;
	private	String time_send;
	
	private String acc_one;
	private String acc_two;

	private String status_mess;

	private int id_room;
	private String name_room;
	private int status_room;
	
	public MessageChat() {}

	public MessageChat(int id_mess, int id_acc, String message, String time_send, String acc_one, String acc_two,
			String status_mess, int id_room, String name_room, int status_room) {
		
		this.id_mess = id_mess;
		this.id_acc = id_acc;
		this.message = message;
		this.time_send = time_send;
		this.acc_one = acc_one;
		this.acc_two = acc_two;
		this.status_mess = status_mess;
		
		this.id_room = id_room;
		this.name_room = name_room;
		this.status_room = status_room;
	}

	public int getId_mess() {
		return id_mess;
	}

	public void setId_mess(int id_mess) {
		this.id_mess = id_mess;
	}

	public int getId_acc() {
		return id_acc;
	}

	public void setId_acc(int id_acc) {
		this.id_acc = id_acc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime_send() {
		return time_send;
	}

	public void setTime_send(String formatDateTime) {
		this.time_send = formatDateTime;
	}

	public String getAcc_one() {
		return acc_one;
	}

	public void setAcc_one(String acc_one) {
		this.acc_one = acc_one;
	}

	public String getAcc_two() {
		return acc_two;
	}

	public void setAcc_two(String acc_two) {
		this.acc_two = acc_two;
	}

	public String getStatus_mess() {
		return status_mess;
	}

	public void setStatus_mess(String status_mess) {
		this.status_mess = status_mess;
	}



	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public String getName_room() {
		return name_room;
	}

	public void setName_room(String name_room) {
		this.name_room = name_room;
	}

	public int getStatus_room() {
		return status_room;
	}

	public void setStatus_room(int status_room) {
		this.status_room = status_room;
	}

	@Override
	public String toString() {
		return "MessageChat [id_mess=" + id_mess + ", id_acc=" + id_acc + ", message=" + message + ", time_send="
				+ time_send + ", acc_one=" + acc_one + ", acc_two=" + acc_two + ", status_mess=" + status_mess
				 + ", id_room=" + id_room + ", name_room=" + name_room + ", status_room="
				+ status_room + "]";
	}

}
