package com.xtg.model;

public class SearchFormModel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assettype ="";
	private String memorydetails = "";
	private String operatingsystem = "";
	private String serialno = "";
	private String hardwareassetid = "";
	private String currentstatus = "";
	private String assignedto = "";
	private String assetloc = "";
	private String spareassetid = "";

	public SearchFormModel() {
		super();

	}

	public String getAssettype() {
		return assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
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

	@Override
	public String toString() {
		return "SearchFormModel [assettype=" + assettype + ", memorydetails=" + memorydetails + ", operatingsystem="
				+ operatingsystem + ", serialno=" + serialno + ", hardwareassetid=" + hardwareassetid
				+ ", currentstatus=" + currentstatus + ", assignedto=" + assignedto + ", assetloc=" + assetloc
				+ ", spareassetid=" + spareassetid + "]";
	}

	

}
