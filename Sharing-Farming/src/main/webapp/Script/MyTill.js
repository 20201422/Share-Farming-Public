function quxiao(lno,fst){
    document.getElementById("qxlno").value=lno;
    document.getElementById("qxfst").value=fst;

    var qr=confirm("确定要取消耕种吗？（不退费）");
    if(qr){
        document.getElementById("quxiao").submit();
    }
}
function search(){
    if(document.getElementById("searchlna").value===""){
        //alert("土地名称不能为空！");
        return true;
    }
    var lna=/^土地\D{1,1}号$/;
    if(!lna.test(document.getElementById("searchlna").value)){
        alert("土地名称错误！");
        document.getElementById("searchlna").value="";
        return false;
    }
}
window.onload=function (){//判断是否为会员
    if(document.getElementById("searchcheck").value==="0"){
        alert("未找到您有该土地！");
    }
    document.getElementById("searchcheck").value=null;
}