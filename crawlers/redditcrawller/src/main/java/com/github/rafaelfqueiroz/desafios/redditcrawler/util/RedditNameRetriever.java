package com.github.rafaelfqueiroz.desafios.redditcrawler.util;

public class RedditNameRetriever {

	public String [] retrieve(String names, String spitter) {
		return names.trim().split(spitter);
	}
}
