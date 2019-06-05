package com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception;

public abstract class TelegramCrawlerException extends RuntimeException {

	public TelegramCrawlerException(String message) {
		super(message);
	}
}
