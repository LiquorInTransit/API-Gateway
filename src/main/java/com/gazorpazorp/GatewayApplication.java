package com.gazorpazorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.gazorpazorp.client.config.CustomOAuth2FeignRequestInterceptor;
import com.netflix.appinfo.AmazonInfo;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication(scanBasePackages="com.gazorpazorp")
@EnableFeignClients("com.gazorpazorp.client")
@EnableOAuth2Client
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	feign.RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext context) {
		if (context == null) return null;
		return new CustomOAuth2FeignRequestInterceptor(context);
	}
	
	@Bean
	@Profile("!dev")
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils utils) 
	{
//		EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(utils);
		final EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(utils)
		{
			@Scheduled(initialDelay = 30000L, fixedRate = 30000L)
			public void refreshInfo() {
				AmazonInfo newInfo = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
				if (!this.getDataCenterInfo().equals(newInfo)) {
					((AmazonInfo) this.getDataCenterInfo()).setMetadata(newInfo.getMetadata());
					this.setHostname(newInfo.get(AmazonInfo.MetaDataKey.publicHostname));
					this.setIpAddress(newInfo.get(AmazonInfo.MetaDataKey.publicIpv4));
					this.setDataCenterInfo(newInfo);
					this.setNonSecurePort(8080);
				}
			}         
		};
		AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		instance.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
		instance.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
		instance.setDataCenterInfo(info);
		instance.setNonSecurePort(8080);
		return instance;
	}
}
