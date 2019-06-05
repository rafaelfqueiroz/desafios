package com.github.rafaelfqueiroz.desafios.mailplugin.domain;

/**
 * Representa um texto que pode ser editável, no que diz respeito a adição de linhas.
 * Outras possíveis operações referentes a composição do texto, como remoção de linhas,
 * são definidas por esta interface. 
 * @author rafaelfdequeiroz
 */
public interface EditableText extends Text {
	
	void addLine(Line line);
}
