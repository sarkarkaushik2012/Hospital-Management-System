package com.java.hib;

import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;




public class LoginDAOImpl implements LoginDAO{
	SessionFactory sf;
	Session session;
	
	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

//	@Override
//	public String verifyOtp(Login login) {
//		sf = SessionHelper.getConnection();
//		Session session = sf.openSession();
//		String pass = login.getDigit1()+ login.getDigit2()+ login.getDigit3()+ login.getDigit4()+
//				login.getDigit5();
//		
//		System.out.println("password from otp"+pass);
//		
//		Criteria cr = session.createCriteria(Login.class);
//		cr.add(Restrictions.eq("userName", login.getUserName()));
//		cr.add(Restrictions.eq("otp", pass));
//		cr.setProjection(Projections.rowCount());
//		long count = (long) cr.uniqueResult();
//		if(count == 1) {
//			
//			return "Demo.jsp?faces-redirect=true";
//		}
//		else {
//			Map<String,Object> sessionMap =
//					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap.put("passWordErr90", "Enter a valid OTP");
//			return "ValidateOtp.jsp?faces-redirect=true";
//		}
		
		
//	}

	@Override
	public String loginDao(Login login) {
		System.out.println("Inside login");
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName",login.getUserName()));
		cr.add(Restrictions.eq("password",login.getPassword()));
		
		cr.setProjection(Projections.rowCount());
		long count = (long) cr.uniqueResult();
		Login prov=searchLoginName(login.getUserName());
		if(count == 1) {
			String name=prov.getName();
			Map<String,Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("name", name);
			return"ProviderMenu.jsp?faces-redirect=true";
		}
		
		else {
			Map<String,Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("passWordErr4", "Enter a valid UserName and Password.");
			return "RecipientMenu.jsp?faces-redirect=true";
		}
	}

	public Login searchLoginName(String name) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", name));
		Login claim=(Login)cr.uniqueResult();
		return claim;
	}
}
