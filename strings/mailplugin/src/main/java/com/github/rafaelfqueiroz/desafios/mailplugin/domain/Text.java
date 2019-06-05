package com.github.rafaelfqueiroz.desafios.mailplugin.domain;

import java.util.List;

/**
 * Interface que representa um texto que pode ser escrito/impresso
 * e é composto por uma lista de linhas. 
 * @author rafaelfdequeiroz
 */
public interface Text {

	String write();
	List<Line> getLines();
	
}
