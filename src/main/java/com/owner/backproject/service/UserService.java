package com.owner.backproject.service;

import com.owner.backproject.domain.model.Result;
import com.owner.backproject.domain.model.TbUser;

public interface UserService {
	
	public TbUser userList();

    Result login(TbUser tbUser);
}
