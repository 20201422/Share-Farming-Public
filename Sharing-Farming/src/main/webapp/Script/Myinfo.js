$(function () {

    // 给注册绑定单击事件
    $("#sub_btn").click(function () {

        // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var passwordText = $("#password").val();
        //2 创建正则表达式对象
        var passwordPatt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!passwordPatt.test(passwordText)) {
            //4 提示用户结果
            $("span.errorMsg").text("密码由字母，数字下划线组成，并且长度为5到12位！");

            return false;
        }

        // 邮箱验证：xxxxx@xxx.com
        //1 获取邮箱里的内容
        var emailText = $("#email").val();
        //2 创建正则表达式对象
        var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
        //3 使用test方法验证是否合法
        if (!emailPatt.test(emailText)) {
            //4 提示用户
            $("span.errorMsg").text("邮箱格式不合法！");

            return false;
        }

        // 去掉错误信息
        $("span.errorMsg").text("");

        return confirm("您确定修改？（修改后无法撤销）");

    });

    $("#destroy").click(function () {
        return confirm("您确定要注销您的账户吗？注销后您的数据将被删除且不可恢复！");
    });

});