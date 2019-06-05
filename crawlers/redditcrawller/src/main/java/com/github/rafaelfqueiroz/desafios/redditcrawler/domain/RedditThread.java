package com.github.rafaelfqueiroz.desafios.redditcrawler.domain;

public class RedditThread {
	
	private Integer upvotes;
	private String title;
	private String linkComments;
	private String link;
	
	public Integer getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLinkComments() {
		return linkComments;
	}
	public void setLinkComments(String linkComments) {
		this.linkComments = linkComments;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		StringBuilder outputBuilder = new StringBuilder();
		outputBuilder.append("\t").append("title: ").append(getTitle()).append("\n");
		outputBuilder.append("\t").append("upvotes: ").append(getUpvotes()).append("\n");
		outputBuilder.append("\t").append("link-comments: ").append(getLinkComments()).append("\n");
		outputBuilder.append("\t").append("link: ").append(getLink()).append("\n").append("\n");
		return outputBuilder.toString();
	}

}
