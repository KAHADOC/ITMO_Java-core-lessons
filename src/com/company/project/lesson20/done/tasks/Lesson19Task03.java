package com.company.project.lesson20.done.tasks;

import com.company.project.lesson19.task.task03.Article;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Lesson19Task03 {

    public static Double task01(ArrayList<Article> articles) {
        // Вернуть средний возраст авторов статей
        Double averageAge = articles.stream()
                .flatMapToInt(article -> article.getAuthors().values().stream().mapToInt(author -> {
                    LocalDate current = LocalDate.now();
                    LocalDate authorBirth = author.getBirth();
                    return Period.between(authorBirth, current).getYears();
                })).average().getAsDouble();
        return averageAge;
    }

    public static List<String> task02(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список email авторов статей категории == category
        return articles.stream()
                .flatMap(article -> article.getAuthors().values().stream()
                        .map(author -> author.getEmail()))
                .toList();
    }

    public static List<Article> task03(ArrayList<Article> articles, Article.Category category, int min, int max) {
        // Вернуть список статей категории == category,
        // возраст авторов которых попадает в диапазон от min до max
        /*
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> {
                    for (Author author : article.getAuthors().values()) {
                        LocalDate current = LocalDate.now();
                        LocalDate authorBirth = author.getBirth();
                        int age = Period.between(authorBirth, current).getYears();
                        if(age < min || age > max) return false;
                    }
                    return true;
                })
                .toList();
                */
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> article.getAuthors().values().stream()
                        .allMatch(author -> {
                            int age = Period.between(author.getBirth(), LocalDate.now()).getYears();
                            return age > min && age < max;
                        }))
                .toList();
    }

    public static List<Article> task04(ArrayList<Article> articles, Article.Category category) {
        // Вернуть список статей категории == category, опубликованных сегодня
        return articles.stream()
                .filter(article -> article.getCategory() == category)
                .filter(article -> article.getPublished().toLocalDate().isEqual(LocalDate.now()))
                .toList();
    }
}
