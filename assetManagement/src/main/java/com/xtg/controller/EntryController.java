package com.xtg.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xtg.manager.EntryManager;
import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class EntryController {

	@Autowired
	private EntryManager entryManager;
/*Here after the user has entered the required details, the compiler will invoke the
  createEntry method in the EntryManager class. */
	@RequestMapping(value = "/entryForm", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("EntryForm") EntryFormModel entry, Model model) throws SQLException {
		HttpSession session;
		System.out.println("EntryController:addUser");
		try {
			session = request.getSession(false);
			if (session != null && session.getId().equals(session.getAttribute("sessionId"))) {
				System.out.println("addentry called");
				System.out.println(entry.toString());
				String view = entryManager.createEntry(entry, model, request);
				return new ModelAndView(view, "Asset Type", entry.getAssettype());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("sessionexpired");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView showSearchGet(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session;
		System.out.println("EntryController:showSearchGet");
		try{
			 session = request.getSession(false);
			if(session != null && session.getId().equals(session.getAttribute("sessionId"))){
				model.addAttribute("entryResponse", "");
				session.removeAttribute("searchResultDb");
				ModelAndView mav = new ModelAndView("search"); // Model javabean view
																// jsp
				mav.addObject("search", new SearchFormModel());

				return mav;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("sessionexpired");
	}
/*This will render the Entryform to the user for entering the details.*/
	@RequestMapping(value = "/entryForm", method = RequestMethod.GET)
	public ModelAndView getEntryForm(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("EntryForm") EntryFormModel entry, Model model) throws SQLException {

		HttpSession session = request.getSession(false);
		System.out.println("EntryController:getEntryForm");
		try {
			if (session != null && session.getId().equals(session.getAttribute("sessionId"))) {
				session.removeAttribute("searchResultDb");
				session.removeAttribute("errorMsg");
				ModelAndView mav = new ModelAndView("forward:/WEB-INF/views/Entryform.jsp");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("sessionexpired");
	}

	@RequestMapping(value = "/searchresults", method = RequestMethod.POST)
	public ModelAndView getSearchResults(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("Search") SearchFormModel search, Model model) throws SQLException {
		ModelAndView mav = null;
		HttpSession session;
		System.out.println("EntryController:getSearchResults");
		try {
			session = request.getSession(false);
			if(session != null && session.getId().equals(session.getAttribute("sessionId"))){
				session.removeAttribute("searchResultDb");
				String view = entryManager.verifySearch(search, model, request);
				mav = new ModelAndView(view);
				return mav;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("sessionexpired");
	}


}
