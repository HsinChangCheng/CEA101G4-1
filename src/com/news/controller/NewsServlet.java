package com.news.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsService;
import com.news.model.NewsVO;

public class NewsServlet extends HttpServlet {
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
				String str = req.getParameter("news_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入最新消息編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String news_id = null;
				try {
					news_id = str;
				} catch (Exception e) {
					errorMsgs.add("訂單編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_id);
				if (newsVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("newsVO", newsVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/news/listOneNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneSouvenirOrder.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String news_id = req.getParameter("news_id");

				/*************************** 2.開始查詢資料 ****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_id);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("newsVO", newsVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/news/update_news_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/listAllNews.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_souvenirorder_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String news_content = req.getParameter("news_content").trim();
				
				java.sql.Timestamp news_date = null;
				try {
					news_date = java.sql.Timestamp.valueOf(req.getParameter("news_date").trim());
				} catch (IllegalArgumentException e) {
					news_date=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				String news_id = req.getParameter("news_id").trim();
			
				NewsVO newsVO = new NewsVO();
				newsVO.setNews_content(news_content);
				newsVO.setNews_date(news_date);	
				newsVO.setNews_id(news_id);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("newsVO", newsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/update_news_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.updateNews(news_content, news_date, news_id);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("newsVO", newsVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/news/listOneNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
//			} catch (Exception e) {
//				errorMsgs.add("修改資料失敗:" + e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/update_news_input.jsp");
//				failureView.forward(req, res);
//			}
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				String news_content = req.getParameter("news_content").trim();
				java.sql.Timestamp news_date = null;
				try {
					news_date = java.sql.Timestamp.valueOf(req.getParameter("news_date").trim());
				} catch (IllegalArgumentException e) {
					news_date=new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
					
				NewsVO newsVO = new NewsVO();
				newsVO.setNews_content(news_content);
				newsVO.setNews_date(news_date);
				
				
				
		
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("newsVO", newsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/addNews.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.addNews(news_content, news_date);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/news/listAllNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/addNews.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllSouvenir_Order.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				String news_id = req.getParameter("news_id");

				/*************************** 2.開始刪除資料 ***************************************/
				NewsService newsSvc = new NewsService();
				newsSvc.deleteNews(news_id);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/news/listAllNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView;
				failureView = req.getRequestDispatcher("/back-end/news/listAllNews.jsp");
				failureView.forward(req, res);
			}
		}
	}
}

