package com.zqs.entity;

/**
 * Tree entity. @author MyEclipse Persistence Tools
 */

public class Tree implements java.io.Serializable {

	// Fields

	private Integer treeid;
	private String name;
	private String path;
	private Integer pid;
	private String open;

	// Constructors

	/** default constructor */
	public Tree() {
	}

	/** full constructor */
	public Tree(String name, String path, Integer pid, String open) {
		this.name = name;
		this.path = path;
		this.pid = pid;
		this.open = open;
	}

	// Property accessors

	public Integer getTreeid() {
		return this.treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getOpen() {
		return this.open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

}