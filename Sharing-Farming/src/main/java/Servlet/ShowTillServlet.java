package Servlet;

import JavaBean.ShowTillBean;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowTillServlet", value = "/ShowTillServlet")
public class ShowTillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();

        ShowTillBean showTillBean = new ShowTillBean();
        User user=(User) session.getAttribute("user");

        //String uno= user.getNo();//得到会员编号

        if(user==null){
        }
        else{
            //session.setAttribute("uno",uno);//保存用户编号
            String uno= user.getUno();//找到用户编号
            String una= user.getUna();//找到用户名称
            String ust= String.valueOf(user.getUst());//找到用户状态
            session.setAttribute("uno",uno);//保存用户名称
            session.setAttribute("una",una);//保存用户名称
            session.setAttribute("ust",ust);//保存用户状态
        }

        request.setAttribute("ShowLand", showTillBean.ShowLand());//展示耕地

        request.getRequestDispatcher("/Till.jsp").forward(request,response);//返回耕种jsp

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
