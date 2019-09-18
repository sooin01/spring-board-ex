package com.my.app.common.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {

	@Autowired
	private Environment environment;

	@Value("${db.maximumPoolSize}")
	public int dbMaximumPoolSize;

	@PostConstruct
	public void init() {
		System.out.println("DB maximum pool size: " + dbMaximumPoolSize);
		for (String s : environment.getDefaultProfiles()) {
			System.out.println("Spring default profile: " + s);
		}
		for (String s : environment.getActiveProfiles()) {
			System.out.println("Spring active profile: " + s);
		}
	}

}
