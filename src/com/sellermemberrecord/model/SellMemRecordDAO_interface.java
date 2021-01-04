package com.sellermemberrecord.model;

import java.util.List;

public interface SellMemRecordDAO_interface {
	public void insert(SellMemRecordVO sellMemRecordVO);
    public void update(SellMemRecordVO sellMemRecordVO);
    public void delete(String sellMemRecordVO);
    public SellMemRecordVO findByPrimaryKey(String sellMemRecordId);
    public List<SellMemRecordVO> getAll();
}
