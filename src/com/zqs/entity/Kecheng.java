package com.zqs.entity;

/**
 * Kecheng entity. @author MyEclipse Persistence Tools
 */

public class Kecheng implements java.io.Serializable {

	// Fields

	private Integer kid;
	private String kname;

	// Constructors

	/** default constructor */
	public Kecheng() {
	}

	/** full constructor */
	public Kecheng(String kname) {
		this.kname = kname;
	}

	// Property accessors

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getKname() {
		return this.kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

}