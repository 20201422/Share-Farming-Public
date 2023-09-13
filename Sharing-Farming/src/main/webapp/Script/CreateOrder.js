function myFunc() { 

       window.location.href="ShopCarServlet?Option=2"; 

      } 
	function DealOrders()
	{
		
		var address=document.getElementById("Address").value;;
		var contact=document.getElementById("Contact").value;
		var uname=document.getElementById("UName").value;
		var pei="";
		var obj = document.getElementsByName("s2");
	    for(var i=0; i<2; i ++)
	    {
	        if(obj[i].checked)
	        {
	        	pei=obj[i].value;
	        }
	    }
		if(pei == "" || address == null || contact == null || uname == null)
		{
			alert("请完善信息后再支付！");
		}
		else
		{

			document.getElementById("uname").value=uname;
			document.getElementById("contact").value=contact;
			document.getElementById("address").value=address;
			document.getElementById("peison").value=pei;
			document.getElementById( "Option" ).value ="1";
			var formTwo = document.getElementById( "formTwoId" ); // 获取表单
			formTwo.submit(); // 对表单进行提交
		}

	   //
	}