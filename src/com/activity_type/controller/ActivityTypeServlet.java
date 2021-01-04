package com.activity_type.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activity_type.model.*;

public class ActivityTypeServlet extends HttpServlet {

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
				String act_type_id = req.getParameter("act_type_id");

				/*************************** 2.開始查詢資料 *****************************************/
				ActivityTypeService acttypeSvc = new ActivityTypeService();
				ActivityTypeVO acttypeVO = acttypeSvc.getOneActType(act_type_id);
				if (acttypeVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-sell-end/activity_type/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("acttypeVO", acttypeVO); // 資料庫取出的empVO物件,存入req
				String url = "/front-sell-end/activity_type/listOneActivityType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-sell-end/activity_type/select_page.jsp");
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
				String act_type_id = req.getParameter("act_type_id");

				/*************************** 2.開始查詢資料 ****************************************/
				ActivityTypeService acttypeSvc = new ActivityTypeService();
				ActivityTypeVO acttypeVO = acttypeSvc.getOneActType(act_type_id);
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("acttypeVO", acttypeVO); // 資料庫取出的empVO物件,存入req
				String url = "/front-sell-end/activity_type/update_ActivityType_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/activity_type/listAllActivityType.jsp");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			ActivityTypeVO acttypeVO=null;
			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String act_type_id =req.getParameter("act_type_id");
				String act_type_name=req.getParameter("act_type_name");
				String nameReg = "^[(\u4e00-\u9fa5)]{2,30}$";
				
				if (act_type_name == null || act_type_name.trim().length() == 0) {
					errorMsgs.add("活動名稱: 請勿空白");
				} else if (!act_type_name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("活動名稱只能是中文且長度30");
				}


				acttypeVO = new ActivityTypeVO();
				acttypeVO.setAct_type_id(act_type_id);
				acttypeVO.setAct_type_name(act_type_name);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("acttypeVO", acttypeVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/activity_type/update_ActivityType_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				ActivityTypeService acttypeSvc = new ActivityTypeService();
				acttypeSvc.update(acttypeVO);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("acttypeVO", acttypeVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/front-sell-end/activity_type/listOneActivityType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-sell-end/activity_type/update_ActivityType_input.jsp");
				failureView.forward(req, res);
			}
		}

	        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String act_type_name=req.getParameter("act_type_name");
					String nameReg = "^[(\u4e00-\u9fa5)]{2,30}$";
					
					if (act_type_name == null || act_type_name.trim().length() == 0) {
						errorMsgs.add("活動名稱: 請勿空白");
					} else if (!act_type_name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("活動名稱只能是中文且長度30");
					}

					ActivityTypeVO acttypeVO = new ActivityTypeVO();
					acttypeVO.setAct_type_name(act_type_name);;

					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("acttypeVO", acttypeVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/front-sell-end/activity_type/addActivityType.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					ActivityTypeService acttypeSvc = new ActivityTypeService();
					acttypeSvc.insert(act_type_name);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/front-sell-end/activity_type/listAllActivityType.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-sell-end/activity_type/addActivityType.jsp");
					failureView.forward(req, res);
				}
			}
//			
//			
//			if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//		
//				try {
//					/***************************1.接收請求參數***************************************/
//					Integer empno = new Integer(req.getParameter("empno"));
//					
//					/***************************2.開始刪除資料***************************************/
//					EmpService empSvc = new EmpService();
//					empSvc.deleteEmp(empno);
//					
//					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//					String url = "/emp/listAllEmp.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//					successView.forward(req, res);
//					
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add("刪除資料失敗:"+e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/listAllEmp.jsp");
//					failureView.forward(req, res);
//				}
//			}
//		}
	}
}
