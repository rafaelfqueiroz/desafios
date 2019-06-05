package com.github.rafaelfqueiroz.desafios.redditcrawler.util;

import org.springframework.util.StringUtils;

import com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception.EmptyTelegramCommandException;

public class RedditNameRetriever {

	public String [] retrieve(String names, String spitter) {
		if (StringUtils.isEmpty(names)) {
			throw new EmptyTelegramCommandException();
		}
		return names.trim().split(spitter);
	}
}
