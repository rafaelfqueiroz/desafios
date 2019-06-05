package com.github.rafaelfqueiroz.desafios.redditcrawler.reader;

import java.util.List;

public interface CrawlerReader<T> {

	List<T> read() throws Exception;
	void setUrl(String url);
	
}
