package com.github.rafaelfqueiroz.desafios.mailplugin.formatters;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public abstract class StringFormatter {

    private Integer lineLength;
    private boolean justified;
    
    protected static final Integer DEFAULT_LIMIT = 40;

    public StringFormatter(Integer lineLength, boolean justified) {
    	this.lineLength = lineLength;
    	this.justified = justified;
    }

    /**
     * It receives a text and should return it formatted
     *
     * @param text
     * @return
     */
    public abstract String format(String text);

	public boolean isJustified() {
		return justified;
	}

	public Integer getLineLength() {
		return lineLength;
	}

}
