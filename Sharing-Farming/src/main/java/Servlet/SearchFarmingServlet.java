package Servlet;

import JavaBean.ShowMyTillBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchFarmingServlet", value = "/SearchFarmingServlet")
public class SearchFarmingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShowMyTillBean showMyTillBean=new ShowMyTillBean();
        HttpSession session=request.getSession();

        String uno= (String) session.getAttribute("uno");//得到会员编号
        String searchlna=(String) request.getParameter("searchlna");//得到查询的土地名称

        if(searchlna==null|| searchlna.equals("")){//不需要查询
        }
        else{//需要查询
            if(showMyTillBean.SearchLand(uno, searchlna)){//找到土地
                String check="1";
                request.setAttribute("search-check",check);
            }
            else{//未找到土地
                String check="0";
                request.setAttribute("search-check",check);
            }
        }

        request.getRequestDispatcher("/ShowMyTillServlet").forward(request,response);//返回我的耕种

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
