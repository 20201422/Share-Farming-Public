function queding(){
    if(document.getElementById("ust").value==="0"){
        alert("您还不是会员，请审核通过后再耕种！");
    }
    else{
        var qr=confirm("按月扣费，可随时取消耕种，但若当月已扣费将不退费");
        if(qr){
            document.getElementById("queding").submit();
        }
    }
}
// window.onload=function (){//判断是否为会员
//     if(document.getElementById("ust").value==="0"){
//         alert("您还不是会员，请审核通过后再耕种！");
//     }
// }