package com.example.springboot.dataservice2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coins")
public class Coins {

	
	 public Coins() {}

	    public Coins(String coin_ID, String coin_description,String coin_price) {
	        this.coin_ID = coin_ID;
	        this.coin_description = coin_description;
	        this.coin_price = coin_price;
	    }
	
	    @Id
		 @Column(name = "COIN_ID")
	private String coin_ID;
	    @Column(name = "COIN_DESCRIPTION")
	private String coin_description;
	    @Column(name = "VALUE")
	private String coin_price;
	
	
	public String getCoin_ID() {
		return coin_ID;
	}

	public void setCoin_ID(String coin_ID) {
		this.coin_ID = coin_ID;
	}

	public String getCoin_description() {
		return coin_description;
	}

	public void setCoin_description(String coin_description) {
		this.coin_description = coin_description;
	}

	public String getCoin_price() {
		return coin_price;
	}

	public void setCoin_price(String coin_price) {
		this.coin_price = coin_price;
	}

	
}
