package com.github.rafaelfqueiroz.desafios.redditcrawler.writer;

import java.util.function.Consumer;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;

public class TelegramSubredditWriter extends SubredditCrawlerWriter {
	
	private Consumer<Subreddit> consumer;
	public TelegramSubredditWriter(Consumer<Subreddit> consumer) {
		this.consumer = consumer;
	}

	@Override
	public void write(Subreddit itemWriting) throws Exception {
		consumer.accept(itemWriting);
	}

}
