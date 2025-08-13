package com.xtg.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtg.dao.UserDao;
import com.xtg.model.UserInfo;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
		private UserDao userDao;
	// Here we are invoking the callRegisterPrc in UserDao class
	public Map<String,Object> register(UserInfo user){
		return userDao.callRegisterPrc(user);
	}
	// Here we are invoking the callLoginPrc in UserDao class

	public Map<String,Object> loginService(Map<String, Object> inputMap){
        return userDao.callLoginPrc(inputMap);
    }

}
