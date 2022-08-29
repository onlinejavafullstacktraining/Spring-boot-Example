package com.springboot;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class HomeController {

	private UserRepository userRepository;

	@Autowired
	public HomeController(UserRepository repository){
		this.userRepository=repository;
	}

	@RequestMapping("/")
	public String homepage() {
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping("/registration")
	public String registrationPage(Model model) {
		model.addAttribute("registration", new Registration());
		return "registration";
	}
	@RequestMapping(value = "/saveRegistrationDetails", method = RequestMethod.POST)
	public String saveRegistrationInfo(Registration registration){
		if(registration.getPassword().equals(registration.getConfirmPassword())) {
			userRepository.saveRegistrationDetails(registration);
			return "/home";
		}else
			return "redirect:/registration";
	}

	@RequestMapping(value = "/loadLoginInfo", method = RequestMethod.POST)
	public String saveRegistrationInfo(Login login){
		Login login1 = userRepository.loadUserInfoBasedOnUsername(login.getUsername());
		if(Objects.nonNull(login1)){
			return "/home";
		}
		return "redirect:/login";
	}


}
