package com.techprimes.config.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}


@RefreshScope
@RestController
class MessageRestcontroller {

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMsg() {
		return this.message;
	}
}

@RestController
class RefreshController {

	@Autowired
	RefreshEndpoint refreshEndpoint;

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	void refresh() {
		refreshEndpoint.refresh();
	}
}