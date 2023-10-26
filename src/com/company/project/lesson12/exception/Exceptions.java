package com.company.project.lesson12.exception;

public class Exceptions {
    public static void main(String[] args) {
        // ERROR - ошибки связаны с проблемами уровня JVM (например, нехватка памяти).
        // Ошибки нет смысла обрабатывать.

        // EXCEPTION:
        // 1. Исключения времени ВЫПОЛНЕНИЯ (наследники RuntimeException):
        // unchecked, необрабатываемые, неотслеживаемые, неконтролируемые.
        // Разработчики могут (по своему усмотрению) обработать данный тип исключений.

        // 2. Исключения времени КОМПИЛЯЦИИ (все остальные наследники Exception):
        // checked, обрабатываемые, отслеживаемые, контролируемые.
        // Разработчики обязаны обработать данный тип исключений или выбросить его в сигнатуре метода.

        // Исключения времени выполнения

        int[] ints = new int[4];
        int index = 9;
        // перед обращением к элементу по index правильно проверить,
        // не будет ли выхода пределы
        if (index <= ints.length - 1) ints[index] = 5;
        // в противном случае может быть выброшено:
        // ints[index] = 5; // java.lang.ArrayIndexOutOfBoundsException

        Object object = "Hello"; // String
        // перед приведением правильно проверить,
        // являются ли типы совместимыми
        Integer integer = null;
        if (object instanceof Integer) integer = (Integer) object;
        // в противном случае может быть выброшено:
        // integer = (Integer) object; // java.lang.ClassCastException

        int a = 20;
        int b = 0;
        // перед целочисленном делении на 0 правильно проверить,
        // делитель на равенство 0
        if (b != 0) System.out.println(a / b);
        // в противном случае может быть выброшено:
        // System.out.println(a/b); // java.lang.ArithmeticException

        String string = null;
        // перед целочисленном делении на 0 правильно проверить,
        // ссылку на null
        if (string != null) System.out.println(string.length());
        // в противном случае может быть выброшено:
        // System.out.println(string.length()); // java.lang.NullPointerException

        // ОБРАБОТКА ИСКЛЮЧЕНИЙ любого типа (unchecked / checked)

        try {// в блок try помещается потенциально опасный код,
            // который может привести к исключению
            System.out.println(string.length());
        } catch (NullPointerException exception) { // перехватывает исключение
            // указанного в нем типа (в данном случае NullPointerException) и его наследников
            System.out.println("exception");
        }


        // Обработка нескольких типов исключений
        // 1. разные типы исключений нужно обработать разными способами (несколько блоков catch)
        try {
            // потенциально опасный код, в случае исключительной ситуации необходимо перехватить
            // NullPointerException или ClassCastException
        } catch (NullPointerException exception) {
            System.out.println("Обработка NullPointerException " + exception.getMessage());
        } catch (ClassCastException exception) {
            System.out.println("Обработка ClassCastException " + exception.getMessage());
        }

        // 2. разные типы исключений нужно обработать одинаковым способом (оператор |)
        try {
            // потенциально опасный код, в случае исключительной ситуации необходимо перехватить
            // ArithmeticException или ClassCastException, или NullPointerException
        } catch (ArithmeticException | ClassCastException | NullPointerException exception) {
            System.out.println("Обработка ClassCastException или ArithmeticException, " +
                    "или NullPointerException " + exception.getMessage());
        }

        // 3. разные типы исключений нужно обработать одинаковым способом (через общего родителя)
        try {
            // потенциально опасный код, в случае исключительной ситуации необходимо перехватить
            // исключения времени выполнения
        } catch (RuntimeException exception) {
            System.out.println("Обработка RuntimeException " + exception.getMessage());
        }

        // 4.
        try {
            // потенциально опасный код, в случае исключительной ситуации необходимо перехватить
            // исключения времени выполнения
        } catch (ClassCastException exception) {
            System.out.println("Обработка ClassCastException " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Обработка остальных RuntimeException " + exception.getMessage());
        }


        try {
            // исключения времени компиляции должны быть обработаны в блоке try catch
            // или проброшены в сигнатуру метода
            User user = new User("qwerty", "qwerty123");
            User copy = user.clone();
        } catch (CloneNotSupportedException | UserException e) {
            throw new RuntimeException(e);
        }
    }
}
