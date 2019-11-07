package com.owner.backproject.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owner.backproject.domain.model.TbUser;
import com.owner.backproject.mapper.TbUserMapper;
import com.owner.backproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private TbUserMapper tbUserMapper;

	@Override
	public TbUser userList() {
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		paramsMap.put("id", 1);
		return tbUserMapper.getTbUser(paramsMap);
	}

}
