package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mainbord on 28.07.17.
 */
public class InMemoryMealRepositoryImpl implements MealRepository {

    public List<MealWithExceed> getMeals(){
        return MealsUtil.getFilteredWithExceeded(MealsUtil.meals, LocalTime.MIN, LocalTime.MAX, 2000);
    }

    public Meal getMeal(int id){
        return MealsUtil.meals.get(id);
    }

    @Override
    public void deleteMeal(int id) {
        MealsUtil.meals.remove(id);
    }

    @Override
    public void updateMeal(Meal meal) {
        if (meal == null) return;
        if (meal.getId() == null) createMeal(meal);
        else MealsUtil.meals.set(meal.getId(), meal);
    }

    @Override
    public void createMeal(Meal meal) {
        int id = 0;
        Meal mealResult = null;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < MealsUtil.meals.size(); i++) {
            set.add(MealsUtil.meals.get(i).getId());
        }
        for (int i = 0; i < MealsUtil.meals.size(); i++) {
            if (!set.contains(i))
            {
                mealResult = new Meal(i, meal.getDateTime(), meal.getDescription(), meal.getCalories());
                break;
            }
        }
        if (mealResult == null) mealResult = new Meal(MealsUtil.meals.size(), meal.getDateTime(), meal.getDescription(), meal.getCalories());
        MealsUtil.meals.add(mealResult);
    }

}
