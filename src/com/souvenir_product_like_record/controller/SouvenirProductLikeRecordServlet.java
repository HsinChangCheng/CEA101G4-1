package com.souvenir_product_like_record.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvenir_product_like_record.model.SouvenirProductLikeRecordService;
import com.souvenir_product_like_record.model.SouvenirProductLikeRecordVO;

public class SouvenirProductLikeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 查1
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String str = req.getParameter("sou_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入特產編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/select_soulike_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String sou_id = null;
				try {
					sou_id = str;
				} catch (Exception e) {
					errorMsgs.add("特產編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/select_soulike_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				SouvenirProductLikeRecordService souprSvc = new SouvenirProductLikeRecordService();
				SouvenirProductLikeRecordVO souprVO = souprSvc.getOneSouLike(sou_id);
				if (souprVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/select_soulike_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("souprVO", souprVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/souvenir_like/listOneSouLike.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/select_soulike_page.jsp");
				failureView.forward(req, res);
			}
		}

		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				String sou_id = req.getParameter("sou_id").trim();
				String mem_id = req.getParameter("mem_id").trim();

		

				
				SouvenirProductLikeRecordVO souprVO = new SouvenirProductLikeRecordVO();
				souprVO.setSou_id(sou_id);
				souprVO.setMem_id(mem_id);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("souprVO", souprVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/addSouLike.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				SouvenirProductLikeRecordService souprSvc = new SouvenirProductLikeRecordService();
				souprVO = souprSvc.addSouLike(sou_id, mem_id);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/souvenir_like/listAllSouLike.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_like/addSouLike.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				String sou_id = req.getParameter("sou_id");
				String mem_id = req.getParameter("mem_id");

				/*************************** 2.開始刪除資料 ***************************************/
				SouvenirProductLikeRecordService souprSvc = new SouvenirProductLikeRecordService();
				souprSvc.deleteSouLike(sou_id, mem_id);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/souvenir_like/listAllSouLike.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView;
				failureView = req.getRequestDispatcher("/back-end/souvenir_like/listAllSouLike.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
		
