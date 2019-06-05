package com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception;

public class InvalidTelegramCommandException extends TelegramCrawlerException {
	
	public InvalidTelegramCommandException() {
		super("Comando inválido!");
	}

}
