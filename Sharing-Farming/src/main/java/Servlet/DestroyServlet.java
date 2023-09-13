package Servlet;

import JavaBean.LoginAndRegistBean;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/destroyServlet")
public class DestroyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginAndRegistBean loginAndRegistBean = new LoginAndRegistBean();
        User user = (User) req.getSession().getAttribute("user");
        loginAndRegistBean.deleteUserByUno(user.getUno());
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
}
