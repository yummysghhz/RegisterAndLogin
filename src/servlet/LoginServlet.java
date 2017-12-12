package servlet;

import domain.User;
import service.UserService;
import utils.ErrorCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out = response.getWriter();
//        out.println("LoginServlet");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.loginUser(name, password);

        if (user == null) {
            ErrorCode errorCode = new ErrorCode();
            errorCode.setErrorState(ErrorCode.LOGIN_ERROR);
            Map map = errorCode.parseErrorCode();
            request.setAttribute("errorMap", map);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String hello = "hello, world!";
            session.setAttribute("hello", hello);
            response.sendRedirect("main.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
