package com.github.rafaelfqueiroz.desafios.mailplugin.decorators;

import java.util.List;
import java.util.stream.Collectors;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;
import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Text;

public class JustifiedTextDecorator extends TextDecorator {
	
	public JustifiedTextDecorator(Text text) {
		super(text, new LineJustify());
	}

	@Override
	public String write() {
		String result = getLines().stream().map(lineFormat::format).collect(Collectors.joining("\n"));
		return result;
	}

	@Override
	public List<Line> getLines() {
		return text.getLines();
	}

}
