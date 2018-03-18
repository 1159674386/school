package com.zqs.entity;

/**
 * Roletree entity. @author MyEclipse Persistence Tools
 */

public class Roletree implements java.io.Serializable {

	// Fields

	private Integer roletreeid;
	private Integer treeid;
	private Integer rid;

	// Constructors

	/** default constructor */
	public Roletree() {
	}

	/** full constructor */
	public Roletree(Integer treeid, Integer rid) {
		this.treeid = treeid;
		this.rid = rid;
	}

	// Property accessors

	public Integer getRoletreeid() {
		return this.roletreeid;
	}

	public void setRoletreeid(Integer roletreeid) {
		this.roletreeid = roletreeid;
	}

	public Integer getTreeid() {
		return this.treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

}