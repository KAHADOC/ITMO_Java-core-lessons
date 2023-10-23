package com.company.project.lesson11;

import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args) {
        Country france = Country.FRANCE;
        Article article = new Article(Country.ITALY);
        // сравнивать перечисления можно через ==
        System.out.println(france == article.getCountry());
        // реализация аналогична сравнению через ==
        System.out.println(france.equals(article.getCountry()));

        // методы перечислений
        // Country[FRANCE, USA, ITALY]
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        System.out.println(Country.USA.ordinal()); // 1
        System.out.println(france.name());
        System.out.println(france/*.toString()*/);

        Country.ITALY.setName("Италия");
        Country.FRANCE.setName("Франция");
        System.out.println(france.getName());
        france.sout();
        Country.ITALY.sout();


    }
}
