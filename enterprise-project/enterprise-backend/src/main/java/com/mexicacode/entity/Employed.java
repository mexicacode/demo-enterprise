package com.mexicacode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*import jakarta.persistence.Entity;
import jakarta.persistence.Id;*/

@Entity
@Table(name="esclavos")
public class Employed {
	@Id
	@Column(name="esclavos_id")
	private Integer id;
	private String name;
	private String  lastName;
	private String mothersLastName;
	private int age;
	private String numSS;
	private String addres;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMothersLastName() {
		return mothersLastName;
	}
	public void setMothersLastName(String mothersLastName) {
		this.mothersLastName = mothersLastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNumSS() {
		return numSS;
	}
	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	//TODO toString()
	
	//TODO equals()
	
	//TODO hash()
}
