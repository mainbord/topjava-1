package ru.javawebinar.topjava.controller;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

/**
 * Created by mainbord on 28.07.17.
 */
public interface MealController {

    public List<MealWithExceed> getMeals();

    public Meal getMeal(int id);

    public void deleteMeal(int id);

    public void updateMeal(Meal meal);

    public void createMeal(Meal meal);
}
