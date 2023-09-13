<%@ page import="java.util.Objects" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
    <%
	String  GoodsCna=(String)request.getParameter("GoodsCna");
	String  AllNum=(String)request.getParameter("AllNum");
	String  GoodsPrice=(String)request.getParameter("GoodsPrice");
		String uno= (String) session.getAttribute("uno");//得到会员编号
		String una= (String) session.getAttribute("una");//得到会员名字
		String ust= (String) session.getAttribute("ust");//得到会员状态

	String[] split={};
	if(GoodsCna.equals(""))
	{
		System.out.println("GoodsCna空");

	}
	else
	{
		split = GoodsCna.split(",");
	}
	int size=0;
	if(split.length!=0)
		size=split.length;
	%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>共享农庄平台-提交订单</title>
	<script type="text/javascript" language="JavaScript" src="Script/CreateOrder.js"></script>
	<link rel="stylesheet" type="text/css" href="CSS/CreateOrder.css" />
	<link rel="stylesheet" type="text/css" href="CSS/HeaderandFooter.css" />
</head>
<body id="d1">
<header>
	<%
		if(uno==null||uno==""){//未登录
	%>
	<div class="head_welcome">您好，<a href="Login.jsp" class="wa">请登录</a>（支持IPv6访问）</div>
	<%
	}else{//已登录
		if(Objects.equals(ust, "0")){//不是会员
	%>
	<div class="head_welcome">您好,<%=una%>（您还不是会员）&nbsp<a href="logoutServlet" class="wa">[退出]</a></div>
	<input type="hidden" value="<%=uno%>" name="uno">
	<%
	}else{
	%>
	<div class="head_welcome">您好,<%=una%>&nbsp<a href="logoutServlet" class="wa">[退出]</a></div>
	<input type="hidden" value="<%=uno%>" name="uno">
	<%
			}
		}
	%>
	<div class="header">共享农庄平台</div>
	<nav class="menu">
		<p><a href="ShowTillServlet">耕种</a></p>
		<p><a href="GoodsInfomationServlet">购物</a></p>
		<%
			if(uno==null||uno==""){//未登录
		%>
		<p><a href="Login.jsp">购物车</a></p>
		<p><a href="Login.jsp">我的耕种</a></p>
		<p><a href="Login.jsp">我的订单</a></p>
		<p><a href="Login.jsp">我的信息</a></p>
		<%
		}else{//已登录
		%>
		<p><a href="ShopCarServlet?Option=2">购物车</a></p>
		<p><a href="ShowMyTillServlet">我的耕种</a></p>
		<p><a href="OrdersServlet?Option=2">我的订单</a></p>
		<p><a href="showInfoServlet">我的信息</a></p>
		<%
			}
		%>
	</nav>
</header>



<div class="createorder">
	<div class="h4">
		<h4>商品详情</h4>
	</div>
	<div class="first">
		<div id="div1">
			<table class="first-div1">
				<tr><th>商品</th><th>数量</th></tr>
				<% for(int i=0;i<size;)
				{%>
				<tr>
					<td name="GoodsName"><%=split[i++]%></td>
					<td name="GoodsNum"><%=split[i++]%></td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>
	<div class="h4">
		<h4>请填写您的收货信息</h4>
	</div>
	<div class="second">
		<div id="shou">
			<table id="c3">
				<tr>
					<td>收货人姓名：</td>
					<td><input type="text" id="UName"/></td>
<%--					<td><span>*收货人姓名</span></td>--%>
				</tr>
				<tr>
					<td>收货地址：</td>
					<td><input type="text" id="Address" placeholder="自提可不填"/></td>
<%--					<td><span>*收货人详细地址</span></td>--%>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input type="text" id="Contact" /></td>
<%--					<td><span>*收货人的手机号码</span></td>--%>
				</tr>
			</table>
		</div>
	</div>
	<div class="h4">
		<h4>请选择您的支付方式</h4>
	</div>
	<div class="third">
		<div id="zhi">
			<table id="a1">
				<tr>
					<td><input type="radio" name="s1" />货到付款</td>
					<td><input type="radio" name="s1" />支付宝</td>
					<td><input type="radio" name="s1" />微信</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="h4">
		<h4>请选择配送方式</h4>
	</div>
	<div class="forth">
		<div id="pei">
			<table id="a2">
				<tr>
					<td><input type="radio" name="s2" value="0"/>邮寄</td>
					<td><input type="radio"  name="s2" value="1"/>自提</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="h4">
		<h4>提交订单</h4>
	</div>
	<div class="fifth">
		<div class="caozuo">
			<button type="button" id="qu" onclick="myFunc()">取消订单</button>
			<button type="button" id="que" onclick="DealOrders()">支付<%=GoodsPrice %>元</button>
		</div>
	</div>

	<form name = "formTwo" action ="OrdersServlet" id= "formTwoId" mothed= "post" />
	<input id= "address" type= "hidden" name = "address" >
	<input id= "contact" type= "hidden" name = "contact" >
	<input id= "uname" type= "hidden" name = "uname" >
	<input id= "peison" type= "hidden" name = "peison" >
	<input id= "GoodsCna" type= "hidden" name = "GoodsCna" value="<%=GoodsCna%>">
	<input id= "GoodsPrice" type= "hidden" name = "GoodsPrice" value="<%=GoodsPrice%>">
	<input id= "Option" type= "hidden" name = "Option" >
	</form>
</div>

<footer>
	<hr>
	<div class="footer-help">
		需要更多帮助？致电 400-820-XXXX。
	</div>
	<div class="footer">
		<p>共享农庄平台采用符合业界标准的加密技术对您提交的信息进行保密。</p>
		<hr>
		Copyright ©️ 2022 202014-5 lnc.保留所有权利<br>
		蒙 ICP备2023001109号
	</div>
</footer>
</body>
</html>

