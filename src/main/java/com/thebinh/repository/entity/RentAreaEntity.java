package com.thebinh.repository.entity;

import java.sql.Date;

public class RentAreaEntity {
	private Long id;
	private Long value;
	private Long buildingid;
	private Date createddate;
	private Date modifieddate;
	private String createedby;
	private String modifiedby;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Long getBuildingid() {
		return buildingid;
	}
	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
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
	public String getCreateedby() {
		return createedby;
	}
	public void setCreateedby(String createedby) {
		this.createedby = createedby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	
	
	
}
