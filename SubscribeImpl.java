
//-----------------------------------Backup Impl------------------------------------------//
package com.java.hib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SubscribeImpl {
	
	SessionFactory sf;
	Session session;
	
	public List<Subscriptions> showSubscription(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr=session.createCriteria(Subscriptions.class);
		List<Subscriptions> subs = cr.list();
		return subs;
	}
	
	public String showInsuranceName(String insurance_Name) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Insurance_Details.class);
		criteria.add(Restrictions.eq("insurance_Name", insurance_Name));
		
		Insurance_Details details = (Insurance_Details) criteria.uniqueResult();
		return details.getInsurance_id();
	}
	
	public String showDetails(){
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Insurance_Details.class);
		List<Subscriptions> insList = criteria.list();
		sessionMap.put("insList", insList);
		return "InsuranceDetailsShow.jsp?faces-redirect=true";
	}

	public int countRows() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();

		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Subscriptions.class);

			if (sessionMap.get("searchplans") != null) {
				int plan_id = (int) sessionMap.get("searchplans");
				criteria.add(Restrictions.eq("plan_id", plan_id));
			} else if (sessionMap.get("searchuhid") != null) {
				String uhid = (String) sessionMap.get("searchuhid");
				criteria.add(Restrictions.eq("uhid", uhid));
			} else if (sessionMap.get("searchname") != null) {
				String insurance_Name = (String) sessionMap.get("searchname");
				criteria.add(Restrictions.eq("insurance_Name", insurance_Name));
			} else if (sessionMap.get("searchdob") != null) {
				Date dob = (Date) sessionMap.get("searchdob");
				criteria.add(Restrictions.eq("dob", dob));
			}
			if (sessionMap.get("planidDuo") != null && sessionMap.get("uhidDuo") != null) {
				String uhid = (String) sessionMap.get("uhidDuo");
				int plan_id = (int) sessionMap.get("planidDuo");
				criteria.add(Restrictions.eq("uhid", uhid));
				criteria.add(Restrictions.eq("plan_id", plan_id));
			}
			if (sessionMap.get("uhidDuo1") != null && sessionMap.get("dobDuo") != null) {
				String uhid = (String) sessionMap.get("uhidDuo1");
				Date dob = (Date) sessionMap.get("dobDuo");
				criteria.add(Restrictions.eq("uhid", uhid));
				criteria.add(Restrictions.eq("dob", dob));
			}
			if (sessionMap.get("dobDuo1") != null && sessionMap.get("planDuo2") != null) {
				int plan_id = (int) sessionMap.get("planDuo2");
				Date dob = (Date) sessionMap.get("dobDuo1");
				criteria.add(Restrictions.eq("plan_id", plan_id));
				criteria.add(Restrictions.eq("dob", dob));
			}
			if (sessionMap.get("dobtrio3") != null && sessionMap.get("planidtrio3") != null
					&& sessionMap.get("uhidtrio3") != null) {
				int plan_id = (int) sessionMap.get("planidtrio3");
				String uhid = (String) sessionMap.get("uhidtrio3");
				Date dob = (Date) sessionMap.get("dobtrio3");
				criteria.add(Restrictions.eq("plan_id", plan_id));
				criteria.add(Restrictions.eq("uhid", uhid));
				criteria.add(Restrictions.eq("dob", dob));
			}

			List<Subscriptions> filteredList = criteria.list();
			return filteredList.size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}
	public Criteria searchByPlan(int plan_id) {
		System.out.println("searchByPlan is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchplans", plan_id);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("plan_id", plan_id));
		return criteria;
	}
	
	public Criteria searchByInsuranceName(String insurance_Name) {
		System.out.println("searchByName is hitting.......");
		String insuranceId=showInsuranceName(insurance_Name);
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchname", insurance_Name);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("insurance_id", insuranceId));
		return criteria;
	}
	
	public Criteria searchByUHID(String uhid) {
		System.out.println("searchByUHID is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchuhid", uhid);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("uhid", uhid));
		return criteria;
	}
	
	public Criteria searchByInsurance(String insurance_id) {
		System.out.println("searchByInsurance is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchinsurance", insurance_id);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("insurance_id", insurance_id));
		return criteria;
	}
	
	public Criteria searchByDOB(Date dob) {
		System.out.println("searchBydob is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("searchdob", dob);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("dob", dob));
		return criteria;
	}
	
	public Criteria searchByDuo(String uhid,int plan_id) {
		System.out.println("searchByDUO is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("planidDuo", plan_id);
		sessionMap.put("uhidDuo", uhid);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("uhid", uhid));
		criteria.add(Restrictions.eq("plan_id", plan_id));
		return criteria;
	}
	
	public Criteria searchByDuo1(String uhid,Date dob) {
		System.out.println("searchByDUO1 is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("dobDuo", dob);
		sessionMap.put("uhidDuo1", uhid);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("uhid", uhid));
		criteria.add(Restrictions.eq("dob", dob));
		return criteria;
	}

	public Criteria searchByDuo2(int plan_id,Date dob) {
		System.out.println("searchByDUO2 is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("dobDuo1", dob);
		sessionMap.put("planDuo2", plan_id);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("plan_id", plan_id));
		criteria.add(Restrictions.eq("dob", dob));
		return criteria;
	}
	
	public Criteria searchByTrio(int plan_id,String uhid,Date dob) {
		System.out.println("searchByTrio is hitting.......");
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("planidtrio3", plan_id);
		sessionMap.put("uhidtrio3", uhid);
		sessionMap.put("dobtrio3", dob);
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Subscriptions.class);
		criteria.add(Restrictions.eq("plan_id", plan_id));
		criteria.add(Restrictions.eq("uhid",uhid));
		criteria.add(Restrictions.eq("dob", dob));
		return criteria;
	}

						// --------------------Pagination------------------------//

	public List<Subscriptions> getListofPlans(int firstRow, int rowCount){
		JsfPaginationBean sub=new JsfPaginationBean();
	 Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 
	 if(sessionMap.get("dobtrio3")!=null && sessionMap.get("uhidtrio3")!=null && sessionMap.get("planidtrio3")!=null) {
		 System.out.println("hitting dob and uhid the method............................");
		 int plan_id=(int) sessionMap.get("planidtrio3");
		 String uhid=(String) sessionMap.get("uhidtrio3");
		 Date dob=(Date)sessionMap.get("dobtrio3");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByTrio(plan_id,uhid, dob);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	 if(sessionMap.get("dobDuo")!=null && sessionMap.get("uhidDuo1")!=null) {
		 System.out.println("hitting dob and uhid the method............................");
		 String uhid=(String) sessionMap.get("uhidDuo1");
		 Date dob=(Date)sessionMap.get("dobDuo");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByDuo1(uhid, dob);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	 if(sessionMap.get("planDuo2")!=null && sessionMap.get("dobDuo1")!=null) {
		 System.out.println("hitting dob and planId the method............................");
		 int plan_id=(int) sessionMap.get("planDuo2");
		 Date dob=(Date)sessionMap.get("dobDuo1");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByDuo2(plan_id, dob);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	 if(sessionMap.get("planidDuo")!=null && sessionMap.get("uhidDuo")!=null) {
		 System.out.println("hitting the uhid and plan id method............................");
		 String uhid=(String) sessionMap.get("uhidDuo");
		 int plan_id=(int)sessionMap.get("planidDuo");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByDuo(uhid, plan_id);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	 if(sessionMap.get("searchplans")!=null) {
		 int plan_id=(Integer)sessionMap.get("searchplans");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria criteria= searchByPlan(plan_id);
		 sub.handlingPlanSort(criteria);
		 criteria.setFirstResult(firstRow);
		 criteria.setMaxResults(rowCount);
		 List<Subscriptions> planList= criteria.list();
		 sessionMap.put("planList", planList);
		 return planList;
	 }
	 if(sessionMap.get("searchname")!=null) {
		 String insurance_Name=(String)sessionMap.get("searchname");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByInsuranceName(insurance_Name);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	 if(sessionMap.get("searchuhid")!=null) {
		 String uhid=(String)sessionMap.get("searchuhid");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByUHID(uhid);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);		
		 return planList;
		 }
	 if(sessionMap.get("searchinsurance")!=null) {
		 String insurance_id=(String)sessionMap.get("searchinsurance");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByInsurance(insurance_id);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	
	 if(sessionMap.get("searchdob")!=null) {
		 Date dob=(Date) sessionMap.get("searchdob");
		 sf= SessionHelper.getConnection();
		 session=sf.openSession();
		 List<Subscriptions> plList=null;
		 session.beginTransaction();
		 Criteria critera= searchByDOB(dob);
		 sub.handlingPlanSort(critera);
		 critera.setFirstResult(firstRow);
		 critera.setMaxResults(rowCount);
		 List<Subscriptions> planList= critera.list();
		 sessionMap.put("planList", planList);
		 return planList;
		 }
	
	 return null;
}
	//-------------------------------------Working Code-------------------------------------------------//

		public Criteria searchAllPlansNew(String planid,String uhid,Date dob) {
				
		int plan_id=0;
		if(planid.length()>0) {
			plan_id = Integer.parseInt(planid);
		}
			sf = SessionHelper.getConnection();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Subscriptions.class);
			FacesContext context=FacesContext.getCurrentInstance();
			
			//----------------------------multiple search---------------------------------------------//			
			///------------------------- PLAN and DOB----------------//
			
			if(plan_id > 0 && dob!=null) {
				System.out.println("plan dob hiiting");	
		
				System.out.println("two parameter dob and plan search...");
				sessionMap.put("dobDuo1", dob);
				sessionMap.put("planDuo2", plan_id);
				
			return criteria;
		}
				//----------------- END PLAN and DOB-------------------//
				
			   //------------------------- PLAN , UHID  and DOB----------------//
			
			if(plan_id > 0 && (uhid.length()>0 || !uhid.isEmpty() || uhid!=null ) && dob!=null) {
						
					System.out.println("three parameter search...");
					sessionMap.put("planidtrio3", plan_id);
					sessionMap.put("uhidtrio3", uhid);
					sessionMap.put("dobtrio3", dob);
	
					return criteria;
			}
				//----------------- END PLAN , UHID and DOB-------------------//			
			//--------------PLAN and UHID---------------------//
			if(plan_id > 0 && uhid.length()>0) {
			
				System.out.println("plan and uhid search hitting...");
				sessionMap.put("planidDuo", plan_id);
				sessionMap.put("uhidDuo", uhid);
			
			return criteria;
		}			
			//-----------------------END of PLAN And UHID--------------------------------//
			//------------------- UHID and DOB-----------------------------//		
			if(dob!=null && uhid.length() > 0) {
				
			    System.out.println("two parameters uhid and dob search...");
			    sessionMap.put("dobDuo", dob);
			    sessionMap.put("uhidDuo1", uhid);
			    return criteria;    // Replace "successOutcome" with your actual success navigation outcome
			}
			//----------------END UHID and DOB-----------------//			
			return null;
		}	
		//-----------------new method----------//
		public Criteria singleSearch(String planid,String uhid,Date dob) {
			int plan_id=0;
			if(planid.length()>0) {
				plan_id = Integer.parseInt(planid);
			}
				sf = SessionHelper.getConnection();
				Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Subscriptions.class);
				FacesContext context=FacesContext.getCurrentInstance();
				JsfPaginationBean jsp = new JsfPaginationBean();
				
				if(uhid!=null && !uhid.isEmpty()) {
					System.out.println("singleSearchuhid is hitting");
					sessionMap.put("searchuhid", uhid);
					}
				
				if(plan_id>=0) {
					if(planid!=null && !planid.isEmpty()) {
						System.out.println("planid is hitting");
						sessionMap.put("searchplans", plan_id);				
				}
				}
			
				if (dob != null) {
					System.out.println("singleSearch dob is hitting");
				    // Store the valid date of birth in the session map
				    sessionMap.put("searchdob", dob);
				}
				jsp.setFirstRow(0);
			return criteria;
		}
		
	 //-----------------------------------Insurance ID Button-----------------------------------//
	 public String SearchInsuranceSingle(String insurance_id) {
	   	 System.out.println("method is hitting in search");
	   	 System.out.println(insurance_id);
	        Session session = SessionHelper.getConnection().openSession();
		     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		     Criteria criteria = session.createCriteria(Insurance_Details.class);
	        criteria.add(Restrictions.eq("insurance_id", insurance_id));
	        Insurance_Details details=(Insurance_Details) criteria.uniqueResult();
	        sessionMap.put("details", details);
	        return "SingleDetail.jsp?faces-redirect=true";	                
	    }	 
	 //------------------------------------clear method----------------------------------------//
    public void clear() throws IOException {
		System.out.println("Clear");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("subImpl", null);
		 
		  ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		  ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
}