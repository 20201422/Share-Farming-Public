package Servlet;

import JavaBean.LoginAndRegistBean;
import Model.Admin;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private LoginAndRegistBean loginAndRegistBean = new LoginAndRegistBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 dao登录处理业务
        User loginUser = loginAndRegistBean.queryUserByUsernameAndPassword(username, password);
        Admin admin = loginAndRegistBean.queryAdminByUsernameAndPassword(username, password);
        // 如果等于null,说明登录 失败!
        if (loginUser == null && admin == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            //   跳回登录页面
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else if (loginUser == null && admin != null){
            // 处理管理员
            req.getRequestDispatcher("Admin_Home.jsp").forward(req, resp);
        } else {
            // 登录 成功
            req.getSession().setAttribute("user", loginUser);
            //跳到成功页面index.jsp
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
