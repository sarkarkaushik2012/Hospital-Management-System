package com.java.hib;

import java.util.Collections; 
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class JsfPaginationBeanSubs {

	private static final long serialVersionUID = 1L;
	private List<Subscriptions> cdList;
	private SubscribeDataImpl queryHelper;
	/**
	 * pagination stuff
	 */
	private int totalRows;
	static private int firstRow;
	private int rowsPerPage;
	private int totalPages;
	private int pageRange;
	private Integer[] pages;
	private int currentPage;
	
	/**
	 * Creates a new instance of JsfPaginationBean
	 */
	public JsfPaginationBeanSubs() {
		queryHelper = new SubscribeDataImpl();
		/**
		 * the below function should not be called in real world application
		 */
		// Set default values somehow (properties files?).
		rowsPerPage = 12; // Default rows per page (max amount of rows to be displayed at once).
		pageRange = 8; // Default page range (max amount of page links to be displayed at once).
	}
//	public List<Subscriptions> getListofPlans() {
//		if (cdList == null) {
//			loadInsurance();
//		}
//		return cdList;
//	}
	public List<Subscriptions> getSubsDataList() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		sessionMap.put(insurance_Name, insurance_Name);
//		cdList=null;
		if (cdList == null) {
			loadInsurance();
		}
		else if(cdList.isEmpty() || cdList.size()==0) {
			sessionMap.put("NotFound", "No Records Found");
		}
	
		return cdList;
	}
	public void setCdList(List<Subscriptions> cdList) {
		this.cdList = cdList;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		
		
   	this.rowsPerPage = rowsPerPage;
    }	
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageRange() {
		return pageRange;
	}
	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	public Integer[] getPages() {
		return pages;
	}
	public void setPages(Integer[] pages) {
		this.pages = pages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private void loadInsurance() {
		 
		if
		(rowsPerPage>0) {
		System.out.println("First Row  " +firstRow);
		System.out.println("Count  " +rowsPerPage);
		cdList = queryHelper.getListofSubsData(firstRow, rowsPerPage);
		System.out.println("plans Count is  " + cdList);
		totalRows = queryHelper.countRows();
		System.out.println("Total Rows  " +totalRows);
		// Set currentPage, totalPages and pages.
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];
		// firstPage must be greater than 0 and lesser than totalPages-pageLength.
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);
		// Create pages (page numbers for page links).
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
		}
		}else {
			 System.out.println("not available");
		}
		}
	// Paging actions
	// -----------------------------------------------------------------------------
	public void pageFirst() {
//		if (rowsPerPage<=0) {
//			FacesContext context = FacesContext.getCurrentInstance();
//	        context.addMessage("searchform:rowsPerPage", new FacesMessage("This should not be negative or zero"));
//	    }
		page(0);
	}
	public void pageNext() {
		page(firstRow + rowsPerPage);
	}
	public void pagePrevious() {
		page(firstRow - rowsPerPage);
	}
	public void pageLast() {
		page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
	}
	public void page(ActionEvent event) {
		page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
	}
	private void page(int firstRow) {
		this.firstRow = firstRow;
		loadInsurance();
	}
	
	static String orderByUHID = "sort";
	static String orderBySubscriptionId= "sort";
	static String orderByPlanId = "sort";
	static String orderByInsuranceId = "sort";
	static String orderByPremiumAmount = "sort";
	static String orderByCoverageAmount = "sort";
	static String orderByInitialAmount = "sort";
	static String orderByPaymentMode = "sort";
	static String orderByEmail = "sort";
	static String orderByRegistrationDate = "sort";
	static String orderByStatus = "sort";
	static String orderByDOB = "sort";
	
	public String sortbyUHID() {
		System.out.println("orderByUHID : " + orderByUHID);
		if (orderByUHID.length() == 4) {
			orderByUHID = "asc";
			orderBySubscriptionId= "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
 
		} else if (orderByUHID.equals("asc")) {
			orderByUHID = "desc";
			orderBySubscriptionId= "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbySubscriptionID() {
		System.out.println("orderBySubscriptionId : " + orderBySubscriptionId);
		if (orderBySubscriptionId.length() == 4) {
			orderBySubscriptionId = "asc";
			orderByPlanId = "sort";
			orderByUHID = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		} else if (orderBySubscriptionId.equals("asc")) {
			orderBySubscriptionId = "desc";
			orderByPlanId = "sort";
			orderByUHID = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyPlanID() {
		System.out.println("orderByPlanId : " + orderByPlanId);
		if (orderByPlanId.length() == 4) {
			orderByPlanId = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		} else if (orderByPlanId.equals("asc")) {
			orderByPlanId = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	
	public String sortbyInsuranceID() {
		System.out.println("orderByInsuranceId : " + orderByInsuranceId);
		if (orderByInsuranceId.length() == 4) {
			orderByInsuranceId = "asc";
			orderBySubscriptionId= "sort";
			orderByPlanId = "sort";
			orderByUHID = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		} else if (orderByInsuranceId.equals("asc")) {
			orderByInsuranceId = "desc";
			orderBySubscriptionId= "sort";
			orderByPlanId = "sort";
			orderByUHID = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	
	public String sortbyPremiumAmount() {
		System.out.println("orderByPremiumAmount : " + orderByPremiumAmount);
		if (orderByPremiumAmount.length() == 4) {
			orderByPremiumAmount = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
 
		} else if (orderByPremiumAmount.equals("asc")) {
			orderByPremiumAmount = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
 
	public String sortbyCoverageAmount() {
		System.out.println("orderByCoverageAmount : " + orderByCoverageAmount);
		if (orderByCoverageAmount.length() == 4) {
			orderByCoverageAmount = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		
		} else if (orderByCoverageAmount.equals("asc")) {
			orderByCoverageAmount = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
 
	public String sortbyEmail() {
		System.out.println("orderByEmail : " + orderByEmail);
		if (orderByEmail.length() == 4) {
			orderByEmail = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
			
		} else if (orderByEmail.equals("asc")) {
			orderByEmail = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByPaymentMode = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
			
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyPayment() {
		System.out.println("orderByPaymentMode : " + orderByPaymentMode);
		if (orderByPaymentMode.length() == 4) {
			orderByPaymentMode = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
			
		} else if (orderByPaymentMode.equals("asc")) {
			orderByPaymentMode = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyStatus() {
		System.out.println("orderByStatus : " + orderByStatus);
		if (orderByStatus.length() == 4) {
			orderByStatus = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByPaymentMode = "sort";
			orderByDOB = "sort";
			
		} else if (orderByStatus.equals("asc")) {
			orderByStatus = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByPaymentMode = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyRegistrationDate() {
		System.out.println("orderByRegistrationDate : " + orderByRegistrationDate);
		if (orderByRegistrationDate.length() == 4) {
			orderByRegistrationDate = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByPaymentMode = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
			
		} else if (orderByRegistrationDate.equals("asc")) {
			orderByRegistrationDate = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByCoverageAmount = "sort";
			orderByPremiumAmount = "sort";
			orderByInitialAmount = "sort";
			orderByEmail = "sort";
			orderByPaymentMode = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyInitialAmount() {
		System.out.println("orderByInitialAmount : " + orderByInitialAmount);
		if (orderByInitialAmount.length() == 4) {
			orderByInitialAmount = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
			
		} else if (orderByInitialAmount.equals("asc")) {
			orderByInitialAmount = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByDOB = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
	public String sortbyDOB() {
		System.out.println("orderByDOB : " + orderByDOB);
		if (orderByDOB.length() == 4) {
			orderByDOB = "asc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByInitialAmount = "sort";
			
		} else if (orderByDOB.equals("asc")) {
			orderByDOB = "desc";
			orderBySubscriptionId= "sort";
			orderByUHID = "sort";
			orderByPlanId = "sort";
			orderByInsuranceId = "sort";
			orderByPremiumAmount = "sort";
			orderByCoverageAmount = "sort";
			orderByPaymentMode = "sort";
			orderByEmail = "sort";
			orderByRegistrationDate = "sort";
			orderByStatus = "sort";
			orderByInitialAmount = "sort";
		}
		return "Show.jsp?faces-redirect=true";
	}
 
	public void handlingPlanSort(Criteria criteria) {
			if (orderByUHID.equals("asc")) {
				System.out.println("Order by UHID " + orderByUHID);
				criteria.addOrder(Order.asc("uhid"));
			} else if (orderByUHID.equals("desc")) {
				criteria.addOrder(Order.desc("uhid"));
			}
			if (orderBySubscriptionId.equals("asc")) {
				System.out.println("Order by Subscription ID " + orderBySubscriptionId);
				criteria.addOrder(Order.asc("subscription_Id"));
			} else if (orderBySubscriptionId.equals("desc")) {
				criteria.addOrder(Order.desc("subscription_Id"));
			}
			else if (orderByPlanId.equals("asc")) {
				System.out.println("Order by plan id " + orderByPlanId);
				criteria.addOrder(Order.asc("plan_id"));
			} else if (orderByPlanId.equals("desc")) {
				criteria.addOrder(Order.desc("plan_id"));
			}
			
			else if (orderByInsuranceId.equals("asc")) {
				System.out.println("Order by Insurance Id " + orderByInsuranceId);
				criteria.addOrder(Order.asc("insurance_id"));
			} else if (orderByInsuranceId.equals("desc")) {
				criteria.addOrder(Order.desc("insurance_id"));
			}
	
			else if (orderByPremiumAmount.equals("asc")) {
				System.out.println("Order by Date" + orderByPremiumAmount);
				criteria.addOrder(Order.asc("admit_date"));
			} else if (orderByPremiumAmount.equals("desc")) {
				criteria.addOrder(Order.desc("admit_date"));
			}
	
			else if (orderByCoverageAmount.equals("asc")) {
				System.out.println("Order by Coverage Amount " + orderByCoverageAmount);
				criteria.addOrder(Order.asc("coverage_Amount"));
			} else if (orderByCoverageAmount.equals("desc")) {
				criteria.addOrder(Order.desc("coverage_Amount"));
			}
			else if (orderByPaymentMode.equals("asc")) {
				System.out.println("Order by Payment Mode" + orderByPaymentMode);
				criteria.addOrder(Order.asc("payMode"));
			} else if (orderByPaymentMode.equals("desc")) {
				criteria.addOrder(Order.desc("payMode"));
			}
			else if (orderByEmail.equals("asc")) {
				System.out.println("Order by Email" + orderByEmail);
				criteria.addOrder(Order.asc("email"));
			} else if (orderByEmail.equals("desc")) {
				criteria.addOrder(Order.desc("email"));
			}
			else if (orderByRegistrationDate.equals("asc")) {
				System.out.println("Order by Registration Date" + orderByRegistrationDate);
				criteria.addOrder(Order.asc("registrationDate"));
			} else if (orderByRegistrationDate.equals("desc")) {
				criteria.addOrder(Order.desc("registrationDate"));
			}
			else if (orderByStatus.equals("asc")) {
				System.out.println("Order by Status" + orderByStatus);
				criteria.addOrder(Order.asc("status"));
			} else if (orderByStatus.equals("desc")) {
				criteria.addOrder(Order.desc("status"));
			}
			else if (orderByInitialAmount.equals("asc")) {
				System.out.println("Order by initial amount" + orderByInitialAmount);
				criteria.addOrder(Order.asc("initial_Amount"));
			} else if (orderByInitialAmount.equals("desc")) {
				criteria.addOrder(Order.desc("initial_Amount"));
			}
			else if (orderByDOB.equals("asc")) {
				System.out.println("Order by DOB" + orderByDOB);
				criteria.addOrder(Order.asc("dob"));
			} else if (orderByDOB.equals("desc")) {
				criteria.addOrder(Order.desc("dob"));
			}else {
				System.out.println("done");
			}
		}
}
