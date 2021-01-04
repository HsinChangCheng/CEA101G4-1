package com.memberrecord.model;
import java.util.List;

public interface MemRecordDAO_interface {
	public void insert(MemRecordVO memRecordVO);
    public void update(MemRecordVO memRecordVO);
    public void delete(String memRecordVO);
    public MemRecordVO findByPrimaryKey(String memRecordId);
    public List<MemRecordVO> getAll();
}
