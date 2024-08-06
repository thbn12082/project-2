package com.thebinh.repository.entity;

import java.sql.Date;

// phải là java bean

public class BuildingEntity {
	private int id; // id
	private String name; // tên
	private String street; // đường
	private String ward; // phường
	private Long districtid; // id huyện
	private String structure; // cấu trúc
	private int numberofbasement; // số tầng hầm
	private int floorarea; // diện tích sàn
	private String direction; // hướng 
	private String level; // hạng
	private int rentprice; // giá thuê
	private String rentpricedescription; // chú thích giá thuê 
	private String servicefee; // phí dịch vụ
	private String carfee; // phí xe hơi
	private String motorbikefee; // phí xe máy 
	private String overtimefee; // phí làm thêm giờ
	private String waterfee; // tiền nước
	private String electricityfee; // tiền điện
	private String deposit; // tiền đặt cọc
	private String payment; // thanh toán
	private String renttime; // thời gian thuê
	private String decorationtime; // thời gian decor
	private Double brokeragefee; // phí môi giới
	private String note; // chú thích
	private String linkofbuilding; // liên kết tòa nhà
	private String map; // bản đồ
	private String image; // hình ảnh
	private Date createddate; // ngày tạo
	private Date modifieddate; // ngày chỉnh sửa
	private String createdby; // tạo bởi
	private String modifiedby; // chỉnh sửa bởi
	private String managername; // tên quản lý
	private String managerphonenumber; // số điện thoại quản lý
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public int getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(int numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public int getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(int floorarea) {
		this.floorarea = floorarea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getRentprice() {
		return rentprice;
	}
	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}
	public String getRentpricedescription() {
		return rentpricedescription;
	}
	public void setRentpricedescription(String rentpricedescription) {
		this.rentpricedescription = rentpricedescription;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public String getCarfee() {
		return carfee;
	}
	public void setCarfee(String carfee) {
		this.carfee = carfee;
	}
	public String getMotorbikefee() {
		return motorbikefee;
	}
	public void setMotorbikefee(String motorbikefee) {
		this.motorbikefee = motorbikefee;
	}
	public String getOvertimefee() {
		return overtimefee;
	}
	public void setOvertimefee(String overtimefee) {
		this.overtimefee = overtimefee;
	}
	public String getWaterfee() {
		return waterfee;
	}
	public void setWaterfee(String waterfee) {
		this.waterfee = waterfee;
	}
	public String getElectricityfee() {
		return electricityfee;
	}
	public void setElectricityfee(String electricityfee) {
		this.electricityfee = electricityfee;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRenttime() {
		return renttime;
	}
	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}
	public String getDecorationtime() {
		return decorationtime;
	}
	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}
	public Double getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLinkofbuilding() {
		return linkofbuilding;
	}
	public void setLinkofbuilding(String linkofbuilding) {
		this.linkofbuilding = linkofbuilding;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	
}
// làm map 1:1 với db tên làm giống
