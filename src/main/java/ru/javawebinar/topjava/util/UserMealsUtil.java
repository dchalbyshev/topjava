package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);


        mealsTo.forEach(System.out::println);

//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
       meals.forEach(m-> System.out.println(m));

      /// метод reference  освежить

        // TODO return filtered list with excess. Implement by cycles
        return null;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
       Map<LocalDate,Integer> calloriesSumByDate =  meals.stream().collect(Collectors.groupingBy(um->um.getDateTime().toLocalDate(),
               Collectors.summingInt(UserMeal::getCalories)));// получаем сумму калоррий по дням
       return meals.stream().filter(um->TimeUtil.isBetweenHalfOpen(um.getDateTime().toLocalTime(),
                startTime,endTime)).map(um->new UserMealWithExcess(um.getDateTime(),
                um.getDescription(),um.getCalories(),calloriesSumByDate.get(um.getDateTime().toLocalDate())>caloriesPerDay))
                .collect(Collectors.toList());

       // collect() - терминальная опреация преобр. stream
        // Map <localDate,List<UserMeal>> list = meals.stream().collect(Collectors.groupingBy(um->um.getDateTime().toLocalDate()))
         // сформировали мапу  ключ дата, значение - список еды в данную дату
        // Collectors.summingInt(um->um.getCalories())));  вторым считем сумму
        // UserMeal::getCalories)) -  идея предложила - мы поменяли на метод  reference

        // map() перобарзование коллекции
       //  .collect() - надо завершить операцию преобразовать во что то
        // TODO Implement by streams

       //  Collectors.toMap() применяется вместо Collectors.groupingBy при более слложной логике

    }

    //  не совсем понял наличие boolean переменной у класа еда ( с превышением(априори она true))
    // почему бы не сделать bean - прием пищи(callories,data,discription) и день в котром бы хранился список приемов пищи?
}
