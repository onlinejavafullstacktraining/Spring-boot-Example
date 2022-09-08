package com.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public HomeController(UserRepository repository, UserService userService) {
        this.userRepository = repository;
        this.userService = userService;
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
    public String saveRegistrationInfo(@Valid Registration registration, Errors errors) throws JsonProcessingException {
        if (errors.hasErrors()) {
            return "registration";
        }
        if (registration.getPassword().equals(registration.getConfirmPassword())) {
            userService.saveRegistrationDetails(registration);
            return "/home";
        } else
            return "registration";
    }

    @RequestMapping(value = "/loadLoginInfo", method = RequestMethod.POST)
    public String saveRegistrationInfo(Login login) {
        Login login1 = userRepository.loadUserInfoBasedOnUsername(login.getUsername());
        if (Objects.nonNull(login1)) {
            return "/home";
        }
        return "redirect:/login";
    }


}
