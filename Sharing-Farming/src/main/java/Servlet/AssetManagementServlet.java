package Servlet;

import JavaBean.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AssetManagementServlet", value = "/AssetManagementServlet")
public class AssetManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShowTillBean showTillBean=new ShowTillBean();
        TillOrderBean tillOrderBean=new TillOrderBean();
        GoodsDao goodsDao=new GoodsDao();

        request.setAttribute("Land",showTillBean.ShowLand());//调用方法得到土地
        request.setAttribute("Plant",tillOrderBean.ShowPlant());//调用方法得到植物
        request.setAttribute("Crops",goodsDao.getGoodsList());//调用方法得到农作物

        request.getRequestDispatcher("/AssetManagement.jsp").forward(request,response);//返回资产jsp

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
