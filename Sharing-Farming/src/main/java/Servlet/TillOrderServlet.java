package Servlet;

import JavaBean.TillOrderBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "TillOrderServlet", value = "/TillOrderServlet")
public class TillOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TillOrderBean tillOrderBean=new TillOrderBean();
        HttpSession session=request.getSession();

        String uno= (String) session.getAttribute("uno");//得到会员编号
        String lno= request.getParameter("lno");//得到土地编号
        String fst= request.getParameter("fst");//得到耕种的土地类型
        String fday= request.getParameter("fday");//得到耕种天数
        String ftp= request.getParameter("ftp");//得到支付方式
        String lx= request.getParameter("lx");//订单类型

        if(Objects.equals(lx, "0")){//不是续租
            if(Objects.equals(fst, "自行耕种")){
                tillOrderBean.TillSFarming(lno,uno,fday,ftp,fst);//调用方法自行耕种
            }
            else if(Objects.equals(fst, "托管代种")){
                String pno= request.getParameter("pno");//得到植物编号
                tillOrderBean.TillMFarming(lno,uno,pno,fday,ftp,fst);//调用方法托管代种
            }
        }
        else{//续租
            String pno= request.getParameter("pno");//得到植物编号
            tillOrderBean.TillAgain(lno,fday,pno,ftp);//调用方法续租
        }

        request.getRequestDispatcher("/ShowMyTillServlet").forward(request,response);//返回我的耕种界面
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
