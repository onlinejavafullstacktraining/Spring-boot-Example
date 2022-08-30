package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class UserRepository  {
    private static final String REG_INSE = "insert into registration values(?,?,?,?,?,?,?,?)";
    private static final String LOGIN_INSERT = "insert into login values(?,?,?)";
    private static final String LOGIN_LOAD = "select * from login where username=?";
    //private final JdbcTemplate jdbcTemplate;
    private MongoTemplate mongoTemplate;

    @Autowired
    public UserRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }

    /*@Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    /*public void saveRegistrationDetails(Registration registration) {
        long id = loadRandomValues();
        registration.setId(id);
        jdbcTemplate.update(REG_INSE, registration.getId(), registration.getFirstname(), registration.getLastname(), registration.getPhone(),
                registration.getEmail(), registration.getCity(), registration.getState(), registration.getZipcode());

        saveLoginDetails(registration);
    }


    private void saveLoginDetails(Registration registration) {
        long id = loadRandomValues();
        jdbcTemplate.update(LOGIN_INSERT, id, registration.getUsername(), registration.getPassword());
    }

    public Login loadUserInfoBasedOnUsername(String username) {

        Login login1 = jdbcTemplate.query(LOGIN_LOAD, (rs -> {
            Login login = new Login();
            while (rs.next()) {
                login.setId(rs.getLong(1));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
            }
            return login;
        }), username);
        return login1;
    }*/
    public void saveRegistrationDetails(Registration registration) {
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
    }
}
