package by.it_academy.jd2.hw.example.messenger.controller;

import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.view.api.IAuthView;
import by.it_academy.jd2.hw.example.messenger.view.api.IUserView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * Process requests related with users
 * @author Maksim Perekladov
 * @version 2.0
 */

@Controller
@SessionAttributes(value = "user")
public class UserSpringServlet {

    private final IAuthView authView;
    private final IUserView userView;

    UserSpringServlet(IAuthView authView, IUserView userView) {
        this.authView = authView;
        this.userView = userView;
    }

    @GetMapping("/signIn")
    protected String getSignInPage() {
        return "/views/signIn.jsp";
    }

    @PostMapping("/signIn")
    protected String signIn(@RequestParam(name = "login") String login,
                            @RequestParam(name = "password") String password,
                            HttpServletRequest req) {
        User user;
        try {
            user = authView.authentication(login, password);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            return "/views/signIn.jsp";
        }
        if (user == null) {
            req.setAttribute("error", true);
            req.setAttribute("message", "Логин или пароль неверен");
            return "/views/signIn.jsp";
        } else {
            req.getSession().setAttribute("user", user);
            return "redirect: " + req.getContextPath() + "/";
        }
    }

    @GetMapping("/signUp")
    protected String getSignUpPage() {
        return "/views/signUp.jsp";
    }

    @PostMapping("/signUp")
    protected String signIn(@RequestParam(name = "login") String login,
                            @RequestParam(name = "password") String password,
                            @RequestParam(name = "fio") String fio,
                            HttpServletRequest req) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);

        try {
            this.userView.signUp(user);
            req.getSession().setAttribute("user", user);
            ;
            return "redirect: " + req.getContextPath() + "/";
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            return "/views/signUp.jsp";
        }
    }

    @GetMapping("/admin/users")
    protected void getAllUsers(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=UTF-8");
        Collection<User> users = userView.getAll();
        for (User user : users) {
            writer.println(user);
        }
    }

    @GetMapping("/logout")
    protected String logOut(HttpServletRequest req, SessionStatus sessionStatus) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            sessionStatus.setComplete();
        }
        return "redirect: " + req.getContextPath() + "/";
    }
}
