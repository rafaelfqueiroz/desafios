package com.github.rafaelfqueiroz.desafios.redditcrawler.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config")
public class CrawlerProperties {

	private String baseUrl;
	private String subReddits;
	private String splitter;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getSubReddits() {
		return subReddits;
	}
	public void setSubReddits(String subReddits) {
		this.subReddits = subReddits;
	}
	public String getSplitter() {
		return splitter;
	}
	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}
	
}
