package com.github.rafaelfqueiroz.desafios.redditcrawler.domain;

import java.util.ArrayList;
import java.util.List;

public class Subreddit {
	
	private String url;
	private List<RedditThread> redditThreads = new ArrayList<>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<RedditThread> getRedditThreads() {
		return redditThreads;
	}

	public void setRedditThreads(List<RedditThread> redditThreads) {
		this.redditThreads = redditThreads;
	}
	
	@Override
	public String toString() {
		StringBuilder outputBuilder = new StringBuilder();
		outputBuilder.append("--").append(url).append(":").append("\n");
		for (RedditThread redditThread : redditThreads) {
			outputBuilder.append(redditThread.toString());
		}
		return outputBuilder.toString();
	}

}
