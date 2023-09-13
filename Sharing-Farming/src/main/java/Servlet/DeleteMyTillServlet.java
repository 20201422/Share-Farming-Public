package Servlet;

import JavaBean.DeleteMyTillBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteMyTillServlet", value = "/DeleteMyTillServlet")
public class DeleteMyTillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeleteMyTillBean deleteMyTillBean =new DeleteMyTillBean();

        HttpSession session=request.getSession();

        String uno= (String) session.getAttribute("uno");//得到会员编号
        String lno=request.getParameter("qxlno");//得到土地编号
        String fst=request.getParameter("qxfst");//得到耕种类型

        deleteMyTillBean.DeleteFarming(uno,lno,fst);//调用方法取消耕种

        request.getRequestDispatcher("/ShowMyTillServlet").forward(request,response);//返回我的耕种界面

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
