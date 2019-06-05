package com.github.rafaelfqueiroz.desafios.mailplugin.domain;

public class Line {
	
	private static final String WHITESPACE = " ";
	private Integer maxLineLength;
	private StringBuilder lineBuilder;
	
	public Line(Integer lineLength) {
		setMaxLineLength(lineLength);
		lineBuilder = new StringBuilder();
	}

	public boolean append(String word) {
		String planWord = word.trim();
		boolean appendable = isAppendable(planWord);
		
		if (appendable) {
			lineBuilder.append(planWord).append(WHITESPACE);
		}
		
		return appendable;
	}
	
	public Integer getMaxLineLength() {
		return this.maxLineLength;
	}
	
	private void setMaxLineLength(Integer lineLength) {
		this.maxLineLength = lineLength;
	}
	
	public Integer getWhitespaces() {
		return toString().split(WHITESPACE).length - 1;
	}
	
	private boolean isAppendable(String word) {
		int lineLenth = lineBuilder.toString().length();
		int wordLenth = word.length();
		return wordLenth + lineLenth <= maxLineLength;
	}
	
	public int getLineLength() {
		return toString().length();
	}
	
	@Override
	public String toString() {
		return lineBuilder.toString().trim();
	}

}
