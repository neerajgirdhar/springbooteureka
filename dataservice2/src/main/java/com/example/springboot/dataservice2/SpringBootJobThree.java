package com.example.springboot.dataservice2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication


@EnableAutoConfiguration
@EntityScan(basePackages = "com.example.springboot.dataservice2.entity")
@ComponentScan(basePackages= "com.example.springboot.dataservice2.controller,com.example.springboot.dataservice2.repository")
@EnableJpaRepositories(basePackages = "com.example.springboot.dataservice2.repository")
@EnableEurekaClient
public class SpringBootJobThree {
	private static final Logger log = LoggerFactory
			.getLogger(SpringBootJobThree.class);

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringBootJobThree.class);

		SimpleCommandLinePropertySource commandLinePropertySource = new SimpleCommandLinePropertySource(
				args);
		String springProfile = commandLinePropertySource
				.getProperty("spring.profiles.active");

		ConfigurableApplicationContext conf = app.run(args);
		log.info("springProfile Set-->" + springProfile);
		String springProfile1 = System.getenv().get("spring.profiles.active");
		log.info("springProfile1 Set(SYATEN)-->" + springProfile1);

		/*log.info("*********************************************************************************************************");
		
		  if(conf != null) { log.info("conf Not NULL-->");
		  
		  Iterator<String> itr = conf.getBeanFactory().getBeanNamesIterator();
		  while(itr.hasNext()) { log.info(itr.next()); } }
		 
		log.info("*********************************************************************************************************");
		*/
		SpringBootJobThree springBootJob3 = (SpringBootJobThree) conf
				.getBean("springBootJobThree");
		springBootJob3.execute();

		log.info("Application '{}' is running! ");
		String applicationName = conf.getEnvironment().getProperty(
				"spring.application.name");
		String applicationPort = conf.getEnvironment().getProperty(
				"server.port");
		log.info("Application name  " + applicationName);
		log.info("Application Port  " + applicationPort);
	}

	public void execute() {

		String execution_enviorment = System
				.getProperty("properties.execution_enviorment");
		log.info("Fetching ExecutionEnviorment as SystemProperty--->"
				+ execution_enviorment);
		log.info("2nd Spring boot application running....");

	}
}
