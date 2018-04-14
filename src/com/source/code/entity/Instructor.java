package com.source.code.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	//@NotNull(message="required field")
	//@Size(min=2,message="size should be greater than 1")
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email_id")
	private String email_id;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private Instructor_details instdetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Instructor_details getInstdetails() {
		return instdetails;
	}

	public void setInstdetails(Instructor_details instdetails) {
		this.instdetails = instdetails;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email_id=" + email_id
				+ ", instdetails=" + instdetails + "]";
	}

	public Instructor(String firstname, String lastname, String email_id) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email_id = email_id;
	}
	
	public Instructor()
	{
		System.out.println("instructor created");
	}

}
