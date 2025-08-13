package com.xtg.dao;

import java.util.Map;
import com.xtg.model.*;
 public interface UserDao{
	
	 public Map<String,Object> callRegisterPrc(UserInfo user);
	public Map<String, Object> callLoginPrc(Map<String, Object> inputs) ;


 }