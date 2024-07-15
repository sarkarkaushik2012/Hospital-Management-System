package com.java.hib;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ControllerInsurance {

	private Subscriptions subs = new Subscriptions();
	private SubscribeImpl impl = new SubscribeImpl();
	
	public Subscriptions getSubs() {
		return subs;
	}
	public void setSubs(Subscriptions subs) {
		this.subs = subs;
	}
	public SubscribeImpl getImpl() {
		return impl;
	}
	public void setImpl(SubscribeImpl impl) {
		this.impl = impl;
	}
	
	SessionFactory sf;
	Session session;
	
	private boolean checkPlanIDExistsInDatabase(int plan_id) {
		 
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
 
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Subscriptions.class);
			criteria.add(Restrictions.eq("plan_id", plan_id));
			List<Subscriptions> resultList = criteria.list();
 
			return !resultList.isEmpty();
		} finally {
			session.close();
		}
	}
	private boolean checkUHIDExistsInDatabase(String uhid) {
		 
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
 
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Subscriptions.class);
			criteria.add(Restrictions.eq("uhid", uhid));
			List<Subscriptions> resultList = criteria.list();
 
			return !resultList.isEmpty();
		} finally {
			session.close();
		}
	}
	private boolean checkDOBExistsInDatabase(Date dob) {
		 
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
 
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Subscriptions.class);
			criteria.add(Restrictions.eq("dob", dob));
			List<Subscriptions> resultList = criteria.list();
 
			return !resultList.isEmpty();
		} finally {
			session.close();
		}
	}
	
	//---------------------------------Working Code-------------------------------------//

	   private String planId;

	   public String getPlanId() {
	   return planId;
	   }

       public void setPlanId(String planId) {
	   this.planId = planId;
       }

		public Criteria searchByController(String planid,String uhid,Date dob) {
				
		int plan_id=0;
		if(planId.length()>0) {
			plan_id = Integer.parseInt(planid);
		}
	
		System.out.println("searchAllPlans is hiiting....");
			if((planid.length()<=0) && (uhid==null || uhid.isEmpty()) && (dob==null))  {
				 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please provide at least one search parameter.", null);
		         FacesContext.getCurrentInstance().addMessage(null, message);
		         return null;
			}
			sf = SessionHelper.getConnection();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Subscriptions.class);
			FacesContext context=FacesContext.getCurrentInstance();
			
			//----------------------------multiple search----------------------------------------//
			
			///------------------------- PLAN and DOB----------------//
			
			if(plan_id > 0 && dob!=null) {
				System.out.println("plan dob hiiting");	
				Date today = new Date();
				if (dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
			        System.out.println("Date Validation is hitting....");
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. It can't be the current date.", null));
			    }
				if (dob.after(today)) {
			        System.out.println("Date Validation is hitting....");
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. It can't be in the future.", null));
			    }
				boolean dobExists = checkDOBExistsInDatabase(dob);
				if (!dobExists) {
						 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Choose your desired date format
					     String formattedDOB = dateFormat.format(dob);
						 context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with DOB " + formattedDOB + " not found.", null));			     		
				}
				boolean pidExists = checkPlanIDExistsInDatabase(plan_id);
				if (!pidExists) {
						System.out.println("function is not working properly");
				         context.addMessage("searchform:plan_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with planId " + plan_id + " not found.", null));			     
					
				}	
				
				System.out.println("two parameter dob and plan search...");
				
				impl.searchAllPlansNew(planid, uhid, dob);
				
				Criteria criteria2 = session.createCriteria(Subscriptions.class)
				            .add(Restrictions.eq("dob", dob))
				            .add(Restrictions.eq("plan_id", plan_id));
				 
				List<Subscriptions> insList1 = criteria2.list();
				
				if (insList1.isEmpty()) {
			        // handle the case where no records are found
			        System.out.println("No records found for the specified planId and UHID.");
			        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
			        FacesContext.getCurrentInstance().addMessage(null, message);
			       
			    }
			return criteria2;
		}
				//----------------- END PLAN and DOB-------------------//
				
			   //------------------------- PLAN , UHID  and DOB----------------//
			
			if(plan_id > 0 && (uhid.length()>0 || !uhid.isEmpty() || uhid!=null ) && dob!=null) {
					sf = SessionHelper.getConnection();
					session = sf.openSession();	
					System.out.println("three parameter search...");
					
					impl.searchAllPlansNew(planid, uhid, dob);
					
					Criteria criteria3 = session.createCriteria(Subscriptions.class)
				            .add(Restrictions.eq("dob", dob))
				            .add(Restrictions.ilike("uhid", uhid, MatchMode.ANYWHERE))
				            .add(Restrictions.eq("plan_id", plan_id));
				
					List<Subscriptions> insList3 = criteria3.list();
					if (insList3.isEmpty()) {
				        // handle the case where no records are found
				        System.out.println("No records found for the specified planId , dob and UHID.");
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				        return null;
				    }
					return criteria3;
			}
			//----------------- END PLAN , UHID and DOB-------------------//			
			//------------------------PLAN and UHID-----------------------//
			if(plan_id > 0 && uhid.length()>0) {
				
				if(!uhid.matches("^IN[0-9]*$") ) {
					System.out.println("UHID is hitting...."); 
			         context.addMessage("searchform:uhid", new FacesMessage(FacesMessage.SEVERITY_ERROR, "UHID should begin with IN only", null));			     
		    	}
				boolean uhidExists = checkUHIDExistsInDatabase(uhid);
				if (!uhidExists) {
			         context.addMessage("searchform:uhid", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with uhid " + uhid + " not found.", null));			     			
				}
				boolean pidExists = checkPlanIDExistsInDatabase(plan_id);
				if (!pidExists) {
					System.out.println("function is not working properly");
			         context.addMessage("searchform:plan_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with planId " + plan_id + " not found.", null));			     				
				}
				System.out.println("two parameter plan and uhid search...");
				
				impl.searchAllPlansNew(planid, uhid, dob);
				
				Criteria criteria6 = session.createCriteria(Subscriptions.class)
			            .add(Restrictions.eq("uhid", uhid))
			            .add(Restrictions.eq("plan_id", plan_id));
				
				List<Subscriptions> insList = criteria6.list();				
				 if(insList.isEmpty()) {
				        // handle the case where no records are found in the specified date range
				        System.out.println("No records found for the specified date range.");
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				        return null;
				    }	
			return criteria;
		}			
			//-----------------------END of PLAN And UHID--------------------------------//
			
			//------------------- UHID and DOB-----------------------------//		
			if(dob!=null && uhid.length() > 0) {
				
				Date today = new Date();
				if (dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
			        System.out.println("Date today Validation is hitting....");
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. It can't be the current date.", null));
			    }
				if (dob.after(today)) {
			        System.out.println("Date next Validation is hitting....");
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. It can't be in the future.", null));
			    }
				boolean dobExists = checkDOBExistsInDatabase(dob);
				if (!dobExists) {
					 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Choose your desired date format
				     String formattedDOB = dateFormat.format(dob);
					 context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with DOB " + formattedDOB + " not found.", null));			     		
				}
				if(!uhid.matches("^IN[0-9]*$") ) {
					System.out.println("UHID is hitting...."); 
					 context.addMessage("searchform:uhid", new FacesMessage(FacesMessage.SEVERITY_ERROR, "UHID should begin with IN only", null));			     
		    	}
				boolean uhidExists = checkUHIDExistsInDatabase(uhid);
				if (!uhidExists) {
					 context.addMessage("searchform:uhid", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with uhid " + uhid + " not found.", null));	
				}
			    System.out.println("two parameters uhid and dob search...");
			    
			    impl.searchAllPlansNew(planid, uhid, dob);

			    // Create a Criteria object with the necessary restrictions
			    Criteria criteria1 = session.createCriteria(Subscriptions.class)
			            .add(Restrictions.eq("dob", dob))
			            .add(Restrictions.eq("uhid", uhid));

			    List<Subscriptions> insList2 = criteria1.list();

			    if (insList2.isEmpty()) {
			        // handle the case where no records are found
			        System.out.println("No records found for the specified date range and UHID.");
			        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
			        FacesContext.getCurrentInstance().addMessage(null, message);
			        return null;
			    }
			    return criteria1;    // Replace "successOutcome" with your actual success navigation outcome
			}
			//----------------END UHID and DOB-----------------//			
			
			//---------------------PLAN ID----------------------------------//
			if(plan_id>=0) {
				if(planid!=null && !planid.isEmpty()) {
				System.out.println("plan is hitting....");
				boolean pidExists = checkPlanIDExistsInDatabase(plan_id);
				if (!pidExists) {
					System.out.println("function is not working properly");
//					 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with plan id " + plan_id + " not found.", null);
//				        FacesContext.getCurrentInstance().addMessage("searchform:plan_id", message);
//				        return null;
			         context.addMessage("searchform:plan_id", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with plan id " + plan_id + " not found.", null));			     
				}
					System.out.println("impl method is hitting properly");
					
					impl.singleSearch(planid, uhid, dob);
				}		
			}
			//----------------------------------UHID-------------------------------------------//
			if(uhid!=null && !uhid.isEmpty()) {
				if(uhid!=null && !uhid.isEmpty()) {
				if(!uhid.matches("^IN[0-9]*$")) {
					System.out.println("UHID is hitting...."); 
					 context.addMessage("searchform:uhid",new FacesMessage(FacesMessage.SEVERITY_ERROR, "UHID should begin with IN only", null));
		    	}
				
				boolean uhidExists = checkUHIDExistsInDatabase(uhid);
				if (!uhidExists) {
					context.addMessage("searchform:uhid",new FacesMessage(FacesMessage.SEVERITY_ERROR,"Record with uhid " + uhid + " not found.", null));
				}
				impl.singleSearch(planid, uhid, dob);	
			
			}
			}
			//------------------------------DOB----------------------------------------------//
			if (dob != null) {
			    Date today = new Date();
			    
			    if (dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
			        System.out.println("Date Validation is hitting....");
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Choose your desired date format
			        String formattedDOB = dateFormat.format(dob);
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. " + formattedDOB + " It can't be the current date.", null));
			        //return null;
			    }
			    if (dob.after(today)) {
			    	
			        System.out.println("Date Validation is hitting....");
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Choose your desired date format
			        String formattedDOB = dateFormat.format(dob);
			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid DOB. " + formattedDOB + " It can't be the future date.", null));
			        //return null;
			    }
			    System.out.println("Date is hitting when there is no error.........");
			   
			    boolean dobExists = checkDOBExistsInDatabase(dob);

			    if (!dobExists) {
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Choose your desired date format
			        String formattedDOB = dateFormat.format(dob);

			        context.addMessage("searchform:dob", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record with DOB " + formattedDOB + " not found.", null));
			 
			        //return null;
			    }
			    impl.singleSearch(planid, uhid, dob);
			    //return criteria;  
			}
			////////////////////////////////////////////////////////////////////////////////////////
			return null;
		}								
	
}
