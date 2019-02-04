package com.newpractical.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newpractical.application.dao.UserDao;
import com.newpractical.application.model.JsonUser;
import com.newpractical.application.model.UserBean;

@RestController
public class UserController {
	
	@Autowired
	UserDao ud;
	
	@CrossOrigin
	@RequestMapping(value = "/authenticate",  method= RequestMethod.POST)
	public JsonUser Authenticate(@RequestParam("userName")String username,@RequestParam("password")String password){
		String status=ud.AuthenticateUser(username,password);
		//System.out.println(status);
		JsonUser ju=new JsonUser("status",status);
		return ju;
	}
}
