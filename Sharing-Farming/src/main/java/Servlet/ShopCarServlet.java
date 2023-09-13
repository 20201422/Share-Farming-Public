package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBean.GoodsDao;
import JavaBean.ShopCarDao;
import Model.Goods;
import Model.ShopCar;

/**
 * Servlet implementation class ShopCarServlet
 */
@WebServlet("/ShopCarServlet")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 response.setContentType("text/html");
	     request.setCharacterEncoding("UTF-8");
	     String optionstr=(String)request.getParameter("Option");
	     int option;
	     if(optionstr!=null)
	    	 option=Integer.parseInt(optionstr);
	     else option=0;
	     
	     HttpSession session=request.getSession();
	     String uno= (String) session.getAttribute("uno");
	     ShopCarDao shopCarDao=new ShopCarDao();
	     ShopCar shopCar=new ShopCar();
	     shopCar.setUno(uno);
	     
	     String Cna;
	     String NumStr;
	     String NextUrl;
	     int num;
	     switch(option)
	     {
	     case 1://从购物界面向购物车添加商品
	    	 
	      	 Cna= (String) request.getParameter("Cna");
	    	 NumStr= (String) request.getParameter("Num");
	    	 num=Integer.parseInt(NumStr);
	    	 shopCarDao.AddCar(new Goods(Cna,num),uno);
	    	 request.getRequestDispatcher("/GoodsInfomationServlet").forward(request,response);
	    	 break;
	     case 2://显示
	    	 shopCar=shopCarDao.getCar(uno);
		     request.setAttribute("ShopCarList", shopCar.getGoodsList());
		     request.getRequestDispatcher("/ShopCar.jsp").forward(request,response);
	    	 break;
	     case 3://修改购物车商品数量
	    	 Cna= (String) request.getParameter("Cna");
	    	
	    	 NextUrl= (String) request.getParameter("NextUrl");
//	    	 NumStr= (String) request.getParameter("Num");
//	    	 num=Integer.parseInt(NumStr);
	    	 shopCar.setGoodsList(HandleCna(Cna,1));
	    	 shopCarDao.UpdateCar(shopCar); 
	    	 //删除购物车购物车商品
	    	 String DeleteCna= (String) request.getParameter("DeleteCna");
	    	 shopCar.setGoodsList(HandleCna(DeleteCna,2));
	    	 shopCarDao.DeleteGoods(shopCar);
	    	 //System.out.println(NextUrl);
	    	 shopCar=shopCarDao.getCar(uno);
		     request.setAttribute("ShopCarList",shopCar.getGoodsList());
		     request.getRequestDispatcher(NextUrl).forward(request,response);
		     break;
	     default:System.out.println("option=null");
	     
	     }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected List<Goods> HandleCna(String Cna,int p)
	{
		
		List<Goods> list=new ArrayList<Goods>();
		if(Cna.equals(""))
		{
			return list;
			
		}
			
		String[] split = Cna.split(",");
		if(p==1)
		{
			for(int i=0;i<split.length;)
			{
				
				Goods goods=new Goods();
				goods.setCna(split[i++]);
				goods.setNum(Integer.parseInt(split[i++]));

				list.add(goods);
			}
		}
		else
		{
			for(int i=0;i<split.length;)
			{
				Goods goods=new Goods();
				goods.setCna(split[i++]);
				list.add(goods);
			}
		}
		
		
		return list;
	}

}
