package com.zqs.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Banji entity. @author MyEclipse Persistence Tools
 */

public class Banji implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String bname;
	private Set<Userinfo> set =new HashSet<Userinfo>();

	// Constructors

	/** default constructor */
	public Banji() {
	}

	/** full constructor */
	public Banji(String bname) {
		this.bname = bname;
		//this.set = set;
	}

	// Property accessors
    
	@Override
	public String toString() {
		return "Banji [bid=" + bid + ", bname=" + bname + "]";
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Set<Userinfo> getSet() {
		return set;
	}

	public void setSet(Set<Userinfo> set) {
		this.set = set;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

}