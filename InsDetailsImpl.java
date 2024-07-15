package com.java.hib;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

public class InsDetailsImpl {

	SessionFactory sf;
	Session session;

	
	public int countRows() {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			try {
				session.beginTransaction();
				Criteria criteria = session.createCriteria(Insurance_Details.class);
				if (criteria != null) {
					return criteria.list().size();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
 
	public List<Insurance_Details> getListofDet(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<Insurance_Details> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Insurance_Details.class);
		handlingInsSort(criteria);
		criteria.setFirstResult(firstRow);
		criteria.setMaxResults(rowCount);
		return criteria.list();
	}
	static String orderByInsuranceId = "sort";
	static String orderByInsuranceName= "sort";
	static String orderByType = "sort";
	static String orderByPremiumStart = "sort";
	static String orderByPremiumEnd = "sort";
	static String orderByLaunchDate = "sort";
	static String orderByStatus = "sort";
	
	public String sortbyInsuranceId() {
		System.out.println("orderByInsuranceId : " + orderByInsuranceId);
		if (orderByInsuranceId.length() == 4) {
			orderByInsuranceId = "asc";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		} else if (orderByInsuranceId.equals("asc")) {
			orderByInsuranceId = "desc";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
	public String sortbyInsuranceName() {
		System.out.println("orderByInsuranceName : " + orderByInsuranceName);
		if (orderByInsuranceName.length() == 4) {
			orderByInsuranceName = "asc";
			orderByInsuranceId = "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		} else if (orderByInsuranceName.equals("asc")) {
			orderByInsuranceName = "desc";
			orderByInsuranceId = "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
	public String sortbyType() {
		System.out.println("orderByType : " + orderByType);
		if (orderByType.length() == 4) {
			orderByType = "asc";
			orderByInsuranceId= "sort";
			orderByInsuranceName = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		} else if (orderByType.equals("asc")) {
			orderByType = "desc";
			orderByInsuranceId= "sort";
			orderByInsuranceName = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
	
	public String sortbyPremiumStart() {
		System.out.println("orderByPremiumStart : " + orderByPremiumStart);
		if (orderByPremiumStart.length() == 4) {
			orderByPremiumStart = "asc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		} else if (orderByPremiumStart.equals("asc")) {
			orderByPremiumStart = "desc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
	
	public String sortbyPremiumEnd() {
		System.out.println("orderByPremiumEnd : " + orderByPremiumEnd);
		if (orderByPremiumEnd.length() == 4) {
			orderByPremiumEnd = "asc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		} else if (orderByPremiumEnd.equals("asc")) {
			orderByPremiumEnd = "desc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByLaunchDate = "sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
 
	public String sortbyLaunchDate() {
		System.out.println("orderByLaunchDate : " + orderByLaunchDate);
		if (orderByLaunchDate.length() == 4) {
			orderByLaunchDate = "asc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd ="sort";
			orderByStatus = "sort";
		
		} else if (orderByLaunchDate.equals("asc")) {
			orderByLaunchDate = "desc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd ="sort";
			orderByStatus = "sort";
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
 
	public String sortbyStatus() {
		System.out.println("orderByStatus : " + orderByStatus);
		if (orderByStatus.length() == 4) {
			orderByStatus = "asc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			
		} else if (orderByStatus.equals("asc")) {
			orderByStatus = "desc";
			orderByInsuranceId = "sort";
			orderByInsuranceName= "sort";
			orderByType = "sort";
			orderByPremiumStart = "sort";
			orderByPremiumEnd = "sort";
			orderByLaunchDate = "sort";
			
		}
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}
 
	public void handlingInsSort(Criteria criteria) {
			if (orderByInsuranceId.equals("asc")) {
				System.out.println("Order by Insurance ID " + orderByInsuranceId);
				criteria.addOrder(Order.asc("insurance_id"));
			} else if (orderByInsuranceId.equals("desc")) {
				criteria.addOrder(Order.desc("insurance_id"));
			}
			if (orderByInsuranceName.equals("asc")) {
				System.out.println("Order by Insurance Name " + orderByInsuranceName);
				criteria.addOrder(Order.asc("insurance_Name"));
			} else if (orderByInsuranceName.equals("desc")) {
				criteria.addOrder(Order.desc("insurance_Name"));
			}
			else if (orderByType.equals("asc")) {
				System.out.println("Order by Type " + orderByType);
				criteria.addOrder(Order.asc("type"));
			} else if (orderByType.equals("desc")) {
				criteria.addOrder(Order.desc("type"));
			}
			else if (orderByPremiumStart.equals("asc")) {
				System.out.println("Order by Premium Start Date" + orderByPremiumStart);
				criteria.addOrder(Order.asc("premiumStart"));
			} else if (orderByPremiumStart.equals("desc")) {
				criteria.addOrder(Order.desc("premiumStart"));
			}
	
			else if (orderByPremiumEnd.equals("asc")) {
				System.out.println("Order by Premium End Date " + orderByPremiumEnd);
				criteria.addOrder(Order.asc("premiumEnd"));
			} else if (orderByPremiumEnd.equals("desc")) {
				criteria.addOrder(Order.desc("premiumEnd"));
			}
			else if (orderByLaunchDate.equals("asc")) {
				System.out.println("Order by Launch Date" + orderByLaunchDate);
				criteria.addOrder(Order.asc("launchDate"));
			} else if (orderByLaunchDate.equals("desc")) {
				criteria.addOrder(Order.desc("launchDate"));
			}
			else if (orderByStatus.equals("asc")) {
				System.out.println("Order by Status" + orderByStatus);
				criteria.addOrder(Order.asc("status"));
			} else if (orderByStatus.equals("desc")) {
				criteria.addOrder(Order.desc("status"));
			}else {
				System.out.println("done");
			}
		}
}
