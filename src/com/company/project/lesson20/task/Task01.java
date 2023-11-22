package com.company.project.lesson20.task;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));


        // Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек.
        //  Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> groupedByGender = students.stream()
                .collect(Collectors.groupingBy( // R apply(T t);
                        student -> /* return */ student.getGender(),
                        Collectors.toCollection(ArrayList::new)));

        //  2. Найти средний возраст учеников
        double averageAgeStream = students.stream()
                .mapToDouble(student ->
                        LocalDate.now().getYear() - student.getBirth().getYear())
                .average()
                .getAsDouble(); // orElse(0);
        double averageAgeCollectors = students.stream()
                .collect(Collectors.averagingInt(student ->
                        student.getBirth().until(LocalDate.now()).getYears()));

        //  3. Найти самого младшего ученика -
        //  Stream -> min(Comparator<Student>): int compare(T o1, T o2);
        Comparator<Student> birth = (s1, s2) -> s2.getBirth().compareTo(s1.getBirth());
        Optional<Student> youngStudent = students.stream()
                .min(birth);

        //  5. Собрать учеников в группы по году рождения,
        //  результат - Map<Integer, List<Student>>
        Map<Integer, List<Student>> studentsByYearOfBirth = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));


        //  6. Отсортировать по полу, дате рождения, имени (в обратном порядке),
        //  собрать в список (ArrayList)

        Comparator<Student> byGender = (s1, s2) -> s1.getGender().ordinal() - s2.getGender().ordinal();
        Comparator<Student> byBirth = (s1, s2) -> s1.getBirth().compareTo(s2.getBirth());
        Comparator<Student> studentComparator = byGender.thenComparing(byBirth);
        // Function<? super T, ? extends U> keyExtractor
        // R apply(T value);
        studentComparator = Comparator.<Student>comparingInt(student -> student.getGender().ordinal())
                // .thenComparing(Comparator.comparing(student -> student.getBirth()))
                .thenComparing(student -> student.getBirth())
                .thenComparing(student -> student.getName()).reversed();
        ArrayList<Student> studentArrayList = students.stream()
                .sorted(studentComparator)
                .collect(Collectors.toCollection(ArrayList::new));


        // 7. Собрать в список всех учеников с именем
        String someName = "Петр";
        List<Student> someNameListStudentsUnMod = students.stream()
                .filter(student -> student.getName().equals(someName))
                .toList();

        List<Student> studentsWithNameMod = students.stream()
                .filter(student -> student.getName().equals(someName))
                .collect(Collectors.toList());

        //  8. Собрать Map<Student.Gender, Integer>,
        //  где Student.Gender - пол,
        //  Integer - суммарный возраст учеников данного пола
        Map<Student.Gender, Integer> sumAgeStudent = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.summingInt(student ->
                                LocalDate.now().getYear() - student.getBirth().getYear())));


        BinaryOperator<Double> binaryOperatorL = (a, b) -> a + b;
        BinaryOperator<Double> binaryOperator = Double::sum;
        binaryOperatorL.apply(34.7, 89.9);
        binaryOperator.apply(34.7, 89.9);

        Task01 task01 = new Task01();
        BinaryOperator<Double> binaryOperator03 = task01::getSum;

    }

    public Double getSum(Double a, Double b) {
        return a + b;
    }
}