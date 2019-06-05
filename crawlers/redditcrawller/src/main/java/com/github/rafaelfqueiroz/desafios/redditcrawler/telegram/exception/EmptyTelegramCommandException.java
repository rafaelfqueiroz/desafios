package com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception;

public class EmptyTelegramCommandException extends TelegramCrawlerException{

	public EmptyTelegramCommandException() {
		super("Informe o nome de um subreddit!");
	}

}
