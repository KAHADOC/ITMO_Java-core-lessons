package com.company.project.lesson19.streamapi;

import com.company.project.lesson14.properties.vehicle.*;
//import com.company.project.lesson18.Lesson18;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

// статический импорт
// import static com.company.project.lesson18.Lesson18.*;

// import com.company.project.lesson18.Lesson18;


public class StreamApi19 {
    public static void main(String[] args) {

        // printOperationResult(); при статическом импорте
        // Lesson18.printOperationResult(); при обычном импорте
        /*
        Stream API - предоставляет набор методов для работы с данными, как с потоком.
        Позволяет представить различные наборы данных в виде потока,
        а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям и т.д.,
                 кроме этого позволяет создавать коллекции и мапы из текущего потока данных.

        Особенности работы со Stream API:
         1. Stream никогда НЕ ХРАНИТ ДАННЫЕ
         2. Для сохранения данных из Stream нужно использовать специальные методы.
         3. Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан,
            все преобразования происходят только в потоках.
         4. В своей работе методы stream используют лямбда выражения.

        Для работы с потоками данных необходимо:
         1. Получить данные в виде потока - объект типа Stream
         2. Выполнить промежуточные операции с потоком данных
            (промежуточные операции обрабатывают данные и возвращают Stream объект)
         3. Выполнить терминальную (конечную) операцию
            (терминальная операция обрабатывает данные и завершает работу потока)
         Без терминальной операции промежуточные операции не начнут выполняться

         Например, получили объект stream, далее выполняем промежуточные операции
         stream.операция1() - вернет преобразованный объект stream
                .операция2() - вернет преобразованный объект stream
                .операция3()  - вернет преобразованный объект stream
                .терминальнаяОперация(); - запускает промежуточные операции, данные обрабатываются, стрим закрывается

         Методы получения Stream:
          1. из коллекций `collection.stream();`
          2. из массива `Arrays.stream(arr);`
          3. из файла `Files.lines(path_to_file);`
          4. из строки `string.chars();`
          5. используя builder `Stream.builder().add(obj1).add(obj2).add(objN).build();`
          6. из набора данных `Stream.of(1, 4, 7);`

        Числовые потоки содержат дополнительные методы для работы с числами:
         1. IntStream intStream = IntStream.range(12, 100);
         2. LongStream longStream = LongStream.builder().add(2).add(23).add(11).build();
         3. DoubleStream doubleStream = DoubleStream.of(2.5, 12,8);
         */

        // Дан поток целых чисел:
        // - оставить в потоке только отрицательные элементы - filter(Predicate)
        // - добавить к каждому элементу строку " deg" - map(Function)
        // - вывести каждый элемент в консоль - forEach(Consumer)


        Predicate<Integer> negative = integer -> integer < 0;
        // Function<T, R>: R apply(T t)
        Function<Integer, String> deg = integer -> integer + " deg";
        // String degRes = deg.apply(-20); // "-20 deg"
        // Consumer<T>: void accept(T t);
        Consumer<String> sout = s -> System.out.println(s);
        // sout.accept("-55 deg");
        Stream<Integer> temps = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        temps.filter(negative) // Stream<Integer> (-560, -55, -100, -20)
                .map(deg) // Stream<String> ("-560 deg", "-55 deg", "-100 deg", "-20 deg")
                .forEach(sout);

        // Дан поток целых чисел:
        Stream<Integer> values = Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        // - оставить только уникальные значения - distinct()
        // - отрицательные значения заменить на 0 - map(Function fn)
        // - отсортировать в порядке убывания - sorted(Comparator comp)
        // - вывести элементы в консоль
        values.distinct()
                .map(integer -> integer < 0 ? 0 : integer)
                .sorted((a, b) -> b - a)
                .forEach(integer -> System.out.println(integer));

        // Дан массив строк:
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        // - создать строк - Arrays.stream(colors)
        // - оставить цвета, не содержащие жёлтый (yellow) оттенок - filter(Predicate p)
        // - вывести в консоль количество элементов потока - long count()
        long count = Arrays.stream(colors)
                .filter(color -> !color.contains("yellow"))
                .count();
        System.out.println(count);

        // в интерфейс Repaintable добавить метод Color getColor();
        // Дан список Repaintable объектов
        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007")
        );
        List<Repaintable.Color> uniqueColors = repaintables.stream()
                .map(repaintable -> repaintable.getColor())
                .distinct()
                .toList(); // unmodifiableList
        System.out.println(uniqueColors);
        // repaintables.stream() стрим из коллекции
        // получить список неповторяющихся цветов
        // получить список из потока можно методом toList()

        // Дан список транспортных средств
        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );
        // void accept(T t);
        // R apply(T t);
        vehicles.stream()
                .peek(vehicle -> vehicle.repair()) // промежуточная
                .map/*ToInt*/(vehicle -> {
                    vehicle.repair();
                    return vehicle.getLevelOfWare();
                })
                .forEach(integer -> System.out.print(integer)); // терминальная

        // преобразование stream в массив
        Object[] objectsArr = vehicles.stream().toArray();
        Vehicle[] vehiclesArr = vehicles.stream()
                .toArray(Vehicle[]::new); // ссылка на конструктор массива типа Vehicle
        // .toArray(size -> new Vehicle[size]); без ссылки на конструктор

        // преобразование stream в список
        List<Vehicle> vehiclesList = vehicles.stream()
                .toList(); // unmodifiableList

        List<String> sortedVehicles = vehicles.stream()
                .sorted((o1, o2) -> o2.getLevelOfWare() - o1.getLevelOfWare())
                // .sorted() // Vehicle должен имплементировать Comparable
                .map(vehicle -> vehicle.getNumber()).toList();

        int sumLevelOfWare = vehicles.stream()
                .mapToInt(vehicle -> vehicle.getLevelOfWare())
                .sum();

        /*vehicles.stream()
                .peek(vehicle -> vehicle.changeColor(Repaintable.Color.GOLD))
                .forEach(System.out::println);*/

        // Optional<Vehicle>
        // vehicles.stream().findFirst();
        // vehicles.stream().parallel().map().findAny();

        // vehicles.stream().min((o1, o2) -> o1.getLevelOfWare() - o2.getLevelOfWare());
        // vehicles.stream().max((o1, o2) -> o1.getLevelOfWare() - o2.getLevelOfWare());

        // true / false
        // vehicles.stream().allMatch(vehicle -> vehicle.getLevelOfWare() > 100);
        // vehicles.stream().anyMatch(vehicle -> vehicle.getLevelOfWare() > 100);
        // vehicles.stream().noneMatch(vehicle -> vehicle.getLevelOfWare() > 100);

        // vehicles.stream().collect(); Collectors
    }
}