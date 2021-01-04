package com.souvenir_product_like_record.model;
import java.util.List;

public class SouvenirProductLikeRecordService {
	

		private  SouvenirProductLikeRecordDAO_interface dao;

		public SouvenirProductLikeRecordService() {
			dao = new  SouvenirProductLikeRecordJDBCDAO();
		}

		public SouvenirProductLikeRecordVO addSouLike(String sou_id, String mem_id) {
			SouvenirProductLikeRecordVO souprVO = new SouvenirProductLikeRecordVO();
			souprVO.setSou_id(sou_id);
			souprVO.setMem_id(mem_id);
		

			dao.insert(souprVO);
			return souprVO;

		}

		public void deleteSouLike(String sou_id ,String mem_id) {
			dao.delete(sou_id , mem_id);
		}
		
		
		public SouvenirProductLikeRecordVO getOneSouLike(String sou_id) {
			return dao.findByPrimaryKey(sou_id);
		}

		public List<SouvenirProductLikeRecordVO> getAll() {
			return dao.getAll();
		}

	}
