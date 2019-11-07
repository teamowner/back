package com.owner.backproject.restful.userManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.owner.backproject.domain.model.TbUser;
import com.owner.backproject.service.UserService;


@RestController
@ResponseBody
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userList", method = { RequestMethod.GET })
	public String user() {
		
		TbUser user = userService.userList();
		return user.toString();
	}

	
}
