package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberDeleteController
 */
public class MemberDeleteController implements Controller {
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String contextPath = request.getContextPath();
		
		MemberDAO dao = new MemberDAO();
		int n = dao.deleteMember(userId);
		
		if(n<=0) {
			out.println("<script>alert('멤버 삭제 실패');</script>");
		}
		
		response.sendRedirect(contextPath+"/members/memberList");
	}



}
