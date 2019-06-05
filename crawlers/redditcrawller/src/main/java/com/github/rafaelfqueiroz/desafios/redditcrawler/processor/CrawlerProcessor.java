package com.github.rafaelfqueiroz.desafios.redditcrawler.processor;

public interface CrawlerProcessor<I, O> {

	O process(I item) throws Exception;
}
