package com.springboot;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String username;
	private String password;

}
