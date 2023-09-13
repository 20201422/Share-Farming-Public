package Servlet;

import JavaBean.LoginAndRegistBean;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/forgetServlet")
public class ForgetPasswordServlet extends HttpServlet {

    LoginAndRegistBean loginAndRegistBean = new LoginAndRegistBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = loginAndRegistBean.queryUserByEmail(email);
        if (user == null) {
            req.setAttribute("msg", "邮箱输入错误!");
            req.getRequestDispatcher("ForgetPassword.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("str", user.getUno());
            req.getRequestDispatcher("ModifyPassword.jsp").forward(req, resp);
        }
    }
}
