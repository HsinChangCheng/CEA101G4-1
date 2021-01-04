package com.replyreport.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.replyreport.model.*;

public class ReplyReportServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自front_select_reply.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("reportId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入評論檢舉編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-mem-end/replyreport/front_select_reply.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				String reportId = null;
				try {
					reportId = new String(str);
				} catch (Exception e) {
					errorMsgs.add("評論檢舉編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-mem-end/replyreport/front_select_reply.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				ReplyReportService replyReportSvc = new ReplyReportService();
				ReplyReportVO replyReportVO =replyReportSvc.getOneReplyReport(reportId);
				if (replyReportVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-mem-end/replyreport/front_select_reply.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("replyReportVO", replyReportVO); // 資料庫取出的replyReportVO物件,存入req
				String url = "/front-mem-end/replyreport/listOneReplyReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneReplyReport.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-mem-end/replyreport/front_select_reply.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllReplyReport.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String reportId = req.getParameter("reportId");
				
				/***************************2.開始查詢資料****************************************/
				ReplyReportService replyReportSvc = new ReplyReportService();
				ReplyReportVO replyReportVO = replyReportSvc.getOneReplyReport(reportId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("replyReportVO", replyReportVO);         // 資料庫取出的replyReportVO物件,存入req
				String url = "/front-mem-end/replyreport/update_replyreport_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_replyreport_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-mem-end/replyreport/listAllReplyReport.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自update_replyreport_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String reportId = req.getParameter("reportId");

				
				String empId = req.getParameter("empId");
				String empIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{5}$";
				if (empId == null || empId.trim().length() == 0) {
					errorMsgs.add("活動編號: 請勿空白");
				} else if(!empId.trim().matches(empId)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("活動編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				String memId = req.getParameter("memId");
				String memIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{6}$";
				if (memId == null || memId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if(!memId.trim().matches(memIdReg)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				String replyId = req.getParameter("replyId");
				String replyIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{6}$";
				if (replyId == null || replyId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if(!replyId.trim().matches(replyIdReg)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				Integer reportResult = null;
				try {
					reportResult = new Integer(req.getParameter("reportResult"));
					if(reportResult != 0 && reportResult != 1) {
						errorMsgs.add("請填數字0或1");
						}
				} catch (NumberFormatException e) {			
					errorMsgs.add("請填數字0或1");

				}


				ReplyReportVO replyReportVO = new ReplyReportVO();
				replyReportVO.setReportId(reportId);
				replyReportVO.setEmpId(empId);
				replyReportVO.setMemId(memId);
				replyReportVO.setReplyId(replyId);
				replyReportVO.setReportResult(reportResult);
	
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("replyReportVO", replyReportVO); // 含有輸入格式錯誤的replyReportVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-mem-end/replyreport/update_replyreport_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				ReplyReportService replyReportSvc = new ReplyReportService();
				replyReportVO = replyReportSvc.updateReplyReport(reportId, empId, memId, replyId, reportResult);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("replyReportVO", replyReportVO); // 資料庫update成功後,正確的的replyReportVO物件,存入req
				String url = "/front-mem-end/replyreport/listOneReplyReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneReplyReport.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-mem-end/replyreport/update_report_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addReplyReport.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String empId = req.getParameter("empId");
				String empIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{5}$";
				if (empId == null || empId.trim().length() == 0) {
					errorMsgs.add("活動編號: 請勿空白");
				} else if(!empId.trim().matches(empId)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("活動編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				String memId = req.getParameter("memId");
				String memIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{6}$";
				if (memId == null || memId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if(!memId.trim().matches(memIdReg)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				String replyId = req.getParameter("replyId");
				String replyIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{6}$";
				if (replyId == null || replyId.trim().length() == 0) {
					errorMsgs.add("會員編號: 請勿空白");
				} else if(!replyId.trim().matches(replyIdReg)) { 
					//以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員編號: 只能是大寫英文字母+數字 , 且長度必需是5");
	            }
				
				Integer reportResult = null;
				try {
					reportResult = new Integer(req.getParameter("reportResult"));
					if(reportResult != 0 && reportResult != 1 && reportResult != 2) {
						errorMsgs.add("請填檢舉結果");
						}
				} catch (NumberFormatException e) {			
					errorMsgs.add("請填數字0或1或2");

				}
				

				ReplyReportVO replyReportVO = new ReplyReportVO();
				replyReportVO.setEmpId(empId);
				replyReportVO.setMemId(memId);
				replyReportVO.setReplyId(replyId);
				replyReportVO.setReportResult(reportResult);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("replyReportVO", replyReportVO); // 含有輸入格式錯誤的replyReportVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-mem-end/replyreport/addReplyReport.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ReplyReportService replyReportSvc = new ReplyReportService();
				replyReportVO = replyReportSvc.addReplyReport(empId, memId, replyId, reportResult);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/front-mem-end/replyreport/listAllReplyReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllReplyReport.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-mem-end/replyreport/addReplyReport.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllReplyReport.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				String reportId = req.getParameter("reportId");
				
				/***************************2.開始刪除資料***************************************/
				ReplyReportService replyReportSvc = new ReplyReportService();
				replyReportSvc.deleteReplyReport(reportId);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/front-mem-end/replyreport/listAllReplyReport.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-mem-end/replyreport/listAllReplyReport.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
