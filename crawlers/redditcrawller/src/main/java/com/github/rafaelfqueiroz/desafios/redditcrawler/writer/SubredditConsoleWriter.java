package com.github.rafaelfqueiroz.desafios.redditcrawler.writer;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;

public class SubredditConsoleWriter extends SubredditCrawlerWriter{

	@Override
	public void write(Subreddit subReddit) throws Exception {
		System.out.println(subReddit.toString());
	}

}
