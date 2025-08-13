package com.xtg.manager;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;

import jakarta.servlet.http.HttpServletRequest;

public interface EntryManager {
	public String createEntry(EntryFormModel entry, Model model,HttpServletRequest request);

	/*public String verifySearch(String assettype, String makeandmodel, String memorydetails, String operatingsystem,
			String serialno, String invoiceno, String hardwareassetid, String currentstatus, String assignedto,
			String assetloc, String spareassetid, String department, String remarks, Model model);
*/
	public String verifySearch(SearchFormModel search, Model model, HttpServletRequest request);

}
