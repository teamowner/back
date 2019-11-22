package com.owner.backproject.restful.userManager;

import com.owner.backproject.domain.model.Result;
import com.owner.backproject.domain.model.TbUser;
import com.owner.backproject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "用户管理相关接口")
@ResponseBody
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation("用户登录接口")
	@CrossOrigin
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public Result userLogin(@RequestBody TbUser tbUser) {

		Result result = userService.login(tbUser);
		return result;
	}
	
	@RequestMapping(value = "/userList", method = { RequestMethod.GET })
	public String user() {
		
		TbUser user = userService.userList();
		return user.toString();
	}

	
}
