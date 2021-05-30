package entity;


import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.Icon;


public class Account {
	
	private int id_acc;
	private String account;
	private String fullname;
	private String pass;
	private LocalDate dob;
	private String gender;
	private String phone;
	private String email;
	private String addr;
	private byte[] picture;
	private String classify;
	private String status_acc;
	private String date_create;
	
	




	public Account() {}


	public Account(int id_acc, String account, String fullname, String pass, LocalDate dob, String gender, String phone,
			String email, String addr, byte[] picture, String classify, String status_acc, String date_create) {
		super();
		this.id_acc = id_acc;
		this.account = account;
		this.fullname = fullname;
		this.pass = pass;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.picture = picture;
		this.classify = classify;
		this.status_acc = status_acc;
		this.date_create = date_create;
	}





	public int getId_acc() {
		return id_acc;
	}

	public void setId_acc(int id_acc) {
		this.id_acc = id_acc;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public byte[] getImage() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getStatus_acc() {
		return status_acc;
	}

	public void setStatus_acc(String status_acc) {
		this.status_acc = status_acc;
	}
	
	public String getDate_create() {
		return date_create;
	}


	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	
	@Override
	public String toString() {
		return "Account [id_acc=" + id_acc + ", account=" + account + ", fullname=" + fullname + ", pass=" + pass
				+ ", dob=" + dob + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", addr=" + addr
				+ ", picture=" + Arrays.toString(picture) + "]";
	}
	
	
	
	
	
}
