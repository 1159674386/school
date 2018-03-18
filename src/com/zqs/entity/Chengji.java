package com.zqs.entity;

/**
 * Chengji entity. @author MyEclipse Persistence Tools
 */

public class Chengji implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer kid;
	private Integer uid;
	private Integer score;

	// Constructors

	/** default constructor */
	public Chengji() {
	}

	/** full constructor */
	public Chengji(Integer kid, Integer uid, Integer score) {
		this.kid = kid;
		this.uid = uid;
		this.score = score;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}