package com.java.hib;

import java.util.Collections; 
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class JsfPaginitionBeanIns {

	private static final long serialVersionUID = 1L;
	private List<Insurance_Details> cdList;
	private InsDetailsImpl queryHelper;
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
	public JsfPaginitionBeanIns() {
		queryHelper = new InsDetailsImpl();
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
	public List<Insurance_Details> getInsuranceDetList() {
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
	public void setCdList(List<Insurance_Details> cdList) {
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
		cdList = queryHelper.getListofDet(firstRow, rowsPerPage);
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
}
