package com.github.rafaelfqueiroz.desafios.redditcrawler.writer;

public interface CrawlerWriter<T> {

	void write(T itemWriting) throws Exception;
	
}
