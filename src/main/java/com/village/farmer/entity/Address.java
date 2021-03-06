package com.village.farmer.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="careers")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Address implements Serializable {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "detail")
	private String detail;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addr")
	private Collection<Users> user = new HashSet<Users>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	private Provinces province_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Collection<Users> getUser() {
		return user;
	}

	public void setUser(Collection<Users> user) {
		this.user = user;
	}

	public Provinces getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Provinces province_id) {
		this.province_id = province_id;
	}

}
