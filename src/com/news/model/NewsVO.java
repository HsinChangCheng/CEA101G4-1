package com.news.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Clob;
public class NewsVO implements Serializable {
	private String news_id;
	private String  news_content;
	private Timestamp news_date;
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Timestamp getNews_date() {
		return news_date;
	}
	public void setNews_date(Timestamp news_date) {
		this.news_date = news_date;
	}
	
}
