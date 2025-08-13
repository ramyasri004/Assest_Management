package com.xtg.dao;

import java.util.List;
import java.util.Map;

import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;

public interface EntryDao {
	 public Map<String,Object> callEntryPrc(EntryFormModel entry);

	public List<SearchFormModel> callSearchPrc(Map<String, Object> inputss);

}
