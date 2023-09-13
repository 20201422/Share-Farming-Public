package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import JavaBean.ProgressReportBean;
import Model.Report;

/**
 * Servlet implementation class ProgressReportServlet
 */
@WebServlet("/ProgressReportServlet")
public class ProgressReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgressReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String lno=request.getParameter("lno");
		String plant=request.getParameter("plant");
		String ano=request.getParameter("ano");
		String work=request.getParameter("work");
		String date=request.getParameter("date");
		String detail=request.getParameter("detail");
		Report report=new Report(lno,plant,ano,work,date,detail);
		ProgressReportBean pr=new ProgressReportBean();
		pr.SaveReport(report);
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>alert('已通过该申请')</script>");
		out.println("<script type='text/javascript'>history.back()</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
