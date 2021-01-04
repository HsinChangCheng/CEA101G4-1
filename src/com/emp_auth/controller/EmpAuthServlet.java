package com.emp_auth.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp_auth.model.EmpAuthService;
import com.emp_auth.model.EmpAuthVO;

public class EmpAuthServlet extends HttpServlet {


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
					String str = req.getParameter("emp_id");
					if (str == null || (str.trim()).length() == 0) {
						errorMsgs.add("請輸入員工編號");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/select_page.jsp");
						failureView.forward(req, res);
						return;// 程式中斷
					}

					String emp_id = null;
					try {
						emp_id = str;
					} catch (Exception e) {
						errorMsgs.add("員工編號格式不正確");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/select_page.jsp");
						failureView.forward(req, res);
						return;// 程式中斷
					}

					/*************************** 2.開始查詢資料 *****************************************/
					EmpAuthService empAuthSvc = new EmpAuthService();
					EmpAuthVO empAuthVO = empAuthSvc.getOneEmpAuth(emp_id);
					if (empAuthVO == null) {
						errorMsgs.add("查無資料");
					}
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/select_page.jsp");
						failureView.forward(req, res);
						return;// 程式中斷
					}

					/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
					req.setAttribute("empAuthVO", empAuthVO); // 資料庫取出的empVO物件,存入req
					String url = "/back-end/emp_auth/listOneEmpAuth.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
					successView.forward(req, res);

					/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
					errorMsgs.add("無法取得資料:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/select_page.jsp");
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
					String emp_id = req.getParameter("emp_id").trim();
					String func_id = req.getParameter("func_id").trim();
					
			

					EmpAuthVO empAuthVO = new EmpAuthVO();
					empAuthVO.setEmp_id(emp_id);
					empAuthVO.setFunc_id(func_id);
					
			
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("empAuthVO", empAuthVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/addEmpAuth.jsp");
						failureView.forward(req, res);
						return;
					}

					/*************************** 2.開始新增資料 ***************************************/
					EmpAuthService empAuthSvc = new EmpAuthService();
					empAuthVO = empAuthSvc.addEmpAuth(emp_id,func_id);

					/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
					String url = "/back-end/emp_auth/listAllEmpAuth.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);

					/*************************** 其他可能的錯誤處理 **********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp_auth/addEmpAuth.jsp");
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
					String emp_id = req.getParameter("emp_id");
					String func_id = req.getParameter("func_id");
					/*************************** 2.開始刪除資料 ***************************************/
					EmpAuthService empAuthSvc = new EmpAuthService();
					empAuthSvc.deleteEmpAuth(emp_id, func_id);

					/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
					String url = "/back-end/emp_auth/listAllEmpAuth.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);

					/*************************** 其他可能的錯誤處理 **********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:" + e.getMessage());
					RequestDispatcher failureView;
					failureView = req.getRequestDispatcher("/back-end/emp_auth/listAllEmpAuth.jsp");
					failureView.forward(req, res);
				}
			}
		}



}
