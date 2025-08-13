package com.xtg.manager;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xtg.model.UserInfo;

import jakarta.servlet.http.HttpServletRequest;

public interface RegisterManager {

	public String verifyUser(String username, String password, Model model);

	public String createUser(UserInfo user, Model model,HttpServletRequest request);
}
