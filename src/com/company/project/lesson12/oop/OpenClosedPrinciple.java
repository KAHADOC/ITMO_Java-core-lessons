package com.company.project.lesson12.oop;

import java.util.Scanner;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите способ оплаты: 'ya' или 'sb'");
        String userAnswer = scanner.nextLine();

        IPay payWay = IPay.getInstance(userAnswer);

        System.out.println("Введите сумму");
        double money = scanner.nextDouble();

        payWay.pay(money);
    }
}

interface IPay {
    boolean pay(double money);

    static IPay getInstance(String userAnswer){
        return switch (userAnswer) {
            case "ya" -> new YaPay();
            case "sb" -> new SbPay();
            default -> throw new IllegalStateException("Unexpected value: " + userAnswer);
        };
    }
}

final class YaPay implements IPay {

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата ya pay: " + money);
        return true;
    }

}

final class SbPay implements IPay {

    @Override
    public boolean pay(double money) {
        System.out.println("Оплата sb pay: " + money);
        return true;
    }
}

// при необходимости работы с другими типами платежных шлюзов
// правильно добавить новый функционал в программу, не меняя код уже существующих классов

// нарушение принципа:
class Pay {
    public boolean pay(String userAnswer, double money) {
        if (userAnswer == null) throw new IllegalArgumentException("userAnswer не может быть null");
        if (userAnswer.equalsIgnoreCase("ya")){
            System.out.println("Логика оплаты ya pay: " + money);
            return true;
        } else if (userAnswer.equalsIgnoreCase("sb")) {
            System.out.println("Логика оплаты sb pay: " + money);
            return true;
        } else {
            throw new IllegalArgumentException("userAnswer должен быть 'ya' или 'sb'");
        }
        // новый функционал - новый if else
    }
}