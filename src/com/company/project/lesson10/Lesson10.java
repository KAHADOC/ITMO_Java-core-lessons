package com.company.project.lesson10;

import com.company.project.lesson10.clonequals.Item;
import com.company.project.lesson10.clonequals.Order;
import com.company.project.lesson10.staticmodifier.Auth;

import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {

        Item item01 = new Item("Карандаш", 320);
        Item item02 = new Item("Карандаш", 320);
        Item copyItem = item01.clone();
        // toString() возвращает строковое представление объекта
        // наследуется от класса Object
        System.out.println(item01.toString());
        System.out.println(item01 == item02); // false
        // equals() используется для сравнения объектов
        // наследуется от класса Object
        // по умолчанию сравнивает ссылки
        System.out.println(item01.equals(item02)); // true

        // Item item03 = new Item("Ручка", 490);
        Order order01 = new Order(new Item[]{item01, item02});
        Order order02 = new Order(new Item[]{item01, item02});
        // order.getItems()[0] = item03;
        Order copy = order01.clone();
        System.out.println(copy == order01); // false
        System.out.println(copy.getItems() == order01.getItems()); // false

        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя пользователя");
        String username = scanner.nextLine();

        System.out.println("Пароль");
        String password = scanner.nextLine();

        System.out.println("Способ авторизации");
        String authType = scanner.nextLine(); // github, app
        Auth auth = Auth.getAuth(authType);

        /*if (authType.equals("github")) {
            auth = new GAuth();
        } else {
            auth = new AppAuth();
        }*/

        auth.login(username, password);



    }
}
