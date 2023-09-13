/**
 * 
 */
 function buy(Cna,uno)
 {

	 if(uno==null||uno=="")
	 {

		 window.location.href="Login.jsp";
		 return;
	 }

	var num=prompt("请选择数量","1");
	if(num<=0)
	;
	else
	{
		document.getElementById( "Cna" ).value = Cna; 
		document.getElementById( "Num" ).value = num; 
		document.getElementById( "Option" ).value = "1"; 
		//alert(Cna+num);
		var formOne = document.getElementById( "formOneId" ); // 获取表单
		formOne.submit(); // 对表单进行提交
	}
	
}
