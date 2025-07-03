package com.Spring.Api.Entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Sport")
public class Sport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sId;
	
	@Column(name="sport_name",length=50)
	private String sportName;
	
	@Column(name="type_of_sport",length=50)
	private String typeOfSport;
	
	@Column(name="no_of_players",length=50)
	private int noOfPlayers;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private Player player;
	
	

	
	public Sport(int sId, String sportName, String typeOfSport, int noOfPlayers,Player player) {
		super();
		this.sId = sId;
		this.sportName = sportName;
		this.typeOfSport = typeOfSport;
		this.noOfPlayers = noOfPlayers;
		this.player = player;
	}

	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getTypeOfSport() {
		return typeOfSport;
	}

	public void setTypeOfSport(String typeOfSport) {
		this.typeOfSport = typeOfSport;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

   public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Sport [sId=" + sId + ", sportName=" + sportName + ", typeOfSport=" + typeOfSport + ", noOfPlayers="
				+ noOfPlayers + ", player=" + player + "]";
	}
	
	
	
	
	
	
	
	

}
