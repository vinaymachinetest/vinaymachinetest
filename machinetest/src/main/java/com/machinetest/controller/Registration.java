package com.machinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.machinetest.dao.UserDao;
import com.machinetest.model.UserLogin;

@Controller
public class Registration {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userId") String userId,	@RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		UserLogin user = new UserLogin();
		user.setUserId(userId);
		user.setPassword(password);
		int counter = userDao.registerUser(user);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Error check  log.");
		}
		mv.setViewName("registration");
		return mv;

	}

}
