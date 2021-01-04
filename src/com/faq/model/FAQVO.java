package com.faq.model;

import java.io.Serializable;

public class FAQVO implements Serializable{
	private String faq_id;
	private String faq_question;
	private String faq_answer;
	public String getFaq_id() {
		return faq_id;
	}
	public void setFaq_id(String faq_id) {
		this.faq_id = faq_id;
	}
	public String getFaq_question() {
		return faq_question;
	}
	public void setFaq_question(String faq_question) {
		this.faq_question = faq_question;
	}
	public String getFaq_answer() {
		return faq_answer;
	}
	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
	}

}
