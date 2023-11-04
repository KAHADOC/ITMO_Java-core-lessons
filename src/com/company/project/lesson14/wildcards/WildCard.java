package com.company.project.lesson14.wildcards;

import com.company.project.lesson14.properties.service.Service;
import com.company.project.lesson14.properties.vehicle.*;

public class WildCard {
    // ? - wildcards, может использоваться при объявлении переменных:

    // 1. ограничение сверху (upper bounding)
    // <? extends Car> - может быть Car и любой подтип (наследник)

    // 2. ограничение снизу (lower bounding)
    // <? super Car> - может быть Car и любой супертип (родитель)

    // 3.Захват подстановочных знаков (wildcard capture)
    // <?> - может быть все, что угодно


    // Vehicle v = new Train();
    // Service<MiniCar> mini = new Service();
    // Service<MiniCar02> mini02 = new Service();
    // toBetterService(mini02)
    // The Get and Put Principle или PECS (Producer ? Extends - Consumer ? Super)
    public static void toBetterService(Service<? extends Car> producerService,
                                       Service<? super Car> consumerService) {
        Car carFromService = producerService.getElement();
        // Object obj = consumerService.getElement();

        if (carFromService.getColor() == Repaintable.Color.ORANGE ||
                carFromService.getColor() == Repaintable.Color.GOLD){
            consumerService.setElement(carFromService);
            producerService.setElement(null);
        }
    }


    // метод принимает на вход сервисы Car или его супертипов
    public static void repairCars(Service<? super Car> service, int count) {
        for (int i = 0; i < count; i++) {
            service.setElement(new Car(Repaintable.Color.BLUE, "0000"));
            service.startRepair();
            service.setElement(new MiniCar(Repaintable.Color.BLUE, "0000"));
            service.startRepair();
            // ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ добавить супертипы Car
        }
        // из контейнера с wildcard "? super" можно прочитать только Object
        System.out.println(service.getElement()); // ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ прочитать, например Car ???
    }



    // метод принимает на вход списки Car или его подтипы (MiniCar)
    public static void getServiceInfo(Service<? extends Car> service, int count) {
        // в контейнер с wildcard "? extends" можно добавить только null
        for (int i = 0; i < count; i++) { // ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ добавить ничего, кроме null ???
            // service.setElement(null); на практике добавление в контейнер не используется
        }

        System.out.println(service.getElement().getColor()); // ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ прочитать Car ???
    }

    // метод принимает на вход списки с любыми объектами
    public static void repairCar(Service<?> service){
        service.startRepair(); // <?> используется если тип, хранимых в контейнере данных не важен
        // можно добавить только null, прочитать только Object
    }

    public static void v(Vehicle vehicle) {}
    public static void v(Vehicle[] vehicles) {}
    public static void v(Service<Vehicle> service) {}

    public static void main(String[] args) {

        // public static void v(Vehicle vehicle) {}
        Car car = new Car(Repaintable.Color.BLACK, "0000");
        v(car); // Vehicle vehicle = car;

        // Ковариантность - сохранение иерархии наследования
        // исходных типов
        // в производных типах в том же порядке, т.е.
        // если Car - подтип Vehicle,
        // то Service<Car> - подтип Service<Car>.
        // И можно выполнить присваивание:

        Car[] cars = new Car[10]; // массивы ковариантны
        // public static void v(Vehicle[] vehicles) {}
        v(cars); // Vehicle[] vehicles = cars;
        Vehicle[] vehicles = cars;
        vehicles[0] = new Car(Repaintable.Color.BLACK, "0000");
        // -> ArrayStoreException - при попытке добавить неправильный тип объекта в массив
        // vehicles[1] = new Train("187F", 11, true);

        // Инвариантность - отсутствие наследования между производными типами.
        // если Car - подтип Vehicle, то Service<Car> - не подтип MiniService<Car> и наоборот.

        Service<Car> cars01 = new Service<>(); // generic инвариантны
        // public static void v(Service<Vehicle> service) {}
        // v(cars01); // Service<Vehicle> vehicles01 = cars01; // ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ так присвоить ссылку ???


        // Контравариантность - изменение иерархии исходных типов
        // на противоположную в производных типах.
        // если Car - подтип Vehicle,
        // то Service<Vehicle> - подтип Service<Car>.
        // И можно выполнить присваивание:
        Service<Vehicle> vehicles02 = new Service<>();
        // Service<Car> cars02 = vehicles02; // ПОЧЕМУ КОМПИЛЯТОР НЕ ПОЗВОЛИТ так присвоить ссылку ???

        // ковариантность в generic
        Service<Car> cars03 = new Service<>();
        // ограничение сверху
        Service<? extends Vehicle> vehicles03 = cars03; // ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ так присвоить ссылку ???

        // контрвариантность в generic
        Service<Vehicle> vehicle04 = new Service<>();
        // ограничение снизу
        Service<? super Car> cars04 = vehicle04; // ПОЧЕМУ КОМПИЛЯТОР ПОЗВОЛИТ так присвоить ссылку ???

        // Используются для передачи generic контейнеров в методы

        Service<Vehicle> vehicleService  = new Service<>(new Car(Repaintable.Color.ORANGE, "0000"));
        Service<Car> carService = new Service<>(new Car(Repaintable.Color.ORANGE, "1111"));
        Service<Object> objectService = new Service<>(new Train( "765R", 8, false));
        Service<Bus> busService = new Service<>(new Bus( "7"));
        Service<Runnable> runnableService = new Service<>(new MiniCar(Repaintable.Color.GOLD, "2222"));
        Service<MiniCar> miniCarService = new Service<>(new MiniCar(Repaintable.Color.GOLD, "3333"));

        // Service<? extends Car> producerService --- Car и подтипы
        // Service<? super Car> consumerService --- Car и супертипы
        toBetterService(carService, objectService);
        toBetterService(miniCarService, carService);
        toBetterService(miniCarService, vehicleService);
        // toBetterService(miniCarService, runnableService);
        // toBetterService(vehicleService, objectService);


        // метод принимает на вход списки Car или его наследников (MiniCar)
        getServiceInfo(carService, 4);

        miniCarService.setElement(new MiniCar(Repaintable.Color.ORANGE, "4444"));
        getServiceInfo(miniCarService, 8);
    }
}


