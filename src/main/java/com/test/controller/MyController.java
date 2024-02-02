package com.test.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.entities.User;
import com.test.service.UserService;

@Controller
public class MyController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/signUpHere")
	public String signUpHere() {
		return "signup";
	}
	
	@RequestMapping("/process")
	public String process(HttpServletRequest request){
		String result="";
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		System.out.println(name+" == "+pass);
		
		Iterable<User> itr=userService.getUsers();
		Iterator<User> iterator=itr.iterator();
				
			while (iterator.hasNext()) {
				User user=iterator.next();
			if (user.getUserName().equals(name) && user.getPassword().equals(pass)) {
				result="success";
				break;
			}
			else {
				result="wrong";
			}
		}		
		return result;
		
}
	
	@RequestMapping(path="/detailsProcess",method=RequestMethod.GET)
	public String detailsProcess(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		System.out.println(name);
		String email=request.getParameter("email");
		System.out.println(email);
		long contact=Long.parseLong(request.getParameter("contact"));
		System.out.println(contact);
		String password=request.getParameter("password");
		System.out.println(password);
		
		User user=new User();
		user.setUserName(name);
		user.setEmail(email);
		user.setContact(contact);
		user.setPassword(password);
		userService.createUser(user);
		System.out.println("Successfully updated");
		return "success";
	}
}
