package com.github.rafaelfqueiroz.desafios.mailplugin.exceptions;

public class UnknownArgumentException extends RuntimeException {
	private static final long serialVersionUID = 3868282828787052333L;

	public UnknownArgumentException() {
		super("Argumento informado não corresponde a um argumento conhecido.");
	}
}
