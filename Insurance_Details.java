package com.java.hib;

import java.util.Date;

public class Insurance_Details {

	private String insurance_id;
	private String insurance_Name;
	private String type;
	private Date premiumStart;
	private Date premiumEnd;
	private int minPeriod;
	private int maxPeriod;
	private Date launchDate;
	private String status;
	public Insurance_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance_Details(String insurance_id, String insurance_Name, String type, Date premiumStart,
			Date premiumEnd, int minPeriod, int maxPeriod, Date launchDate, String status) {
		super();
		this.insurance_id = insurance_id;
		this.insurance_Name = insurance_Name;
		this.type = type;
		this.premiumStart = premiumStart;
		this.premiumEnd = premiumEnd;
		this.minPeriod = minPeriod;
		this.maxPeriod = maxPeriod;
		this.launchDate = launchDate;
		this.status = status;
	}
	public String getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}
	public String getInsurance_Name() {
		return insurance_Name;
	}
	public void setInsurance_Name(String insurance_Name) {
		this.insurance_Name = insurance_Name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getPremiumStart() {
		return premiumStart;
	}
	public void setPremiumStart(Date premiumStart) {
		this.premiumStart = premiumStart;
	}
	public Date getPremiumEnd() {
		return premiumEnd;
	}
	public void setPremiumEnd(Date premiumEnd) {
		this.premiumEnd = premiumEnd;
	}
	public int getMinPeriod() {
		return minPeriod;
	}
	public void setMinPeriod(int minPeriod) {
		this.minPeriod = minPeriod;
	}
	public int getMaxPeriod() {
		return maxPeriod;
	}
	public void setMaxPeriod(int maxPeriod) {
		this.maxPeriod = maxPeriod;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Insurance_Details [insurance_id=" + insurance_id + ", insurance_Name=" + insurance_Name + ", type="
				+ type + ", premiumStart=" + premiumStart + ", premiumEnd=" + premiumEnd + ", minPeriod=" + minPeriod
				+ ", maxPeriod=" + maxPeriod + ", launchDate=" + launchDate + ", status=" + status + "]";
	}
	
	
}
