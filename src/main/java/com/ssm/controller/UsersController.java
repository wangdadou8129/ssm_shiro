package com.ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.entity.Users;
import com.ssm.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersServiceImpl;
	@Autowired
	private org.apache.shiro.web.mgt.DefaultWebSecurityManager securityManager;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Users user) {
		//Shiro判断是否成功登录
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = 
		   new UsernamePasswordToken(user.getUserName(),
				                     user.getUserPassword());
		try {
			subject.login(token);
			token.setRememberMe(true); //session中
			return "success";
		} catch (AuthenticationException e) {
			return "error";
		}
	}
}
