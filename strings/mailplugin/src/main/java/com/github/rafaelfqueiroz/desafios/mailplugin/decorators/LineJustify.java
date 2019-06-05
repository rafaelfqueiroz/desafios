package com.github.rafaelfqueiroz.desafios.mailplugin.decorators;

import org.springframework.util.StringUtils;

import com.github.rafaelfqueiroz.desafios.mailplugin.domain.Line;

/**
 * Aplica a formatação de linha justificada. 
 * @author rafaelfdequeiroz
 */
public class LineJustify implements LineFormat {

	@Override
	public String format(Line line) {
		int aditionalSpaces = line.getMaxLineLength() - line.getLineLength();
		
		return fillLineWithWhiteSpaces(line, aditionalSpaces);
	}

	private String fillLineWithWhiteSpaces(Line line, int aditionalSpaces) {
		if (StringUtils.isEmpty(line.toString())) {
			return "";
		}
		StringBuilder outputLine = new StringBuilder(line.toString());
		while ( aditionalSpaces > 0) {
			for( int i = 0 ; i < outputLine.length() && aditionalSpaces > 0 ; i++ ) {
				if( outputLine.charAt(i) == ' ') {
					outputLine.insert(i, ' ');
					i++;
					aditionalSpaces--;
				}
			}
		}
		
		return outputLine.toString();
	}
	
}
