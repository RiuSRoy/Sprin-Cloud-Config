package com.techprimes.config.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}


@Configuration
@EnableAutoConfiguration
@RestController
class Application {

	//@Value("${config.name}")
	String name = "Your config server is up and running....Make a request at endpoints";

	@RequestMapping("/")
	public String home() {
		return "Hello !! " + name;
	}

}
