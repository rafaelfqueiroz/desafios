package com.github.rafaelfqueiroz.desafios.redditcrawler.reader;

public interface CrawlerReaderMapper<R, T> {

	T mapItems(R raw);

}
