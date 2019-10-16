package pl.Maciejjjjj.servlets;

import org.hibernate.SessionFactory;
import pl.Maciejjjjj.listeners.HibernateInitializer;
import pl.Maciejjjjj.model.dao.UserDao;
import pl.Maciejjjjj.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {

        SessionFactory sessionFactory = (SessionFactory) this.getServletContext().getAttribute(HibernateInitializer.k);
        userDao = new UserDao(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Boolean isUsernameAvailable = userDao.isUsernameAvailable(username);
        if (!isUsernameAvailable) {
            req.setAttribute("error", "This username is already taken.");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        userDao.save(user);

        //resp.sendRedirect("/login");
    }
}
