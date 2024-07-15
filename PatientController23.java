package com.java.hib;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PatientController23 {
	private Login login;
    private LoginDAOImpl daoImpl;
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public LoginDAOImpl getDaoImpl() {
		return daoImpl;
	}
	public void setDaoImpl(LoginDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
    
	public String loginValidatePatient() {
        if (addValid()) {
            return daoImpl.loginDao(login);
        }
        return "";
    }
	
    public boolean addValid() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();

        String user = login.getUserName();
       
        boolean flag = true;

       // String pass = EncryptPassword.getCode(login.getPassword());
        System.out.println("test : "+user);
        if (login.getUserName().length() <= 0 || login.getUserName().equals("") || login.getUserName().isEmpty()) {
            context.addMessage("form:username", new FacesMessage("User name cannot be empty"));
            System.out.println("User name cannot be empty");
            sessionMap.put("cerr", "user Name cannot be empty");
            flag = false;
        }

        if (login.getPassword().length() <= 0) {
            context.addMessage("form:passInput", new FacesMessage("Password cannot be empty"));
            System.out.println("Password cannot be empty");
            sessionMap.put("cerr2", "Password cannot be empty");
            flag = false;
        }

        return flag;
    }
}
