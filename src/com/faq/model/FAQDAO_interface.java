package com.faq.model;

import java.util.List;

public interface FAQDAO_interface {

		public void insert(FAQVO faqVO);
		public void update(FAQVO faqVO);
		public void delete(String faq_id);
		public FAQVO findByPrimaryKey(String faq_id);
		public List<FAQVO> getAll();

}

