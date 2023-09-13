package Servlet;

import JavaBean.ChangeInfoBean;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 修改个人信息servlet
 */
@WebServlet("/changeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {

    private ChangeInfoBean changeInfoBean = new ChangeInfoBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        user.setUemil(email);
        user.setUna(name);
        user.setUpwd(password);
        changeInfoBean.updateInfo(user);
        req.getRequestDispatcher("logoutServlet").forward(req, resp);
    }
}
