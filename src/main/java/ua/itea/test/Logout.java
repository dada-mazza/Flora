package ua.itea.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// лінк переходу на логаут зробити на лінк сервлета (а не jsp)

public class Logout extends HttpServlet {

    //логгер
    protected Log log = LogFactory.getLog(Logout.class);

    // при переході по лінку відпрацює get запит
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            // якщо користувач зареєстрований відкриваємо сторінку виходу
            log.info("redirect : " + "/megamarket/exit.jsp");
            response.sendRedirect("/megamarket/exit.jsp");
            return;
        } else {
            // якщо ні посилаємо кудись
            log.info("redirect : " + "/megamarket/index.jsp");
            response.sendRedirect("/megamarket/index.jsp");
            return;
        }
    }

    // при переході по кнопці форма відправить пост запит
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String button = request.getParameter("clickEvent");
        HttpSession hs = request.getSession();

        // перевіряємо кнопку
        if (button != null && button.equals("yes")) {
            // в сесії видаляємо юзвіра
            hs.setAttribute("user", null);
        }

        // далі кудись юзвіра посилаємо
        log.info("redirect : " + "/megamarket/index.jsp");
        response.sendRedirect("/megamarket/index.jsp");
        return;
    }
}
