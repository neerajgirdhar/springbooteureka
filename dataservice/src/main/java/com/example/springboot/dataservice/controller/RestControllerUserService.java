package com.example.springboot.dataservice.controller;

import io.swagger.annotations.Api;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.dataservice.entity.Customer;
import com.example.springboot.dataservice.repository.CustomerRepository;
import com.example.springboot.dataservice.vo.CoinsVO;
import com.example.springboot.dataservice.vo.CompleteCoinVO;
import com.example.springboot.dataservice.vo.CustomerVO;

//@EnableEurekaClient
@RestController
@RequestMapping("/users")
@Api(value="users")
public class RestControllerUserService {

	private static final Logger log = LoggerFactory.getLogger(RestControllerUserService.class);

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LoadBalancerClient loadBalancer;
	

	/*
	public void setLoadBalancer(LoadBalancerClient loadBalancer) {
		this.loadBalancer = loadBalancer;
	}


	

	
	public RestControllerUserService(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	//	this.lbRestTemplate =lbRestTemplate;
	}*/
	
	
	 @RequestMapping(method = RequestMethod.GET, path = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public CustomerVO getCustomerrDetails(@PathVariable String userName) throws  IOException, InterruptedException {
		 
		 log.info("USERName---->"+userName);
		 CustomerVO customer = new CustomerVO();
		// List<Customer> customersFromDB =customerRepository.findAll();
		 Customer customersFromDB = customerRepository.getOne(userName);
		
				 
		 customer.setUsername(customersFromDB.getUsername());
		 String coins =customersFromDB.getCoins();
		 int grossValueOfPortfolio =0;
		    
		 StringTokenizer strTokenizer = new StringTokenizer(coins, ",");
		 
		 List<CompleteCoinVO> list = new ArrayList<>();
		 int grossPriceOfPortfolio =0;
		 while(strTokenizer.hasMoreElements())
		 {
			 String coinDetails =(String) strTokenizer.nextElement();
			 String[] splitArray = coinDetails.split(":");
			RestTemplate restTemplate = new RestTemplate();
			// String url = "http://localhost:4201/coins/get/"+splitArray[0];
			
			 ServiceInstance instance = loadBalancer.choose("coinService");
	
			 URI uri = instance.getUri();
			 
			 
			 log.info(uri.toString());
			 
			
			 String url1 = String.format("%s%s/"+splitArray[0], uri,"/coins");
			log.info("url1---->"+url1);
			
			 CoinsVO coinVO = restTemplate.getForObject(url1, CoinsVO.class);
			 CompleteCoinVO  completeCoinVO = new CompleteCoinVO();
			 completeCoinVO.setCoin_Count(splitArray[1]);
			 completeCoinVO.setCoin_description(coinVO.getCoin_description());
			 completeCoinVO.setCoin_ID(coinVO.getCoin_ID());
			 completeCoinVO.setCoin_price(coinVO.getCoin_price());
			 int coins_TotalValue =0;
			 coins_TotalValue = Integer.parseInt(splitArray[1])*Integer.parseInt(coinVO.getCoin_price());
			 completeCoinVO.setCoins_TotalValue(coins_TotalValue+"USD");
			 grossPriceOfPortfolio = grossPriceOfPortfolio+coins_TotalValue;
			 list.add(completeCoinVO);
		 }
		 customer.setUsername(customersFromDB.getUsername());
		 customer.setTotalValue(grossPriceOfPortfolio+"USD");
		 customer.setCompleteCoinVO(list);
	     return customer;   
	    }

	 
	 
	 @RequestMapping(method = RequestMethod.POST, path = "/{userName}/{coins}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public boolean addCustomerrDetails(@PathVariable String userName,@PathVariable String coins) throws  IOException, InterruptedException {
		 
		 boolean success =true;
		 log.info("USERName Adding---->"+userName);
		 log.info("Coins Adding---->"+coins);
		 Customer newCust = new Customer();
		 newCust.setUsername(userName);
		 newCust.setCoins(coins);
		 
		 customerRepository.save(newCust);
		 
		 
	     return success;   
	    }

	 
	 @RequestMapping(method = RequestMethod.DELETE, path = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public boolean deleteCustomerrDetails(@PathVariable String userName) throws  IOException, InterruptedException {
		 
		 boolean success =true;
		 customerRepository.deleteById(userName);
		 
	     return success;   
	    }
	 
	 @RequestMapping(method = RequestMethod.PUT, path = "/{userName}/{coins}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public boolean updateCustomerrDetails(@PathVariable String userName,@PathVariable String coins) throws  IOException, InterruptedException {
		 
		 boolean success =true;
		 Customer newCust = new Customer();
		 newCust.setUsername(userName);
		 newCust.setCoins(coins);
		 
		 customerRepository.deleteById(userName);
		 customerRepository.save(newCust);
		 
	     return success;   
	    }
}
