package com.thebinh.repository.entity;

//import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "building")

public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id
	@Column(name = "name")
	private String name; // tên
	@Column(name = "street")
	private String street; // đường
	@Column(name = "ward")
	private String ward; // phường
	/*@Column(name = "districtid")
	private Long districtid; // id huyện
*/	@Column(name = "structure")
	private String structure; // cấu trúc
	@Column(name = "numberofbasement")
	private Long numberofbasement; // số tầng hầm
	@Column(name = "floorarea")
	private Long floorarea; // diện tích sàn
	@Column(name = "direction")
	private String direction; // hướng
	@Column(name = "level")
	private String level; // hạng
	@Column(name = "rentprice")
	private Long rentprice; // giá thuê
	@Column(name = "rentpricedescription")
	private String rentpricedescription; // chú thích giá thuê 
	@Column(name = "servicefee")
	private String servicefee; // phí dịch vụ
	@Column(name = "carfee")
	private String carfee; // phí xe hơi
	@Column(name = "motorbikefee")
	private String motorbikefee; // phí xe máy
	@Column(name = "overtimefee")
	private String overtimefee; // phí làm thêm giờ
	@Column(name = "waterfee")
	private String waterfee; // tiền nước
	@Column(name = "electricityfee")
	private String electricityfee; // tiền điện
	@Column(name = "deposit")
	private String deposit; // tiền đặt cọc
	@Column(name = "payment")
	private String payment; // thanh toán
	@Column(name = "renttime")
	private String renttime; // thời gian thuê
	@Column(name = "decorationtime")
	private String decorationtime; // thời gian decor
	@Column(name = "brokeragefee")
	private Long brokeragefee; // phí môi giới
	@Column(name = "note")
	private String note; // chú thích
	@Column(name = "linkofbuilding")
	private String linkofbuilding; // liên kết tòa nhà
	@Column(name = "map")
	private String map; // bản đồ
	@Column(name = "image")
	private String image; // hình ảnh
	@Column(name = "createddate")
	private Date createddate; // ngày tạo
	@Column(name = "modifieddate")
	private Date modifieddate; // ngày chỉnh sửa
	@Column(name = "createdby")
	private String createdby; // tạo bởi
	@Column(name = "modifiedby")
	private String modifiedby; // chỉnh sửa bởi
	@Column(name = "managername")
	private String managername; // tên quản lý
	@Column(name = "managerphonenumber")
	private String managerphonenumber; // số điện thoại quản lý
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	
	
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> items = new ArrayList<>();
	
	
	
	
	
	
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	
	public List<RentAreaEntity> getItems() {
		return items;
	}
	public void setItems(List<RentAreaEntity> items) {
		this.items = items;
	}
	public void setBrokeragefee(Long brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public long getId() {
		return id;
	}
	public void setId(Long l) {
		this.id = l;
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
	/*public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}*/
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public Long getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Long long1) {
		this.floorarea = (long) long1;
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
	public Long getRentprice() {
		return rentprice;
	}
	public void setRentprice(Long long1) {
		this.rentprice = (long) long1;
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
	public Long getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(long l) {
		this.brokeragefee = l;
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
