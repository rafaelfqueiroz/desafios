package com.github.rafaelfqueiroz.desafios.redditcrawler.telegram.exception;

public class InvalidTelegramCommandException extends RuntimeException{
	
	public InvalidTelegramCommandException() {
		super("Comando inválido!");
	}

}
