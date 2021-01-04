package com.souvenir_discount.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvenir_discount.model.SouvenirDiscountService;
import com.souvenir_discount.model.SouvenirDiscountVO;


public class SouvenirDiscountServlet extends HttpServlet {
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
				String str = req.getParameter("sou_dis_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入特產促銷編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				String sou_dis_id = null;
				try {
					sou_dis_id = str;
				} catch (Exception e) {
					errorMsgs.add("特產促銷編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				SouvenirDiscountService sodSvc = new SouvenirDiscountService();
				SouvenirDiscountVO sodVO = sodSvc.getOneSouDis(sou_dis_id);
				if (sodVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("sodVO", sodVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/souvenir_discount/listOneSouDis.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir/select_page.jsp");
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
				String sou_dis_id = req.getParameter("sou_dis_id");

				/*************************** 2.開始查詢資料 ****************************************/
				SouvenirDiscountService sodSvc = new SouvenirDiscountService();
				SouvenirDiscountVO sodVO = sodSvc.getOneSouDis(sou_dis_id);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("sodVO", sodVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/souvenir_discount/update_soudis_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_discount/listAllSouDis.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String sou_dis_id = req.getParameter("sou_dis_id").trim();

				String sou_dis_name = req.getParameter("sou_dis_name").trim();
				String sou_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
				if (sou_dis_name == null || sou_dis_name.trim().length() == 0) {
					errorMsgs.add("特產促銷名稱: 請勿空白");
				} else if (!sou_dis_name.trim().matches(sou_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("特產促銷名稱: 只能是中、英文字母、數字和_ , 且長度必需在1到10之間");
				}

				
				java.sql.Timestamp sou_dis_start = null;
				try {
					String disstart = req.getParameter("sou_dis_start").trim();
					sou_dis_start = java.sql.Timestamp.valueOf(disstart);
				} catch (IllegalArgumentException e) {
					sou_dis_start = new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請加入時間");
				}
				
				java.sql.Timestamp sou_dis_end = null;
				try {
					String disend = req.getParameter("sou_dis_end").trim();
					sou_dis_end = java.sql.Timestamp.valueOf(disend);
				} catch (IllegalArgumentException e) {
					sou_dis_end = new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請加入時間");
				}

				

				Double sou_dis_status = null;
				
				try {
					sou_dis_status = new Double(req.getParameter("sou_dis_status").trim());
					if(sou_dis_status < 0) {
						errorMsgs.add("折扣要是正數");
					}
				} catch (NumberFormatException e) {
					sou_dis_status = 0.0;
					errorMsgs.add("折扣請填小數點");
				}


				
				
				SouvenirDiscountVO sodVO = new SouvenirDiscountVO();
				sodVO.setSou_dis_id(sou_dis_id);
				sodVO.setSou_dis_name(sou_dis_name);
				sodVO.setSou_dis_start(sou_dis_start);
				sodVO.setSou_dis_end(sou_dis_end);
				sodVO.setSou_dis_status(sou_dis_status);

				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("sodVO", sodVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_discount/update_soudis_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}
			
				/*************************** 2.開始修改資料 *****************************************/
				SouvenirDiscountService sodSvc = new SouvenirDiscountService();
				sodVO = sodSvc.updateSouDis(sou_dis_id, sou_dis_name, sou_dis_start, sou_dis_end, sou_dis_status);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("sodVO", sodVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/souvenir_discount/listOneSouDis.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_discount/update_soudis_input.jsp");
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
				
				String sou_dis_name = req.getParameter("sou_dis_name").trim();
				String sou_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
				if (sou_dis_name == null || sou_dis_name.trim().length() == 0) {
					errorMsgs.add("特產促銷名稱: 請勿空白");
				} else if (!sou_dis_name.trim().matches(sou_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("特產促銷名稱: 只能是中、英文字母、數字和_ , 且長度必需在1到10之間");
				}

				
				java.sql.Timestamp sou_dis_start = null;
				try {
					String disstart = req.getParameter("sou_dis_start").trim();
					sou_dis_start = java.sql.Timestamp.valueOf(disstart);
				} catch (IllegalArgumentException e) {
					sou_dis_start = new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請加入時間");
				}
				
				java.sql.Timestamp sou_dis_end = null;
				try {
					String disend = req.getParameter("sou_dis_end").trim();
					sou_dis_end = java.sql.Timestamp.valueOf(disend);
				} catch (IllegalArgumentException e) {
					sou_dis_end = new java.sql.Timestamp(System.currentTimeMillis());
					errorMsgs.add("請加入時間");
				}

				

				Double sou_dis_status = null;
				
				try {
					sou_dis_status = new Double(req.getParameter("sou_dis_status").trim());
					if(sou_dis_status < 0) {
						errorMsgs.add("折扣碼要是正數");
					}
				} catch (NumberFormatException e) {
					sou_dis_status = 0.0;
					errorMsgs.add("折扣請填小數點");
				}


				
				
				SouvenirDiscountVO sodVO = new SouvenirDiscountVO();
				sodVO.setSou_dis_name(sou_dis_name);
				sodVO.setSou_dis_start(sou_dis_start);
				sodVO.setSou_dis_end(sou_dis_end);
				sodVO.setSou_dis_status(sou_dis_status);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("sodVO", sodVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_discount/addSouDis.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				SouvenirDiscountService sodSvc = new SouvenirDiscountService();
				sodVO = sodSvc.addSouDis(sou_dis_name, sou_dis_start, sou_dis_end, sou_dis_status);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/souvenir_discount/listAllSouDis.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/souvenir_discount/addSouDis.jsp");
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
				String sou_dis_id = req.getParameter("sou_dis_id");

				/*************************** 2.開始刪除資料 ***************************************/
				SouvenirDiscountService sodSvc = new SouvenirDiscountService();
				sodSvc.deleteSouDis(sou_dis_id);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/souvenir_discount/listAllSouDis.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView;
				failureView = req.getRequestDispatcher("/back-end/souvenir_discount/listAllSouDis.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
		
