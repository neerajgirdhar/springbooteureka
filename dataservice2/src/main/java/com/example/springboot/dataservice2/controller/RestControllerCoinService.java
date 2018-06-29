package com.example.springboot.dataservice2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dataservice2.entity.Coins;
import com.example.springboot.dataservice2.repository.CoinRepository;
import com.example.springboot.dataservice2.vo.CoinsVO;

@RestController
@RequestMapping("/coins")
@Api(value = "Coin Service")
public class RestControllerCoinService {

	private static final Logger log = LoggerFactory
			.getLogger(RestControllerCoinService.class);

	@Autowired
	private CoinRepository coinRepository;

	/*
	 * public RestControllerCoinService(CoinRepository coinRepository) {
	 * this.coinRepository = coinRepository; }
	 */

	@ApiOperation(value = "get the coin details like price and descrption of Coin by sending the Coin code", response = CoinsVO.class, produces = "application/json", httpMethod = "GET")
	@RequestMapping(method = RequestMethod.GET, path = "/{coin_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CoinsVO getCoinDetails(@PathVariable String coin_id)
			throws IOException, InterruptedException {
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<----------------CAllED WITH PORT 4203");
		log.info("coin_id---->" + coin_id);
		CoinsVO coinsVO = new CoinsVO();
		// List<Customer> customersFromDB =customerRepository.findAll();
		Coins coinFromDB = coinRepository.getOne(coin_id);

		coinsVO.setCoin_ID(coinFromDB.getCoin_ID());
		coinsVO.setCoin_description(coinFromDB.getCoin_description());
		coinsVO.setCoin_price(coinFromDB.getCoin_price());

		return coinsVO;
	}
	@ApiOperation(value = "Add the  Coin by adding Coin Code,Coin Description,Coin Price", response = Boolean.class, produces = "application/json", httpMethod = "POST")
	@RequestMapping(method = RequestMethod.POST, path = "/{coin_id}/{coin_description}/{coin_price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean addCoinDetails(@PathVariable String coin_id,
			@PathVariable String coin_description,
			@PathVariable String coin_price) throws IOException,
			InterruptedException {

		boolean success = true;

		Coins coin = new Coins();
		coin.setCoin_description(coin_description);
		coin.setCoin_ID(coin_id);
		coin.setCoin_price(coin_price);

		coinRepository.save(coin);

		return success;
	}
	
	@ApiOperation(value = "Delete the  Coin by Coin Code", response = Boolean.class, produces = "application/json", httpMethod = "DELETE")
	@RequestMapping(method = RequestMethod.DELETE, path = "/{coin_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteCustomerrDetails(@PathVariable String coin_id)
			throws IOException, InterruptedException {

		boolean success = true;
		coinRepository.deleteById(coin_id);

		return success;
	}
}
