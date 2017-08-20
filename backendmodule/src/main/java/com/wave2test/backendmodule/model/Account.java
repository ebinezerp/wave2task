package com.wave2test.backendmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"userName"}))
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long accountId;
	@NotNull
	@NotBlank
	@Pattern(regexp="[a-z]{2,10}",message="only small alphabet, Min 2 and Max 10 characters")
	private String firstName;
	@NotNull
	@NotBlank
	@Pattern(regexp="[a-z]{5,10}",message="only small alphabet, Min 5 and Max 10 characters")
	private String lastName;
	@NotNull
	@NotBlank
	@Pattern(regexp="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$",message="enter a valid email")
	private String email;
	@NotNull
	@NotBlank
	@Pattern(regexp="^[789]\\d{9}$",message="enter a valid Mobile Number")
	private String mobile;
	@NotNull
	@NotBlank
	@Pattern(regexp="[a-z]{8,}",message="small alphabet, Min 8 characters")
	@Column(unique = true)
	private String userName;
	@NotNull
	@NotBlank
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}",message="Min 8 characters Max 10 characters,Atleast one small, one capital alphabet,one digit and one special character")
	private String password;
	@Transient
	private String cpassword;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + ", userName=" + userName + ", password=" + password + ", cpassword="
				+ cpassword + "]";
	}

	
	
}
