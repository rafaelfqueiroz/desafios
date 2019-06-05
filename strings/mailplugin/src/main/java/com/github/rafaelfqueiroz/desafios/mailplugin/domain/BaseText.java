package com.github.rafaelfqueiroz.desafios.mailplugin.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BaseText implements EditableText {
	
	private List<Line> lines = new ArrayList<>();
	
	@Override
	public String write() {
		return lines.stream().map(Line::toString).collect(Collectors.joining("\n"));
	}

	@Override
	public void addLine(Line line) {
		lines.add(line);
	}

	@Override
	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}

}
