package com.github.rafaelfqueiroz.desafios.mailplugin.decorators;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;

/**
 * Interface que define uma formatação a ser aplicada em uma linha
 * @author rafaelfdequeiroz
 */
public interface LineFormat {

	String format(Line line);
	
}
