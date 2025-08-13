package com.xtg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtg.dao.EntryDao;
import com.xtg.model.EntryFormModel;
import com.xtg.model.SearchFormModel;

@Service
public class EntryServiceImpl implements EntryService {
@Autowired
private EntryDao entryDao;

public Map<String,Object> createEntryForm(EntryFormModel entry){
	return entryDao.callEntryPrc(entry);
}

public List<SearchFormModel> getSearch(Map<String, Object> inputMapp) {
	return entryDao.callSearchPrc(inputMapp);

}

}
