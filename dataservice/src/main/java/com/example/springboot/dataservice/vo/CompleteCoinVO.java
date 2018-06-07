package com.example.springboot.dataservice.vo;

public class CompleteCoinVO {

	private String coins_TotalValue;
	public String getCoins_TotalValue() {
		return coins_TotalValue;
	}
	public void setCoins_TotalValue(String coins_TotalValue) {
		this.coins_TotalValue = coins_TotalValue;
	}
	public String getCoin_Count() {
		return coin_Count;
	}
	public void setCoin_Count(String coin_Count) {
		this.coin_Count = coin_Count;
	}
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
	private String coin_Count;
	private String coin_ID;
	private String coin_description;
	private String coin_price;

	
	
	
}
