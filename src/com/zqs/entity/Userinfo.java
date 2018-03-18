package com.zqs.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields


	private Integer uid;


	private String uname;
	private Integer uage;
	private String usex;
	private String uacc;
	private String upwd;
	private String uaddress;
//	private Integer rid;
//	private Integer bid;
	private Integer kid;
	private Role r;
	private Banji b;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}
  
	/** full constructor */
	public Userinfo(String uname, Integer uage, String usex, String uacc,
			String upwd, String uaddress, Role r, Banji b, Integer kid,String rname) {
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uacc = uacc;
		this.upwd = upwd;
		this.uaddress = uaddress;
		this.r = r;
		this.b = b;
		this.kid = kid;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}
    
	public Role getR() {
		return r;
	}

	public void setR(Role r) {
		this.r = r;
	}
	
	public Banji getB() {
		return b;
	}

	public void setB(Banji b) {
		this.b = b;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getUage() {
		return this.uage;
	}

	public void setUage(Integer uage) {
		this.uage = uage;
	}

	public String getUsex() {
		return this.usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUacc() {
		return this.uacc;
	}

	public void setUacc(String uacc) {
		this.uacc = uacc;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUaddress() {
		return this.uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

//	public Integer getRid() {
//		return this.rid;
//	}
//
//	public void setRid(Integer rid) {
//		this.rid = rid;
//	}
//
//	public Integer getBid() {
//		return this.bid;
//	}
//
//	public void setBid(Integer bid) {
//		this.bid = bid;
//	}

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", uage=" + uage
				+ ", usex=" + usex + ", uacc=" + uacc + ", upwd=" + upwd
				+ ", uaddress=" + uaddress + ", kid=" + kid + ", r=" + r
				+ ", b=" + b + "]";
	}

}