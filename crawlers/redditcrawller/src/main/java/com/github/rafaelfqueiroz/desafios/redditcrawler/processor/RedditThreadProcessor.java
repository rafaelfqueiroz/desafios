package com.github.rafaelfqueiroz.desafios.redditcrawler.processor;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.RedditThread;

public class RedditThreadProcessor implements CrawlerProcessor<RedditThread, RedditThread>{
	

	@Override
	public RedditThread process(RedditThread thread) throws Exception {
		
		if (thread.getUpvotes() < 5000) {
			return null;
		}
		
		return thread;
		
	}
	

}
