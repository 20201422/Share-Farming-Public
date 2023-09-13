package Servlet;

import JavaBean.ProgressReportBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowReportServlet", value = "/ShowReportServlet")
public class ShowReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProgressReportBean progressReportBean=new ProgressReportBean();

        String lno=request.getParameter("lno");//得到土地编号

        request.setAttribute("ShowReport",progressReportBean.ShowReport(lno));//调用展示报告方法

        request.getRequestDispatcher("/ShowReport.jsp").forward(request,response);//返回查看报告jsp

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
