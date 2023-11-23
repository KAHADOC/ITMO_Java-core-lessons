package com.company.project.lesson22.chain;

import com.company.project.lesson22.strategy.RunFast;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Цепочка обязанностей позволяет передавать запросы (действия) последовательно по цепочке обработчиков
        // 1. у всех действий должен быть общий тип данных (абстрактный класс) - Action / IAction
        // 2. в абстрактном классе предполагается наличие абстрактного метода
        // (или нескольких абстрактных методов) - void execute();
        // 3. наследники (классы-обработчики) абстрактного класса должны реализовать абстрактные методы
        // в соответствии с логикой приложения - бежит, идет, стоит
        // 4. в абстрактном классе должна быть возможность установить ссылку на следующее действие -
        // свойство Action nextAction и метод void nextAction(Action nextAction) в классе Action
        // 5. в абстрактном классе должен быть метод, который связывает текущий обработчик со следующим - void doAction() в классе Action
        // 4. метод, который связывает текущий обработчик со следующим, используется объектом, работающим с цепочкой -
        // - метод move(Action action) в классе Unit

        Action action01 = new Eat();
        Action action02 = new Drink();
        Action action03 = new Play();

        // выстраиваются в цепочку
        action01.nextAction(action02);
        action02.nextAction(action03);

        Animal animal = new Animal();
        animal.doAction(action01);


        // Если синтаксис языка и логика программы позволяют,
        // абстрактный класс можно заменить на функциональный интерфейс,
        // а конкретные реализации описать через лямбда выражения
        IAction runLambda = () -> System.out.println("Run Lambda");
        IAction stopLambda = () -> System.out.println("Stop Lambda");
        IAction walkLambda = () -> System.out.println("Walk Lambda");

        IAction unitAction = runLambda
                .next(stopLambda)
                .next(walkLambda);
        Unit unit02 = new Unit();
        unit02.move(unitAction);
        unit02.move(stopLambda.next(runLambda));

    }
}
