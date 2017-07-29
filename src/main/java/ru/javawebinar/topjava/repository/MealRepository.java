package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

/**
 * Created by mainbord on 28.07.17.
 */
public interface MealRepository {

    public List<MealWithExceed> getMeals();

    public Meal getMeal(int id);

    public void deleteMeal(int id);

    public void updateMeal(Meal meal);

    public void createMeal(Meal meal);
}
