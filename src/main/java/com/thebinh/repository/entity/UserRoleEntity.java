/*package com.thebinh.repository.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "user_role")
public class UserRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "roleid", nullable = false)
	private Long roleid;
	@Column(name = "userid", nullable = false)
	private Long userid;
	// Tại sao lại phải cmt đoạn này?? vì jpa sẽ tự động tạo và liên kết với 2 bảng userentity và roleentity
	
	
	@Column(name = "createddate")
	private Date createddate;
	@Column(name = "modifieddate")
	private Date modifieddate;
	@Column(name = "createdby")
	private String createdby;
	@Column(name = "modifiedby")
	private String modifiedby;
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserEntity user;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid")
	private RoleEntity role;
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
}
*/


// khi hocj many to many, bỏ hết luôn userroleentity