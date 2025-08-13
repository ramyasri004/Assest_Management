package com.xtg.service;

import java.util.List;
import java.util.Map;

import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;


public interface EntryService {
	public Map<String,Object> createEntryForm(EntryFormModel entry);

	public List<SearchFormModel> getSearch(Map<String, Object> inputMapp);

}
