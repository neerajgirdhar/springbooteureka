package com.example.springboot.dataservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private String username;
	@Column(name = "COINS")
	private String coins;

	public Customer() {
	}

	public Customer(String username, String coins) {
		this.username = username;
		this.coins = coins;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCoins() {
		return coins;
	}

	public void setCoins(String coins) {
		this.coins = coins;
	}

}
