package com.xtg.model;

import java.io.Serializable;

public class EntryFormModel implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String assettype;
	private String makeandmodel;
	private String processordetails;
	private String memorydetails;
	private String operatingsystem;
	private String serialno;
	private String invoiceno;
	private String invoicedate;
	private String hardwareassetid;
	private String currentstatus;
	private String assignedto;
	private String assetloc;
	private String spareassetid;
	private String department;
	private String remarks;

	public String getAssettype() {
		return assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public String getMakeandmodel() {
		return makeandmodel;
	}

	public void setMakeandmodel(String makeandmodel) {
		this.makeandmodel = makeandmodel;
	}

	public String getProcessordetails() {
		return processordetails;
	}

	public void setProcessordetails(String processordetails) {
		this.processordetails = processordetails;
	}

	public String getMemorydetails() {
		return memorydetails;
	}

	public void setMemorydetails(String memorydetails) {
		this.memorydetails = memorydetails;
	}

	public String getOperatingsystem() {
		return operatingsystem;
	}

	public void setOperatingsystem(String operatingsystem) {
		this.operatingsystem = operatingsystem;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getHardwareassetid() {
		return hardwareassetid;
	}

	public void setHardwareassetid(String hardwareassetid) {
		this.hardwareassetid = hardwareassetid;
	}

	public String getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	public String getAssetloc() {
		return assetloc;
	}

	public void setAssetloc(String assetloc) {
		this.assetloc = assetloc;
	}

	public String getSpareassetid() {
		return spareassetid;
	}

	public void setSpareassetid(String spareassetid) {
		this.spareassetid = spareassetid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "EntryFormModel [assettype=" + assettype + ", makeandmodel=" + makeandmodel + ", processordetails="
				+ processordetails + ", memorydetails=" + memorydetails + ", operatingsystem=" + operatingsystem
				+ ", serialno=" + serialno + ", invoiceno=" + invoiceno + ", invoicedate=" + invoicedate
				+ ", hardwareassetid=" + hardwareassetid + ", currentstatus=" + currentstatus + ", assignedto="
				+ assignedto + ", assetloc=" + assetloc + ", spareassetid=" + spareassetid + ", department="
				+ department + ", remarks=" + remarks + "]";
	}

}
