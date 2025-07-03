package com.Spring.Api.Entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Player_Details")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	
	@Column(name="first_Name",length =50)
	private String firstName;
	
	@Column(name="last_Name",length =50)
	private String lastName;
	
	private int age;
	
	@Column(name="Origin_of_Country",length =50)
	private String originOfCountry;
	
	@Column(name="jersey_Num",length =50)
	private int jerseyNum;
	
	@Column(name="Role",length =50)
	private String role;
	
	@Column(name="Team_Name",length =50)
	private String teamName;
	
	@OneToOne(mappedBy="player",fetch = FetchType.EAGER)
	@JsonBackReference
	private Sport sport;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOriginOfCountry() {
		return originOfCountry;
	}

	public void setOriginOfCountry(String originOfCountry) {
		this.originOfCountry = originOfCountry;
	}

	public int getJerseyNum() {
		return jerseyNum;
	}

	public void setJerseyNum(int jerseyNum) {
		this.jerseyNum = jerseyNum;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	

   

	
	


   
}
