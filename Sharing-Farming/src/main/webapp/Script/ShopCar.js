/**
 * 
 */
 
 var arr = document.getElementsByName("GouXuan");
 var updateGoodsNum=new Array();
 var DeleteGoodsNum="";
 var defaultNextUrl="/ShopCar.jsp";

function alertNull(size)
{
	if(size==0)
	{
		window.location.href="AlertNull.jsp";
	}

}



 function UpdateAll()
{
	var length=updateGoodsNum.length;

	var goodsStr="";
	for(var i=0;i<length;i++)
	{
		if(i!=0)
			goodsStr+=","+updateGoodsNum[i];
		else
			goodsStr=updateGoodsNum[i];
	}
	//alert(goodsStr);
	SubmitForm(goodsStr,DeleteGoodsNum,"3",defaultNextUrl);
}
 function UpdateUrl(NextUrl)
 {
	
	defaultNextUrl=NextUrl;
	//alert(defaultNextUrl);
	UpdateAll();
}
 function SubmitForm(Cna,DeleteCna,Option,NextUrl)
{
	
	document.getElementById( "Cna" ).value = Cna; 
	document.getElementById( "DeleteCna" ).value = DeleteCna; 
	document.getElementById( "Option" ).value = Option; 
	document.getElementById( "NextUrl" ).value = NextUrl; 
	//alert(Cna+Num);
	var formOne = document.getElementById( "formOneId" ); // 获取表单
	formOne.submit(); // 对表单进行提交
}
 
 function oncktest1(th) {
	//判断是否已经全选
	var flag = th.checked;
	//获取所有的单选节点框	
	for (var i in arr) {
		arr[i].checked = flag;
	}
	AllPrice();
}

 
 function oncktest2() {//自动（取消）全选
	//声明flag为真
	var flag = true;
	//获取单选框的元素
	for (var i = 0; i < arr.length - 1; i++) {
		if (!arr[i].checked) {
			flag = false;
			break;
		}
	}
	//当全部都单选都选择时候 全选为true
	arr[arr.length - 1].checked = flag;
 
	AllPrice();
	
 
}
function AllPrice()
{
	var zong = 0;
	var zongNum= 0;
	var oneNum = 0;
	var onePrice = 0;
	for (var i = 0; i < arr.length - 1; i++) 
	{
		if (arr[i].checked) 
		{
			oneNum=arr[i].parentNode.previousElementSibling.children[1].value;
			onePrice=arr[i].parentNode.previousElementSibling;
			onePrice=onePrice.previousElementSibling.innerText;
			zong+=Number(onePrice)*Number(oneNum);
			zongNum+=Number(oneNum);
			
		}
		
	}
	document.getElementById("ppp").innerText = zong;
			//			获取所有商品的数量对象
	document.getElementById("qqq").innerText = zongNum;
	
}
 function oncktest3(th, AddorSubtract) {//控制数量
	
	var pre;
	//减的判断
	if (AddorSubtract == 1) {
		pre = th.nextElementSibling;//获取value的值
		if (pre.value > 1) {
			pre.value = Number(pre.value) - 1;
			AllPrice();//更新价格
		}
	}
	//加的判断
	if (AddorSubtract == 2) {
		pre = th.previousElementSibling;
		pre.value = Number(pre.value) + 1;
		th.parentNode.nextElementSibling.firstElementChild.checked="true";
		oncktest2();//自动勾选
	}
	//数量发生改变，将其同步至updateGoodsNum，在离开界面时通过updateAll更新
	var cna=pre.parentNode.previousElementSibling.previousElementSibling.innerText;
	var iiii=updateGoodsNum.indexOf(cna);
	if(iiii==-1)
	updateGoodsNum.push(cna,pre.value);
	else
	{
		updateGoodsNum[iiii+1]=pre.value;//更新
	}
}
function DeleteGoods()
{
	
	var arrCna = document.getElementsByName("GoodsName");
	for (var i = 0; i < arr.length - 1; i++)
	{
		if (arr[i].checked)
		{

			if(DeleteGoodsNum!=null&&DeleteGoodsNum!="")
			DeleteGoodsNum=DeleteGoodsNum+","+arrCna[i].innerText;
			else
				DeleteGoodsNum=arrCna[i].innerText;
		}

	}
	//一旦发生删除事件，必然要刷新界面，故需更新信息
	UpdateAll();

}
function DealOrders(ust)
{

	if(ust!=1)
	{
		alert("您还不是会员，请审核通过后再结算！");
		return;
	}
	var ordersStr="";
	var arrCna = document.getElementsByName("GoodsName");
	var arrCpr = document.getElementsByName("currentGoods");
	
	for (var i = 0; i < arr.length - 1; i++) 
	{
		if (arr[i].checked) 
		{
			if(ordersStr!=null&&ordersStr!="")
			ordersStr=ordersStr+","+arrCna[i].innerText;
			else
			ordersStr=arrCna[i].innerText;
			ordersStr+=	","+arrCpr[i].value;
		}
		
		
	}
	if(ordersStr=="")
	alert("请选择商品！");
	else
	{
		
		document.getElementById("GoodsCna").value=ordersStr;
		document.getElementById("AllNum").value=document.getElementById("qqq").innerText;
		document.getElementById("GoodsPrice").value=document.getElementById("ppp").innerText;
		document.getElementById( "Option2" ).value ="1"; 
		var formTwo = document.getElementById( "formTwoId" ); // 获取表单
		formTwo.submit(); // 对表单进行提交
	}
	
}


 
$(function(){
                //propertychange监听input里面的字符变化,属性改变事件
                $('.aa').bind('input propertychange', function() {
                    var $this = $(this);
                    console.log($this);
                    var text_length = $this.val().length;//获取当前文本框的长度
                    var current_width = parseInt(text_length) *16;//该16是改变前的宽度除以当前字符串的长度,算出每个字符的长度
                    console.log(current_width)
                    $this.css("width",current_width+"px");
                });
            })

