package com.java.hib;

import java.util.Date;

public class Subscriptions {
		
	private String uhid;
	private int subscription_Id;
	private int plan_id;
	private String insurance_id;
	private double premium_Amount;
	private double coverage_Amount;
	private String payMode;
	private String email;
	private Date registrationDate;
	private double initial_Amount;
	private String status;
	private Date dob;
	public Subscriptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscriptions(String uhid, int subscription_Id, int plan_id, String insurance_id, double premium_Amount,
			double coverage_Amount, String payMode, String email, Date registrationDate, double initial_Amount,
			String status, Date dob) {
		super();
		this.uhid = uhid;
		this.subscription_Id = subscription_Id;
		this.plan_id = plan_id;
		this.insurance_id = insurance_id;
		this.premium_Amount = premium_Amount;
		this.coverage_Amount = coverage_Amount;
		this.payMode = payMode;
		this.email = email;
		this.registrationDate = registrationDate;
		this.initial_Amount = initial_Amount;
		this.status = status;
		this.dob = dob;
	}
	public String getUhid() {
		return uhid;
	}
	public void setUhid(String uhid) {
		this.uhid = uhid;
	}
	public int getSubscription_Id() {
		return subscription_Id;
	}
	public void setSubscription_Id(int subscription_Id) {
		this.subscription_Id = subscription_Id;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}
	public double getPremium_Amount() {
		return premium_Amount;
	}
	public void setPremium_Amount(double premium_Amount) {
		this.premium_Amount = premium_Amount;
	}
	public double getCoverage_Amount() {
		return coverage_Amount;
	}
	public void setCoverage_Amount(double coverage_Amount) {
		this.coverage_Amount = coverage_Amount;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public double getInitial_Amount() {
		return initial_Amount;
	}
	public void setInitial_Amount(double initial_Amount) {
		this.initial_Amount = initial_Amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
