package com.github.rafaelfqueiroz.desafios.redditcrawler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;
import com.github.rafaelfqueiroz.desafios.redditcrawler.properties.CrawlerProperties;
import com.github.rafaelfqueiroz.desafios.redditcrawler.service.SubRedditCrawlerService;
import com.github.rafaelfqueiroz.desafios.redditcrawler.util.RedditNameRetriever;
import com.github.rafaelfqueiroz.desafios.redditcrawler.util.SubredditFromNamesParser;
import com.github.rafaelfqueiroz.desafios.redditcrawler.writer.SubredditConsoleWriter;

@Component
@Profile("cli")
public class CLiCrawlerExecution implements CommandLineRunner {
	
	@Autowired
	private CrawlerProperties config;
	@Autowired
	private SubRedditCrawlerService service;

	@Override
	public void run(String... args) throws Exception {
		
		String[] subRedditNames = new RedditNameRetriever().retrieve(config.getSubReddits(), ";");
		List<Subreddit> subReddits = new SubredditFromNamesParser(config.getBaseUrl(), subRedditNames).parse();
		
		service.executeSteps(subReddits, new SubredditConsoleWriter());
		
	}
	
}
