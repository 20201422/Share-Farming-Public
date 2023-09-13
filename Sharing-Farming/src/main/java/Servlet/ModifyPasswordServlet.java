package Servlet;

import JavaBean.LoginAndRegistBean;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyPassword")
public class ModifyPasswordServlet extends HttpServlet {

    LoginAndRegistBean loginAndRegistBean = new LoginAndRegistBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_pwd = req.getParameter("new_pwd");
        String str = (String) req.getSession().getAttribute("str");
        loginAndRegistBean.modifyPasswordByUsername(str, new_pwd);
        req.setAttribute("msg", "密码修改成功!");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}
