package com.cognizant.IIHT.ZuulgatewayMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayMicroServiceApplication.class, args);
	}

}
