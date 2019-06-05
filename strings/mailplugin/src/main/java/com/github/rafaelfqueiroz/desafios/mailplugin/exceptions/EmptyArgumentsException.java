package com.github.rafaelfqueiroz.desafios.mailplugin.exceptions;

public class EmptyArgumentsException  extends RuntimeException {

	private static final long serialVersionUID = -2723878574376191646L;

	public EmptyArgumentsException() {
		super(new StringBuilder().append("Não foram informados argumentos suficientes ")
								.append("para funcionamento da aplicação. ")
								.append("Informe --help para saber quais argumentos deve informar.")
								.toString());
	}
	
}
