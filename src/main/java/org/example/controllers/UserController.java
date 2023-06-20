package org.example.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImp;
import org.example.models.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name = "UserController", urlPatterns = {"/user/list", "/user/add", "/user/remove/*"})
public class UserController extends HttpServlet {
    private final Logger log = Logger.getLogger(UserController.class.getName());

    @EJB
    private UserDaoImp dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String path = req.getServletPath();
        switch (path){
            case "/user/list":
                handleUserList(req, resp);
                break;
            case "/user/add":
                handleUserAdd(req, resp);
                break;
            case "/user/remove":
                handleUserRemove(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String path = req.getServletPath();
        if (path.equals("/user/add")){
            handleUserAddPost(req, resp);
        }
    }

    private void handleUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // wczytuje listę książek z bazy
        List<User> users = dao.findAll();
        // ustawia listę książek jako atrybut pod nazwą "bookList" dostępny na stronie jsp
        request.setAttribute("userList", users);
        // przekazuje sterowanie do strony jsp która renderuje listę książek
        request.getRequestDispatcher("/WEB-INF/views/user/user_list.jsp").forward(request, response);
    }

    private void handleUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getPathInfo();
        Long id = parseId(s);
        User b;
        if (id != null) {
            b = dao.findById(id).orElseThrow(() -> new IllegalStateException("No user with id "+id));
            request.setAttribute("login",b.getLogin());
            request.setAttribute("password",b.getPassword());
            request.setAttribute("email", b.getEmail());
        }
        // przekazuje sterowanie do strony jsp zwracającej formularz z książką
        request.getRequestDispatcher("/WEB-INF/views/user/user_form.jsp").forward(request, response);
    }

    private void handleUserAddPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getPathInfo();
        Long id = parseId(s);

        Map<String,String> fieldToError = new HashMap<>();
        User b = parseUser(request.getParameterMap(),fieldToError);

        if (!fieldToError.isEmpty()) {
            // ustawia błędy jako atrybut do wyrenderowania na stronie z formularzem
            request.setAttribute("errors",fieldToError);
            // ustawia wartości przekazane z formularza metodą POST w atrybutach do wyrenderowania na stronie z formularzem
            request.setAttribute("login",request.getParameter("login"));
            request.setAttribute("password",request.getParameter("password"));
            request.setAttribute("email",request.getParameter("email"));

            // przekazuje sterowanie do widoku jsp w celu wyrenderowania formularza z informacją o błędach
            request.getRequestDispatcher("/WEB-INF/views/user/user_form.jsp").forward(request, response);
            return;
        }

        b.setId(id);
        dao.saveOrUpdate(b);

        // po udanej konwersji/walidacji i zapisie obiektu użytkownik jest przekierowywany (przez HTTP Redirect) na stronę z listą książek
        response.sendRedirect(request.getContextPath() + "/user/list");
    }

    private void handleUserRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = request.getPathInfo();
        Long id = parseId(s);
        dao.remove(id);
        // użytkownik jest przekierowywany (przez HTTP Redirect) na stronę z listą książek
        response.sendRedirect(request.getContextPath() + "/user/list");
    }

    private User parseUser(Map<String,String[]> paramToValue, Map<String,String> fieldToError) {
        String login = paramToValue.get("login")[0];
        String password = paramToValue.get("password")[0];
        String email = paramToValue.get("email")[0];


        if (login == null || login.trim().isEmpty()) {
            fieldToError.put("login","Pole login nie może być puste");
        }

        if (password == null || password.trim().isEmpty()) {
            fieldToError.put("password","Pole password nie może być puste");
        }

        if (email == null || email.trim().isEmpty()) {
            fieldToError.put("email","Pole email nie może być puste");
        }

        return fieldToError.isEmpty() ?  new User(login,password,email) : null;
    }

    private Long parseId(String s) {
        if (s == null || !s.startsWith("/"))
            return null;
        return Long.parseLong(s.substring(1));
    }
}
