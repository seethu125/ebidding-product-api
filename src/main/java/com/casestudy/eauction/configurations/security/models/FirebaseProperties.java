package com.casestudy.eauction.configurations.security.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "security")
public class FirebaseProperties {

	private int sessionExpiryInDays;
	private String databaseUrl;
	private boolean enableStrictServerSession;
	private boolean enableCheckSessionRevoked;
	private boolean enableLogoutEverywhere;

}
