package com.cognizant.IIHT.TrainingMicroservice.model;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@NotNull
	@Column(name="user_name")
//	@Size(max=25,min=3)	
	private String userName;
	@Column(name="user_password")
	
//	@Size(max=25,min=3)
	@NotNull
	private String password;
	
	
	@Column(name="user_first_name")
//	@Size(max=25,min=3)
	@NotNull
	private String firstName;
	
	
	
	@Column(name="user_last_name")
//	@Size(max=25,min=3)
	@NotNull
	private String lastName;
	
	
	@Column(name="user_contact_number")
//	@Positive(message="Contact Number should be positive value")
	@Size(max=10,min=10)
	@NotNull
	private String contactNumber;
	
	
	
	@Column(name="user_role")
//	@Size(max=6,min=6)
	@NotNull
	private String role;
	
	
	@Column(name="user_reset_password")
	private boolean resetPassword = false;
	
	
	
	
	@Column(name="user_reset_password_date")
	private Date resetPasswordDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isResetPassword() {
		return resetPassword;
	}
	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}
	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}
	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", role=" + role + ", resetPassword="
				+ resetPassword + ", resetPasswordDate=" + resetPasswordDate + "]";
	}

	

	






}