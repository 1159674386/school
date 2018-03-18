package com.zqs.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private Set<Userinfo> setUserinfo = new HashSet<Userinfo>();

	// Constructors

	
	/** default constructor */
	public Role() {
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + "]";
	}

	/** full constructor */
	public Role(String rname) {
		this.rname = rname;
		//this.setUserinfo = setUserinfo;
	}

	// Property accessors

	public Set<Userinfo> getSetUserinfo() {
		return setUserinfo;
	}

	public void setSetUserinfo(Set<Userinfo> setUserinfo) {
		this.setUserinfo = setUserinfo;
	}

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

}