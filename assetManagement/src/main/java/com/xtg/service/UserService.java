package com.xtg.service;



import com.xtg.model.UserInfo;
import java.util.Map;

public interface UserService {
	
	public Map<String,Object> register(UserInfo user);
	public Map<String,Object> loginService(Map<String, Object> inputMap);


}


