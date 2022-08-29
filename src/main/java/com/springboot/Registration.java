package com.springboot;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Registration {
	private Long id;
	private String username;
	private String password;
	private String confirmPassword;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	private String city;
	private String state;
	private String zipcode;

}
