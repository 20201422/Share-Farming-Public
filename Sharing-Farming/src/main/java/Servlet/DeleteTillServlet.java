package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.DeleteTillBean;

/**
 * Servlet implementation class DeleteTiIlServlet
 */
@WebServlet("/DeleteTillServlet")
public class DeleteTillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTillServlet() {
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
		String Lno=request.getParameter("Lno");
		DeleteTillBean dt=new DeleteTillBean();
		int lst=dt.JudgeLand(Lno);
		PrintWriter out=response.getWriter();
		if(lst==3) {
			out.println("<script type='text/javascript'>alert('该地已被租出，不可下架！')</script>");
			out.println("<script type='text/javascript'>history.back()</script>");
		}else {
			dt.DeleteLand(Lno);
			out.println("<script type='text/javascript'>alert('下架成功！')</script>");
			out.println("<script type='text/javascript'>history.back()</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
