package lesson06;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class StringsLesson {
    public static void main(String[] args) {
        // char (����������� ��� ������) 16 ��� - ������ Unicode
        char char01 = 'J'; // ��� ������ � ��������� ��������
        // �� "J" - ������, ��������� ��� String
        char char02 = 74; // ����� ������� � ������� Unicode � ��������� �� 0 �� 65535
        char char03 = '\u0044'; // 16������ ������������� � escape ������������������

        System.out.print(char01);
        System.out.print(char02);
        System.out.print(char03);

        System.out.println('\uD83D');
        System.out.println('\uDC3E');

        System.out.println("\uD83D\uDC3E"); // ����������� ���� ?

        // ������ ������ ������� ����� ���� ����������� ����� char ��� ����� (����������� ����) char

        String string01 = "Cat";
        String string02 = "Cat";
        String string03 = new String("Cat");

        // ��������� ������
        System.out.println(string01 == string02); // true
        System.out.println(string01 == string03); // false

        // ��������� �����
        string01 = "������";
        string02 = "������";
        if (string01.equals(string02)) System.out.println("������ �����");
        if (string01.equalsIgnoreCase(string02)) System.out.println("������ ����� ��� ����� ��������");

        if (string01.compareTo(string02) < 0) { // ��� compareToIgnoreCase - ��� ����� ��������
            System.out.println(string01 + " ������ " + string02);
        } else if (string01.compareTo(string02) > 0) { // ��� compareToIgnoreCase - ��� ����� ��������"
            System.out.println(string01 + " ������ " + string02);
        } else {
            System.out.println("������ �����");
        }

        // ������� � ������ �������
        string01 = " JaVa ";
        string02 = " deVEloPEr ";
        String upperString = string01.toUpperCase();
        String lowerString = string02.toLowerCase();
        System.out.println(upperString);
        System.out.println(lowerString);


        // �������� �������� � ������ � ����� ������
        // �������� �� ������������������ �������� � ������ � ����� ������
        // ������ ��������
        // string01.startsWith();
        // "str".startsWith();
        // upperString.strip().startsWith()
        // trim U+0020
        if (upperString.strip().startsWith("JA") && lowerString.trim().endsWith("er")) {
            System.out.println(upperString.replace("A", "!") +
                    lowerString.repeat(2));
        }
        /*
        String str = null;
        if (str != null) {
            System.out.println(str.toLowerCase());
        }
        */
        // ������� �� �����
        string01 = "java junior developer";
        String[] strings = string01.split(" ");
        System.out.println(Arrays.toString(strings));

        char[] chars = string01.toCharArray();
        System.out.println(Arrays.toString(chars));

        // ����� ������
        System.out.println(string01.length());

        // ������������ �����
        string01 = "Hello";
        string02 = "World";
        // �������� +
        String concat = string01 + " " + string02;
        concat = "Hello" + " " + "World";
        // ����� concat
        concat = string01.concat(" ").concat(string02);

        // StringBuilder ��� StringBuffer (������������ ��� ������������ � �����)
        StringBuilder sb = new StringBuilder();
        sb.append(string01).append(" ").append(string02).append("!!!");
        concat = sb.toString();
        System.out.println(concat);

        String reversed = sb.reverse()
                .delete(0, 3)
                .insert(1, "???")
                .toString();
        System.out.println(reversed);

        String[][] matrix01 = new String[3][3];
        String[][] matrix02 = {
                {"open", "close", "process"},
                {"close", "close", "process"},
                {"process", "close", "close"}
        };

        String[][] animals = new String[3][]; // [null, null, null]
        animals[0] = new String[2]; // [[null, null], null, null]
        animals[1] = new String[3]; // [[null, null], [null, null, null], null]
        animals[2] = new String[4]; // [[null, null], [null, null, null], [null, null, null, null]]

        // �������������� �����
        String item = "�����";
        int count = 0;
        double rating = 5.5;
        String formattedString =
        MessageFormat.format("�����: {0}. �� ������: {1}��. �������: {2}.",
                item, count, rating);
        System.out.println(formattedString);

        MessageFormat messageFormat = new MessageFormat("�: {0}. ���: {1, choice, 0#����� �����������|0<����|5<�����}. �: {2}.", Locale.UK);
        formattedString = messageFormat.format(new Object[]{item, count, rating});
        System.out.println(formattedString);

        // class MessageFormat
        // {index}
        // {index, type}
        // {index, type, style}
        // number:	integer, currency, percent, custom format - class DecimalFormat
        // date:	short, medium, long, full, custom format - class SimpleDateFormat
        // time:	short, medium, long, full, custom format - class SimpleDateFormat
        // choice:	custom format - class ChoiceFormat

        int number = 1;
        boolean answer = true;
        double value = 5.77233;
        formattedString = String.format("%d) ������ �����: %B", number, answer);
        System.out.println(formattedString);

        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        formattedString = formatter.format("%d) ������ �����: %B", number, answer).toString();
        System.out.println(formattedString);
        stringBuilder.setLength(0);

        formattedString = formatter.format("%1$d) ������ �����: %2$b", number, answer).toString();
        System.out.println(formattedString);
        stringBuilder.setLength(0);

        formattedString = String.format("%d) ������ �����: %B", number, answer);
        System.out.println(formattedString);
        stringBuilder.setLength(0);

        formattedString = formatter.format("%1$d) ������ �����: %2$.1f", number, value).toString();
        System.out.println(formattedString);
        stringBuilder.setLength(0);
        // %[argument_index$][flags][width][.precision]conversion
        // % � conversion �������� �������������
        // conversion ��������� �� ��, ��� ������ ���� �������������� ��������.
        // b ��� B � ��� ���������� ��������
        // s ��� S � ��� ����� (String)
        // c ��� C - ��� ��������
        // d - ��� ����������� �����
        // o - ��� ������������� �����
        // x ��� X - ��� ������������������ �����
        // f - ��� ����� � ��������� ������
        // t ��� T - ���� � �����
        // argument_index$ - ����� �����, �������� �� ������
        // flags - ����� ��������, ������������ ��� ��������� ������� ������.
        // width � ������������� ����� �����, ����������� ���������� ��������, ������� ������ ���� �������� � �����.
        // precision - ����� �����, ������������ ��� ����������� ���������� ��������.
        // ���������� ���� ����� ������� ��� float � double

    }
}
