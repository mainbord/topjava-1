package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.controller.MealController;
import ru.javawebinar.topjava.controller.MealControllerImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by mainbord on 19.07.17.
 */
public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    private MealController MC;

    @Override
    public void init() throws ServletException {
        super.init();
        MC = new MealControllerImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("meals", MC.getMeals());
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("meal", MC.getMeal(id));
            request.getRequestDispatcher("/meal.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            MC.deleteMeal(id);
            int ss = MC.getMeals().size();
            request.setAttribute("meals", MC.getMeals());
            response.sendRedirect("meals");
        } else if (action.equals("create")) {
            request.setAttribute("meal", new Meal(null, LocalDateTime.now(), "Введите описание", 1000));
            request.getRequestDispatcher("/meal.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("act");
        if (action != null && action.equals("create")) {
            req.setAttribute("meal", new Meal(null, LocalDateTime.now(), "Введите описание", 1000));
            req.getRequestDispatcher("/meal.jsp").forward(req, resp);
        } else {
            String idd = req.getParameter("id");
            if (idd.equals("")) {
                String datetime = req.getParameter("datetime");
                String description = req.getParameter("description");
                Integer calories = Integer.parseInt(req.getParameter("calories"));
                Meal meal = new Meal(null, LocalDateTime.parse(datetime), description, calories);
                MC.updateMeal(meal);
                req.setAttribute("meals", MC.getMeals());
                req.getRequestDispatcher("/meals.jsp").forward(req, resp);
            } else {
                int id = Integer.parseInt(idd);
                String datetime = req.getParameter("datetime");
                String description = req.getParameter("description");
                Integer calories = Integer.parseInt(req.getParameter("calories"));
                Meal meal = new Meal(id, LocalDateTime.parse(datetime), description, calories);
                MC.updateMeal(meal);
                req.setAttribute("meals", MealsUtil.getFilteredWithExceeded(MealsUtil.meals, LocalTime.MIN, LocalTime.MAX, 2000));
                req.getRequestDispatcher("/meals.jsp").forward(req, resp);
            }
        }
    }
}
