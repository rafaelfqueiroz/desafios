package com.github.rafaelfqueiroz.desafios.mailplugin.formatters;

import com.github.rafaelfqueiroz.desafios.mailplugin.decorators.JustifiedTextDecorator;
import com.github.rafaelfqueiroz.desafios.mailplugin.domain.EditableText;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 * Updated by Rafael Queiroz.
 */
public class IdwallFormatter extends StringFormatter {
	
	public IdwallFormatter(boolean justified) {
		super(DEFAULT_LIMIT, justified);
	}

    public IdwallFormatter(Integer limit, boolean justified) {
		super(limit, justified);
	}

	/**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */
    @Override
    public String format(String sourceText) {
    	 EditableText text = new BaseTextProcessor().process(sourceText, getLineLength());
		
		if (isJustified()) {
			return new JustifiedTextDecorator(text).write();
		}
		
		return text.write();
    }

}
