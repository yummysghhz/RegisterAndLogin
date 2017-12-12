package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import utils.ErrorCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//        PrintWriter out = response.getWriter();
//        out.println("RegisterServlet");

//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");

        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService = new UserService();
        ErrorCode errorCode = userService.registUser(user);

        HashMap<String, String> map = errorCode.parseErrorCode();
        if (map == null) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMap", map);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
