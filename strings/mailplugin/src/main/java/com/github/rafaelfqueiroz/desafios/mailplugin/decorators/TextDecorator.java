package com.github.rafaelfqueiroz.desafios.mailplugin.decorators;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Text;

public abstract class TextDecorator implements Text {
	protected Text text;
	protected LineFormat lineFormat;
	public TextDecorator(Text text, LineFormat lineFormat) {
		this.text = text;
		this.lineFormat=lineFormat;
	}
	
}
