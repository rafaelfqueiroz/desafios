package com.github.rafaelfqueiroz.desafios.mailplugin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="config")
public class MailPluginProperties {

	private String inputText;
	private String inputFilePath;
	private Integer lineLength;
	private boolean justified;
	
	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	public String getInputFilePath() {
		return inputFilePath;
	}
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	public Integer getLineLength() {
		return lineLength;
	}
	public void setLineLength(Integer lineLength) {
		this.lineLength = lineLength;
	}
	public boolean isJustified() {
		return justified;
	}
	public void setJustified(boolean justified) {
		this.justified = justified;
	}
	
}
