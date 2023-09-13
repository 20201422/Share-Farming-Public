package Servlet;

import JavaBean.ShowMyTillBean;
import Model.Farming;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ShowMyTillServlet", value = "/ShowMyTillServlet")
public class ShowMyTillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShowMyTillBean showMyTillBean=new ShowMyTillBean();
        HttpSession session=request.getSession();

        String uno= (String) session.getAttribute("uno");//得到会员编号
        String searchlna=(String) request.getParameter("searchlna");//得到查询的土地名称
        String searchcheck= (String) request.getAttribute("search-check");//得到查找状态 0为未找到，1为找到

        if(searchlna==null){//不需要查询
            searchlna="";//标记不查找
        }
        else{//需要查询
            if(searchcheck==null){

            }
            else{
                if(Objects.equals(searchcheck, "1")){//查找到土地
                }
                else{//未查找到土地
                    searchlna="";//标记不查找
                }
            }
        }

        request.setAttribute("ShowSFarming", showMyTillBean.ShowSFarming(uno,searchlna));//展示我的自行耕种土地
        request.setAttribute("ShowMFarming", showMyTillBean.ShowMFarming(uno,searchlna));//展示我的托管代种土地

        request.getRequestDispatcher("/MyTill.jsp").forward(request,response);//返回我的耕种jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
