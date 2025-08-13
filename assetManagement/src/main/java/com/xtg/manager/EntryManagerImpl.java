package com.xtg.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;
import com.xtg.service.EntryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class EntryManagerImpl implements EntryManager {
	@Autowired
	private EntryService entryService;

	/* This method involes the validation of the deatils provided by the user */
	public String createEntry(EntryFormModel entry, Model model, HttpServletRequest request) {

		String entryOutMsg = null;
		String validateEntryResponse = validateEntry(entry);
		String sdate = request.getParameter(entry.getInvoicedate());

		if (sdate != null) {
			try {
				// Here we are calling the StringToDate method with the invoice
				// date as a parameter.
				Date date = StringToDate(sdate);

				String result = new SimpleDateFormat("MM-dd-yyyy").format(date);
				System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(date));
				Date resultDate = new SimpleDateFormat("MM-dd-yyyy").parse(result);
				String s = resultDate.toString();
				// Here we are setting the invoice date of the required format.
				entry.setInvoicedate(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			// Here we are intializing the entryResponse value as null.
			model.addAttribute("entryResponse", "");
			if (validateEntryResponse == null) {
				// Here we are invoking the createEntryForm method in the
				// EntryServi
				Map<String, Object> entryPrceResponse = entryService.createEntryForm(entry);
				if (entryPrceResponse != null && entryPrceResponse.get("POV_ENTRY_MSG") != null) {
					entryOutMsg = entryPrceResponse.get("POV_ENTRY_MSG").toString();
					model.addAttribute("entryResponse", entryOutMsg);
				}
			} else {
				model.addAttribute("entryResponse", validateEntryResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Entryform";
	}

	/*
	 * Here we are formatting the date format to convert it to the required
	 * format for the database.
	 */
	public Date StringToDate(String sdate) {
		try {
			// Instantiating the SimpleDateFormat class
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// Parsing the given String to Date object
			Date date = formatter.parse(sdate);
			System.out.println("Date object value: " + date);
			return date;
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * Here we are validatinf if or not the user has provided all the mandatory
	 * details.
	 */
	public String validateEntry(EntryFormModel entry) {
		try {
			if (entry.getAssettype() == null) {
				return "Asset Type required";
			} else if (entry.getMakeandmodel() == null) {
				return "Make and Model required";
			} else if (entry.getSerialno() == null) {
				return "Serial number required";
			} else if (entry.getInvoiceno() == null) {
				return "Invoice Number required";
			} else if (entry.getInvoicedate() == null) {
				return "Invoice Date required";
			} else if (entry.getHardwareassetid() == null) {
				return "Hardware AssetId required";
			} else if (entry.getCurrentstatus() == null) {
				return "Current Status required";
			} else if (entry.getAssetloc() == null) {
				return "Asset Location required";
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Exception occured";
	}

	public String verifySearch(SearchFormModel search, Model model, HttpServletRequest request) {
		String searchMsg = null;
		try {
			Map<String, Object> searchInputs = new HashMap<String, Object>();

			searchInputs.put("PIV_ASSET_TYPE", search.getAssettype());
			searchInputs.put("PIV_MEMORY_DETAILS", search.getMemorydetails());
			searchInputs.put("PIV_OPERATING_SYSTEM", search.getOperatingsystem());
			searchInputs.put("PIV_SERIAL_NO", search.getSerialno());
			searchInputs.put("PIV_HARDWARE_ASSET_ID", search.getHardwareassetid());
			searchInputs.put("PIV_CURRENT_STATUS", search.getCurrentstatus());
			searchInputs.put("PIV_ASSIGNED_TO", search.getAssignedto());
			searchInputs.put("PIV_ASSET_LOCATION", search.getAssetloc());
			searchInputs.put("PIV_SPARE_ASSET_ID", search.getSpareassetid());
			HttpSession session = request.getSession(false);
			session.removeAttribute("searchResultDb");
			List<SearchFormModel> entryPrceResponse = entryService.getSearch(searchInputs);
			if (entryPrceResponse != null && entryPrceResponse.size() > 0) {
				session.setAttribute("searchResultDb", entryPrceResponse);
				// session.setAttribute(name, value);
			} else {
				session.setAttribute("errorMsg", "No Records Exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "search";
	}
}
