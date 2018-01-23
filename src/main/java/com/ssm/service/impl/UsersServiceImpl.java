package com.ssm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.UsersMapper;
import com.ssm.entity.Users;
import com.ssm.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	@Transactional(
			isolation=Isolation.DEFAULT,
			propagation=Propagation.SUPPORTS,
			readOnly=true
			)
	public Users login(Users user) {
		return usersMapper.login(user);
	}
}
