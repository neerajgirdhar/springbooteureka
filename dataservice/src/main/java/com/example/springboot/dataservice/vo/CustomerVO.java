package com.example.springboot.dataservice.vo;

import java.util.List;

public class CustomerVO {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

	private String totalValue;

	public List<CompleteCoinVO> getCompleteCoinVO() {
		return completeCoinVO;
	}

	public void setCompleteCoinVO(List<CompleteCoinVO> completeCoinVO) {
		this.completeCoinVO = completeCoinVO;
	}

	private List<CompleteCoinVO> completeCoinVO;

}
