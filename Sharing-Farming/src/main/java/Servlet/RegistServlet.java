package Servlet;

import JavaBean.LoginAndRegistBean;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {

    private LoginAndRegistBean loginAndRegistBean = new LoginAndRegistBean();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String status = req.getParameter("status");
        Integer st = Integer.parseInt(status);

        User user = new User(username, name, password, email, st);

//      检查 用户名是否可用
        if (loginAndRegistBean.existsUsername(username)) {
            System.out.println("用户名[" + username + "]已存在!");

            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "用户名已存在！！");

//        跳回注册页面
            req.getRequestDispatcher("Regist.jsp").forward(req, resp);
        } else {
            //      可用
//                调用Sservice保存到数据库
            loginAndRegistBean.saveUser(user);
            req.setAttribute("msg", "注册成功！");
//
//        跳到注册成功页面 regist_success.jsp
            req.getRequestDispatcher("regist_success.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
