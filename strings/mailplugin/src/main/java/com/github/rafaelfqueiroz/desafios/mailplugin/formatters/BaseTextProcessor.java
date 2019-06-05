package com.github.rafaelfqueiroz.desafios.mailplugin.formatters;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.BaseText;
import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;

public class BaseTextProcessor {

	public BaseText process(String sourceText, Integer lineLength) {
		
		String[] textLines = sourceText.split("\\n");
		BaseText baseText = new BaseText();
		for (String line : textLines) {
			String[] lineWords = line.split("\\s");
			Line currentLine = new Line(lineLength);
			for (String word : lineWords) {
				boolean appended = currentLine.append(word);
				
				if (!appended) {
					baseText.addLine(currentLine);
					currentLine = new Line(lineLength);
					currentLine.append(word);
				}
			}
			currentLine.append("\n");
			baseText.addLine(currentLine);
		}
		return baseText;
	}
}
