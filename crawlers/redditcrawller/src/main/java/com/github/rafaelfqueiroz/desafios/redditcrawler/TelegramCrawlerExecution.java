package com.github.rafaelfqueiroz.desafios.redditcrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import com.github.rafaelfqueiroz.desafios.redditcrawler.properties.CrawlerProperties;
import com.github.rafaelfqueiroz.desafios.redditcrawler.properties.TelegramProperties;
import com.github.rafaelfqueiroz.desafios.redditcrawler.service.SubRedditCrawlerService;
import com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.RedditCrawlerTelegramBot;

@Component
@Profile("telegram")
public class TelegramCrawlerExecution implements CommandLineRunner {

	@Autowired
	private CrawlerProperties config;
	@Autowired
	private SubRedditCrawlerService service;
	@Autowired
	private TelegramProperties properties;
	
	@Override
	public void run(String... args) throws Exception {
		ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();
		
		botsApi.registerBot(new RedditCrawlerTelegramBot(service, config, properties));
	}

}
