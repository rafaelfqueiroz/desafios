package com.github.rafaelfqueiroz.desafios.redditcrawler.reader;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;
import com.github.rafaelfqueiroz.desafios.redditcrawler.drivers.WebDriverFactory;

public class RedditReader implements CrawlerReader<RedditThread>{

	private WebDriver driver;
	private String url;
	private CrawlerReaderMapper<WebElement, RedditThread> mapper;
	public RedditReader(CrawlerReaderMapper<WebElement, RedditThread> mapper, WebDriverFactory driver) {
		this.driver = driver.createDriver();
		this.mapper = mapper;
	}
	

	@Override
	public List<RedditThread> read() throws Exception {
		driver.get(getUrl());
		
		List<WebElement> tElements = driver.findElements(By.cssSelector("div.sitetable.linklisting > div.thing.link"));
		
		List<RedditThread> collect = tElements.stream().map(mapper::mapItems).collect(Collectors.toList());
		
		return collect;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

}
