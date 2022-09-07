package com.springboot;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table
public class Registration implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@NotBlank
	@Size(min = 5, message = "Username must be at least 5 characters ")
	private String username;
	@NotBlank
	@Size(min = 5, message = "Password must be at least 5 characters ")
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank(message = "Firstname is required")
	private String firstname;
	@NotBlank(message = "Lastname is required")
	private String lastname;
	@NotBlank(message = "phone is required")
	private String phone;
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="Invalid Email Address")
	private String email;
	@NotBlank(message = "city is required")
	private String city;
	@NotBlank(message = "state is required")
	private String state;
	@NotBlank(message = "zipcode is required")
	private String zipcode;

}
