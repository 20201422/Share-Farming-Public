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

import JavaBean.OrdersDao;
import JavaBean.ShopCarDao;
import Model.Goods;
import Model.Order;
import Model.ShopCar;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
	     OrdersDao ordersDao=new OrdersDao();
	     List<Order> orderList;
	     switch(option)
	     {
	     case 1://提交订单
	    	 //System.out.println("提交订单");
	    	String  GoodsCna=(String)request.getParameter("GoodsCna");
	    	String  GoodsPrice=(String)request.getParameter("GoodsPrice");
	    	String  pei=(String)request.getParameter("peison");
	    	String  uname=(String)request.getParameter("uname");
	    	String  contact=(String)request.getParameter("contact");
	    	String  address=(String)request.getParameter("address");
	    	float Price=Float.parseFloat(GoodsPrice);
	    	int QuHuoFangShi=0;
	    	System.out.println("uname:"+uname);
	    	if(pei.equals("0"))//邮寄
	    		QuHuoFangShi=0;
	    	else if(pei.equals("1"))//自提
	    	{
	    		QuHuoFangShi=1;
	    		address="共享农庄自提点";
	    	}
	    	Order tiOrder=new Order(QuHuoFangShi,uno,contact,address,Price,uname);
	    	ordersDao.insertOrder(GoodsCna, tiOrder);
	    	orderList=ordersDao.getAllOrder(uno);

            //删除购物车信息
			 ShopCarDao shopCarDao=new ShopCarDao();
			 ShopCar shopCar=new ShopCar();
			 shopCar.setUno(uno);
			 shopCar.setGoodsList(HandleCna(GoodsCna));
			 shopCarDao.DeleteGoods(shopCar);
             System.out.println(orderList.size()+"hjjjj");
	 		request.setAttribute("orderList", orderList);
	 	    request.getRequestDispatcher("/Orders.jsp").forward(request,response);
	    	 break;
	     case 2://显示
	    	 
	 		orderList=ordersDao.getAllOrder(uno);
	 		request.setAttribute("orderList", orderList);
	 	    request.getRequestDispatcher("/Orders.jsp").forward(request,response);
	    	 break;
	    	 
	     case 3://删除
	    	 	String  Ono=(String)request.getParameter("Ono");
	    	 	ordersDao.DeleteOrder(Ono);
		 		orderList=ordersDao.getAllOrder(uno);
		 		request.setAttribute("orderList", orderList);
		 	    request.getRequestDispatcher("/Orders.jsp").forward(request,response);
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
	
    protected List<Goods> HandleCna(String Cna)
	{
		//System.out.println("Handle"+Cna);
		List<Goods> list=new ArrayList<Goods>();
		if(Cna.equals(""))
		{
			//System.out.println("未修改or未删除");
			return list;

		}

		String[] split = Cna.split(",");

		{
			for(int i=0;i<split.length;)
			{
				//System.out.println("Handle"+split[i]);
				Goods goods=new Goods();
				goods.setCna(split[i++]);
				list.add(goods);
			}
		}


		return list;
	}
	
}
