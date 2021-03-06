package com.village.farmer.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "active")
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Roles role_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id", referencedColumnName = "id")
	private Careers position_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cred", referencedColumnName = "id")
	private Credentials cred;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addr", referencedColumnName = "id")
	private Address addr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Roles getRole_id() {
		return role_id;
	}

	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}

	public Careers getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Careers position_id) {
		this.position_id = position_id;
	}

	public Credentials getCred() {
		return cred;
	}

	public void setCred(Credentials cred) {
		this.cred = cred;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

}
