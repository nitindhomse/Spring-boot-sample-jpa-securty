package com.procare.model;
import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "emp")
public class Employee implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String city;
	public Long getUserId() {
		return id;
	}
	public void setUserId(Long userId) {
		this.id = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
