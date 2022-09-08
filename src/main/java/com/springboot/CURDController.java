package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("CURDRequest")
public class CURDController {
    private final UserService userService;

    @Autowired
    public CURDController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "saveUserInfo", method = RequestMethod.POST)
    public @ResponseBody String saveUserInfo(@RequestBody Registration registration) {
        userService.saveRegistrationDetails(registration);
        return "success";
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.PUT)
    public String updateUserInfo(Registration registration) {
        userService.updateRegistrationDetails(registration);
        return "success";
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public @ResponseBody List<Registration> getUserInfo() {
        return userService.getUserInfo();
    }

    @RequestMapping(value = "getUserInfo/{id}", method = RequestMethod.GET)
    public @ResponseBody Registration getUserInfo_Based_Id(@PathVariable("id") long id) {
        return userService.getUserInfo_Based_Id(id);
    }

    @RequestMapping(value = "deleteUserInfo", method = RequestMethod.DELETE)
    public @ResponseBody void deleteUserInfo(@RequestBody Registration registration) {
        userService.deleteUserInfo(registration);
    }

}
