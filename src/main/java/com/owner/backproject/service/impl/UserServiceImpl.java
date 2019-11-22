package com.owner.backproject.service.impl;

import com.owner.backproject.domain.model.Result;
import com.owner.backproject.domain.model.TbUser;
import com.owner.backproject.mapper.TbUserMapper;
import com.owner.backproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Result login(TbUser tbUser) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", tbUser.getName());
		List<TbUser> list = tbUserMapper.listTbUser(params);
		Result result = new Result();
		if (list != null && list.size() > 0) {
			result.setCode(0);
			result.setMsg("登陆成功");
			result.setList(list);
			result.setObject(list.get(0));
		}else {
			result.setCode(1);
			result.setMsg("登录失败");
		}

		return result;
	}

}
