package com.memberrecord.model;

import java.sql.*;
import java.util.*;

public class MemRecordService {
	private MemRecordDAO_interface dao;

	public MemRecordService() {
		dao = new MemRecordDAO();
	}

	public MemRecordVO addMemRecord(String memId, String memRecordContent, Integer memRecordRead) {

		MemRecordVO memRecordVO = new MemRecordVO();

		memRecordVO.setMemId(memId);
		memRecordVO.setMemRecordContent(memRecordContent);
		memRecordVO.setMemRecordRead(memRecordRead);
		dao.insert(memRecordVO);

		return memRecordVO;
	}

	public MemRecordVO updateMemRecord(String memRecordId, String memId, String memRecordContent, Timestamp memRecordTime,
			Integer memRecordRead) {
//		 java.sql.Timestamp replyTime
		MemRecordVO memRecordVO = new MemRecordVO();

		memRecordVO.setMemRecordId(memRecordId);
		memRecordVO.setMemId(memId);
		memRecordVO.setMemRecordContent(memRecordContent);
		memRecordVO.setMemRecordTime(memRecordTime);
		memRecordVO.setMemRecordRead(memRecordRead);
		dao.update(memRecordVO);

		return memRecordVO;
	}

	public void deleteMemRecord(String memRecordId) {
		dao.delete(memRecordId);
	}

	public MemRecordVO getOneMemRecord(String memRecordId) {
		return dao.findByPrimaryKey(memRecordId);
	}

	public List<MemRecordVO> getAll() {
		return dao.getAll();
	}
}
