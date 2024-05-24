package com.springbook.biz.user;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//VO(Value Object)
public class UserVO {
	private int u_seq;
	private String u_name;
	private String u_gender;
	private String u_id;
	private String u_pw;
	private String u_pwc;
	private String u_addr;
	private String u_email;
	private String u_phone;
	private String u_hobby;
	private String u_introduce;
	private Date u_regdate;
	
	private MultipartFile u_pic;
	private String u_filename;

	public int getU_seq() {
		return u_seq;
	}

	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_pwc() {
		return u_pwc;
	}

	public void setU_pwc(String u_pwc) {
		this.u_pwc = u_pwc;
	}

	public String getU_addr() {
		return u_addr;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_hobby() {
		return u_hobby;
	}

	public void setU_hobby(String u_hobby) {
		this.u_hobby = u_hobby;
	}

	public String getU_introduce() {
		return u_introduce;
	}

	public void setU_introduce(String u_introduce) {
		this.u_introduce = u_introduce;
	}

	@Override
	public String toString() {
		return "UserVO [u_seq=" + u_seq + ", u_name=" + u_name + ", u_gender=" + u_gender + ", u_id=" + u_id + ", u_pw="
				+ u_pw + ", u_pwc=" + u_pwc + ", u_addr=" + u_addr + ", u_email=" + u_email + ", u_phone=" + u_phone
				+ ", u_hobby=" + u_hobby + ", u_introduce=" + u_introduce + "]";
	}

	public Date getU_regdate() {
		return u_regdate;
	}

	public void setU_regdate(Date u_regdate) {
		this.u_regdate = u_regdate;
	}

	public MultipartFile getU_pic() {
		return u_pic;
	}

	public void setU_pic(MultipartFile u_pic) {
		this.u_pic = u_pic;
	}

	public String getU_filename() {
		return u_filename;
	}

	public void setU_filename(String u_filename) {
		this.u_filename = u_filename;
	}



}
