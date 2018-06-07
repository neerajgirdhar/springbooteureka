package com.example.springboot.dataservice2.vo;

import javax.persistence.Column;

public class CoinsVO {

	private String coin_ID;
	private String coin_description;
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
