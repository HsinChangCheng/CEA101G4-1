package com.faq.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.faq.model.FAQService;
import com.faq.model.FAQVO;

public class FAQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
				String str = req.getParameter("faq_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入問答編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String faq_id = null;
				try {
					faq_id = str;
				} catch (Exception e) {
					errorMsgs.add("問答格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				FAQService faqSvc = new FAQService();
				FAQVO faqVO = faqSvc.getOneFAQ(faq_id);
				if (faqVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("faqVO", faqVO); // 資料庫取出的fsVO物件,存入req
				String url = "/back-end/faq/listOneFAQ.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllFAQFoodSpot.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String faq_id = req.getParameter("faq_id");

				/*************************** 2.開始查詢資料 ****************************************/
				FAQService faqSvc = new FAQService();
				FAQVO faqVO = faqSvc.getOneFAQ(faq_id);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("faqVO", faqVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/faq/update_faq_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_faq_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/listAllFAQ.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
		if ("update".equals(action)) { // 來自update_foodspot_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			FAQVO faqVO = new FAQVO();

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String faq_id = req.getParameter("faq_id").trim();
				
				String faq_question = req.getParameter("faq_question");
				if (faq_question == null) {
					errorMsgs.add("問答提問請勿空白");
				}
				

				String faq_answer= req.getParameter("faq_answer");
				if (faq_answer == null) {
					errorMsgs.add("問答解答請勿空白");
				}
				
				faqVO.setFaq_id(faq_id);
				faqVO.setFaq_question(faq_question);
				faqVO.setFaq_answer(faq_answer);
						
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faqVO", faqVO); // 含有輸入格式錯誤的faqVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/update_faq_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				FAQService faqSvc = new FAQService();
				faqVO = faqSvc.updateFAQ(faq_id, faq_question, faq_answer);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("faqVO", faqVO); // 資料庫update成功後,正確的的faqVO物件,存入req
				String url = "/back-end/faq/listAllFAQ.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneFAQ.jsp
				
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				e.printStackTrace();
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/update_faq_input.jsp");
				failureView.forward(req, res);

			}
		}

	if("insert".equals(action))

	{ // 來自addFAQ.jsp的請求

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);

		try {
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String faq_question = req.getParameter("faq_question");
			if (faq_question == null) {
				errorMsgs.add("問答提問請勿空白");
			}
			

			String faq_answer= req.getParameter("faq_answer");
			if (faq_answer == null) {
				errorMsgs.add("問答解答請勿空白");
			}
			
			FAQVO faqVO = new FAQVO();
			faqVO.setFaq_question(faq_question);
			faqVO.setFaq_answer(faq_answer);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("faqVO", faqVO); // 含有輸入格式錯誤的faqVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/addFAQ.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			FAQService faqSvc = new FAQService();
			faqVO = faqSvc.addFAQ(faq_question, faq_answer);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/faq/listAllFAQ.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllFAQ.jsp
			successView.forward(req, res);

			/*************************** 其他可能的錯誤處理 **********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req.getRequestDispatcher("/back-end/faq/addFAQ.jsp");
			failureView.forward(req, res);
		}
	}

	if("delete".equals(action))
	{ // 來自listAllFAQ.jsp

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);

		try {
			/*************************** 1.接收請求參數 ***************************************/
			String faq_id = req.getParameter("faq_id");

			/*************************** 2.開始刪除資料 ***************************************/
			FAQService faqSvc = new FAQService();
			faqSvc.deleteFAQ(faq_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/faq/listAllFAQ.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);

			/*************************** 其他可能的錯誤處理 **********************************/
		} catch (Exception e) {
			errorMsgs.add("刪除資料失敗:" + e.getMessage());
			RequestDispatcher failureView;
			failureView = req.getRequestDispatcher("/back-end/faq/listAllFAQ.jsp");
			failureView.forward(req, res);
		}
	}
}
}
