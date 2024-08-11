package com.thebinh.builder;

import java.util.ArrayList;

public class BuildingSearchBuilder { 
	//đây là lớp cha
	
	
	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private Long districtid;
	private Integer numberOfBasement;
	private ArrayList<String> typeCode = new ArrayList<>();
	private String managerName;
	private String managerPhoneNumber;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long areaFrom;
	private Long areaTo;
	private Long staffId;
	// các tham số của lớp cha
	
	private BuildingSearchBuilder(Builder builder) {
		// this chính là builder
		this.name = builder.name;
		this.floorArea = builder.floorArea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtid = builder.districtid;
		this.numberOfBasement = builder.numberOfBasement;
		this.typeCode = builder.typeCode;
		this.managerName = builder.managerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.staffId = builder.staffId;
		
		
		
		//đây là constructor, this.name là tham số của lớp cha được thay đổi theo tham số của lớp con
		// hàm này chỉ dùng để set dữ liệu mà thôi, vì khi tạo 1 constructor thì phải nhập nhiều tham số, giờ thì chỉ cần nhập lớp con
		// --> clean code hơn
		
		
		
	}
	
	
	
	
	
	
	// lớp cha sẽ có các phương thức là get
	public String getName() {
		return name;
	}
	
	public Long getFloorArea() {
		return floorArea;
	}
	
	public String getWard() {
		return ward;
	}
	
	public String getStreet() {
		return street;
	}
	
	public Long getDistrictid() {
		return districtid;
	}
	
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	
	public ArrayList<String> getTypeCode() {
		return typeCode;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	
	public Long getAreaFrom() {
		return areaFrom;
	}
	
	public Long getAreaTo() {
		return areaTo;
	}
	
	public Long getStaffId() {
		return staffId;
	}
	
	
	
	public static class Builder{
		// lớp con cũng sẽ có những tham số giống hệt với lớp cha
		private String name;
		private Long floorArea;
		private String ward;
		private String street;
		private Long districtid;
		private Integer numberOfBasement;
		private ArrayList<String> typeCode = new ArrayList<>();
		private String managerName;
		private String managerPhoneNumber;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long areaFrom;
		private Long areaTo;
		private Long staffId;
		
		
		// lớp con tập trung xây dựng các phương thức set
		// đây là các constructor
		public Builder setName(String name) {
			this.name = name;
			return this;
			//this chính là những field của Builder
		}
		
		public Builder setFloorArea(Long floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		
		public Builder setDistrictcode(Long districtcode) {
			this.districtid = districtcode;
			return this;
		}
		
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		
		public Builder setTypeCode(ArrayList<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		
		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}
		
		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}
		
		public Builder setRentPriceFrom(Long rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		
		public Builder setRentPriceTo(Long rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		
		public Builder setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}
		
		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}
		
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		
		public BuildingSearchBuilder build(){
			return new BuildingSearchBuilder(this);
		}
		
	}
	
}
