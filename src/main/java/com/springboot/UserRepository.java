package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class UserRepository  {
    private static final String REG_INSE = "insert into registration values(?,?,?,?,?,?,?,?)";
    private static final String LOGIN_INSERT = "insert into login values(?,?,?)";
    private static final String LOGIN_LOAD = "select * from login where username=?";
    //private final JdbcTemplate jdbcTemplate;
    //private MongoTemplate mongoTemplate;

    private HibernateTemplate hibernateTemplate;
    private AlertService alertService;
    private EmailService emailService;

    @Autowired
    public UserRepository(HibernateTemplate hibernateTemplate1,AlertService alertService,EmailService emailService){
        this.hibernateTemplate=hibernateTemplate1;
        this.alertService=alertService;
        this.emailService=emailService;
    }


    public void saveRegistrationDetails(Registration registration) {
        emailService.sendEmail(registration);
        alertService.sendUserAlert(registration);
        hibernateTemplate.save(registration);
        /*long id = loadRandomValues();
        registration.setId(id);
        jdbcTemplate.update(REG_INSE, registration.getId(), registration.getFirstname(), registration.getLastname(), registration.getPhone(),
                registration.getEmail(), registration.getCity(), registration.getState(), registration.getZipcode());*/

        saveLoginDetails(registration);
    }


    private void saveLoginDetails(Registration registration) {
        Login login=new Login();
        login.setUsername(registration.getUsername());
        login.setPassword(registration.getPassword());
        hibernateTemplate.save(login);
    }

    public Login loadUserInfoBasedOnUsername(String username) {

        /*Login login1 = jdbcTemplate.query(LOGIN_LOAD, (rs -> {
            Login login = new Login();
            while (rs.next()) {
                login.setId(rs.getLong(1));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
            }
            return login;
        }), username);*/
        return null;
    }
    /*public void saveRegistrationDetails(Registration registration) {
        alertService.sendUserAlert(registration);
        mongoTemplate.save(registration);
        saveLoginDetails(registration);
    }


    private void saveLoginDetails(Registration registration) {
      Login login=new Login();
      login.setUsername(registration.getUsername());
      login.setPassword(registration.getPassword());
      mongoTemplate.save(login);
    }

    public Login loadUserInfoBasedOnUsername(String username) {
        return null;

    }

    private long loadRandomValues() {
        Random random = new Random();
        long id = random.nextInt(9999);
        return id;
    }*/
    private long loadRandomValues() {
        Random random = new Random();
        long id = random.nextInt(9999);
        return id;
    }
}
