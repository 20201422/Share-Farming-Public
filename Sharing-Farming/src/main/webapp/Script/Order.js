/**
 * 
 */
 var arrCna = document.getElementsByName("GoodsName");
 
 function deleteOrder(th)
 {
	var Ono;
	 var arrbtn1 = document.getElementsByName("btn1");
	  var arrth1 = document.getElementsByName("th1");
	 for (var i = 0; i < arrbtn1.length; i++)
	 {
		
		if(th==arrbtn1[i])
		{
			Ono=arrth1[i].innerText;
			break;
		}
		
	 } 
	 document.getElementById( "Ono" ).value =Ono; 
	 var formOne = document.getElementById( "formOneId" ); // 获取表单
	formOne.submit(); // 对表单进行提交
	
 }
function alertNull(size)
{

	if(size==0)
	{
		window.location.href="AlertNull.jsp";
	}

}