package Servlet;

import JavaBean.PayBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PayBean payBean=new PayBean();

        String lno=request.getParameter("lno");//得的土地编号

        payBean.PayFarming(lno);//修改土地状态为可耕种

        request.getRequestDispatcher("/ShowMyTillServlet").forward(request,response);//返回我的耕种界面
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
