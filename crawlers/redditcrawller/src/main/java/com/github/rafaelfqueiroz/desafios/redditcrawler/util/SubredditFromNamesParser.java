package com.github.rafaelfqueiroz.desafios.redditcrawler.util;

import java.util.ArrayList;
import java.util.List;

import com.github.rafaelfqueiroz.desafios.redditcrawler.domain.Subreddit;

public class SubredditFromNamesParser {
	private String[] subRedditNames;
	private String baseUrl;
	
	public SubredditFromNamesParser(String baseUrl, String[] subRedditNames) {
		this.baseUrl = baseUrl;
		this.subRedditNames = subRedditNames;
	}
	
	public List<Subreddit> parse() {
		
		List<Subreddit> subReddits = new ArrayList<>();
		for (String subRedditName : subRedditNames) {
			StringBuilder urlBuilder = new StringBuilder();
			
			urlBuilder.append(baseUrl)
					.append(subRedditName);
			
			Subreddit subReddit = new Subreddit();
			subReddit.setUrl(urlBuilder.toString());
			
			subReddits.add(subReddit);
		}
		
		return subReddits;
		
	}
}
