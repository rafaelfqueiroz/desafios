package com.github.rafaelfqueiroz.desafios.redditcrawler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;
import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;
import com.github.rafaelfqueiroz.desafios.redditcrawler.processor.CrawlerProcessor;
import com.github.rafaelfqueiroz.desafios.redditcrawler.reader.CrawlerReader;
import com.github.rafaelfqueiroz.desafios.redditcrawler.writer.SubredditCrawlerWriter;

@Component
@Profile({"cli","telegram"})
public class SubRedditCrawlerService {
	
	private CrawlerReader<RedditThread> reader;
	private CrawlerProcessor<RedditThread, RedditThread> processor;
	
	public SubRedditCrawlerService(CrawlerReader<RedditThread> reader,
			CrawlerProcessor<RedditThread, RedditThread> processor) {
		this.reader = reader;
		this.processor = processor;
	}
	
	public void executeSteps(List<Subreddit> subReddits, SubredditCrawlerWriter writer) throws Exception {
		for (Subreddit subReddit : subReddits) {
			reader.setUrl(subReddit.getUrl());
			executeSteps(subReddit, writer);
		}
	}
	

	private void executeSteps(Subreddit subreddit, SubredditCrawlerWriter writer) throws Exception {
		List<RedditThread> readThreads = reader.read();
		
		List<RedditThread> processedList = new ArrayList<>();
		for (RedditThread element : readThreads) {
			RedditThread value = processor.process(element);
			
			Optional.ofNullable(value)
					.ifPresent(processedList::add);
		}
		
		subreddit.setRedditThreads(processedList);
		
		writer.write(subreddit);
	}

}
