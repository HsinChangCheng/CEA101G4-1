package com.sellermemberrecord.controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.sellermemberrecord.model.*;


public class SellMemRecordServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String str = req.getParameter("sellMemRecordId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員通知編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String sellMemRecordId = null;
				try {
					sellMemRecordId = new String(str);
				} catch (Exception e) {
					errorMsgs.add("會員紀錄編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				SellMemRecordService sellMemRecordSvc = new SellMemRecordService();
				SellMemRecordVO sellMemRecordVO = sellMemRecordSvc.getOneSellMemRecord(sellMemRecordId);
				if (sellMemRecordVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("sellMemRecordVO", sellMemRecordVO); // 資料庫取出的sellMemRecordVO物件,存入req
				String url = "/front-sell-end/sellmemberrecord/listOneSellMemberRecord.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneSellMemberRecord.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllMemRecord.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String sellMemRecordId = req.getParameter("sellMemRecordId");

				/*************************** 2.開始查詢資料 ****************************************/
				SellMemRecordService sellMemRecordSvc = new SellMemRecordService();
				SellMemRecordVO sellMemRecordVO = sellMemRecordSvc.getOneSellMemRecord(sellMemRecordId);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("sellMemRecordVO", sellMemRecordVO); // 資料庫取出的sellMemRecordVO物件,存入req
				String url = "/front-sell-end/sellmemberrecord/update_sellmemberrecord_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_sellmemberrecord_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/listAllSellMemberRecord.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_sellmemberrecord_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String sellMemRecordId = req.getParameter("sellMemRecordId");

				String sellMemId = req.getParameter("sellMemId");
				String sellMemIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{7}$";
				if (sellMemId == null || sellMemId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if (!sellMemId.trim().matches(sellMemIdReg)) {
					// 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是6");
				}

				java.sql.Timestamp sellMemRecordTime = java.sql.Timestamp.valueOf(req.getParameter("sellMemRecordTime"));
				try {
					sellMemRecordTime = java.sql.Timestamp.valueOf(req.getParameter("sellMemRecordTime"));
				} catch (IllegalArgumentException e) {
					sellMemRecordTime = new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				String sellMemRecordContent = req.getParameter("sellMemRecordContent");
//				if (memRecordContent == null || memRecordContent.trim().length() == 0) {
//					errorMsgs.add("空白");
//				}

				Integer sellMemRecordRead = null;
				try {
					sellMemRecordRead = new Integer(req.getParameter("sellMemRecordRead"));
					if (sellMemRecordRead != 0 && sellMemRecordRead != 1) {
						errorMsgs.add("請填數字0或1");
					}
				} catch (NumberFormatException e) {
					errorMsgs.add("請填數字0或1");

				}

				SellMemRecordVO sellMemRecordVO = new SellMemRecordVO();
				sellMemRecordVO.setSellMemRecordId(sellMemRecordId);
				sellMemRecordVO.setSellMemId(sellMemId);
				sellMemRecordVO.setSellMemRecordTime(sellMemRecordTime);
				sellMemRecordVO.setSellMemRecordRead(sellMemRecordRead);
				sellMemRecordVO.setSellMemRecordContent(sellMemRecordContent);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("sellMemRecordVO", sellMemRecordVO); // 含有輸入格式錯誤的sellMemRecordVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/front-sell-end/sellmemberrecord/update_sellmemberrecord_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				SellMemRecordService sellMemRecordSvc = new SellMemRecordService();
				sellMemRecordVO = sellMemRecordSvc.updateSellMemRecord(sellMemRecordId, sellMemId, sellMemRecordContent, sellMemRecordTime, sellMemRecordRead);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("sellMemRecordVO", sellMemRecordVO); // 資料庫update成功後,正確的的sellMemRecordVO物件,存入req

				String url = "/front-sell-end/sellmemberrecord/listOneSellMemberRecord.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneSellMemberRecord.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/update_sellmemberrecord_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action))

		{ // 來自addMemRecord.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

				String sellMemId = req.getParameter("sellMemId");
				String sellMemIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{7}$";
				if (sellMemId == null || sellMemId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if (!sellMemId.trim().matches(sellMemIdReg)) {
					// 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是6");
				}

//				java.sql.Timestamp memRecordTime = java.sql.Timestamp.valueOf(req.getParameter("memRecordTime"));
//				try {
//					memRecordTime = java.sql.Timestamp.valueOf(req.getParameter("memRecordTime"));
//				} catch (IllegalArgumentException e) {
//					memRecordTime = new java.sql.Timestamp(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}

				String sellMemRecordContent = req.getParameter("sellMemRecordContent");
//			if (memRecordContent == null || memRecordContent.trim().length() == 0) {
//				errorMsgs.add("空白");
//			}

				Integer sellMemRecordRead = null;
				try {
					sellMemRecordRead = new Integer(req.getParameter("sellMemRecordRead"));
					if (sellMemRecordRead != 0 && sellMemRecordRead != 1 && sellMemRecordRead != 2) {
						errorMsgs.add("請填數字0或1或2");
					}
				} catch (NumberFormatException e) {
					errorMsgs.add("請填數字0或1或2");

				}

				SellMemRecordVO sellMemRecordVO = new SellMemRecordVO();
				sellMemRecordVO.setSellMemId(sellMemId);
//				sellMemRecordVO.setSellMemRecordTime(memRecordTime);
				sellMemRecordVO.setSellMemRecordContent(sellMemRecordContent);
				sellMemRecordVO.setSellMemRecordRead(sellMemRecordRead);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("sellMemRecordVO", sellMemRecordVO); // 含有輸入格式錯誤的sellMemRecordVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/addSellMemberRecord.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				SellMemRecordService sellMemRecordSvc = new SellMemRecordService();
				sellMemRecordVO = sellMemRecordSvc.addSellMemRecord(sellMemId, sellMemRecordContent, sellMemRecordRead);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/front-sell-end/sellmemberrecord/listAllSellMemberRecord.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllMemRecord.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/addSellMemberRecord.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllMemRecord.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				String sellMemRecordId = req.getParameter("sellMemRecordId");

				/*************************** 2.開始刪除資料 ***************************************/
				SellMemRecordService sellMemRecordSvc = new SellMemRecordService();
				sellMemRecordSvc.deleteSellMemRecord(sellMemRecordId);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/front-sell-end/sellmemberrecord/listAllSellMemberRecord.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/sellmemberrecord/listAllSellMemberRecord.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
