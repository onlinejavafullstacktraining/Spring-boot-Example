package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserService {

    private AlertService alertService;
    private EmailService emailService;
    private UserRepository userRepository;

    @Autowired
    public UserService(AlertService alertService, EmailService emailService, UserRepository repository){
        this.userRepository=repository;
        this.alertService=alertService;
        this.emailService=emailService;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveRegistrationDetails(Registration registration) {
        emailService.sendEmail(registration);
        alertService.sendUserAlert(registration);
        userRepository.saveRegistrationDetails(registration);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateRegistrationDetails(Registration registration) {
         userRepository.updateRegistrationDetails(registration);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Registration> getUserInfo() {
        return userRepository.getUserInfo();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Registration getUserInfo_Based_Id(long id) {
        return userRepository.getUserInfo_Based_Id(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserInfo(Registration registration) {
        userRepository.deleteUserInfo(registration);
    }
}
