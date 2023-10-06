package lesson04;

import java.util.Scanner;

public class ForAndWhile {
    public static void main(String[] args) {
        // WHILE / DO WHILE / FOR

        // I. ���� WHILE ��������� ���������  ������������������ ��������,
        //  ���� ����������� ������� �������. ������� ������ ����������� �� ���� �����.
        //  ���� ������������, ����� ����� �������� (����������) ����������
        /*
        while (���������� ��������� / �������) {
            ���� ����� - ����������, ������� ���������� ���������,
            ���� '�������' �������
        }
        */

        // ������������ ������ ������������� ����� �����.
        // ����� ����� �� �����.
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������������� ����� �����");
        int userInput;
        int sum = 0;
        while (scanner.hasNextInt() && (userInput = scanner.nextInt()) > 0) {
            sum += userInput;
        }
        scanner.next();
        System.out.println(sum);


        while (true) {
            System.out.println("������� ����� ������������� ����� ��� " +
                    "0 ��� ������ �� ���������");
            userInput = scanner.nextInt();
            if (userInput == 0) { // ���� ������������ ������ 0
                break; // ����� �� �������� �����
            }
            if (userInput < 0) { // ���� ������������ ������ ������������� �����
                continue; // ������� �� ��������� �������� � �������� �������
                // � ������� �������
            }
            // ���������� ����� ���������,
            // ���� ������������ ������ ������������� �����
            System.out.println(userInput * userInput);
        }

        // TODO #2
        // ������������ ������ ������������� ����� �����,
        // ������� ���������� �����, ��������� �������������,
        // ������� �������������� ��������,
        // ������������ ��������.

        int task02Sum = 0;
        int task02Count = 0;
        int task02max = 0;

        System.out.println("������� ������������� ����� �����");
        while (scanner.hasNextInt() && (userInput = scanner.nextInt()) > 0) {
            task02Sum += userInput;
            task02Count++; // ��� ++task02Count;
            if (userInput > task02max) task02max = userInput;
        }
        if (task02Count > 0) System.out.println((double) task02Sum / task02Count);
        System.out.println(task02Count);
        System.out.println(task02max);

        // ������������� ������� �� 0 - ����������
        // ������� �� 0 ����� � ��������� ������ - Infinity / -Infinity


        // ������������ ������ ������� ����� �� ��� ���,
        // ���� ����� �� ����� ���������� � ��������� [9; 90)
        // �� 9 (������� 9) �� 90 (�������� 90)
        int min = 9, max = 90;
        int answer = 0;
        do {
            System.out.println("������� �����");
            if (scanner.hasNextInt()) answer = scanner.nextInt();
            else scanner.next();
        /*} while (!(answer >= min && answer < max));*/
        } while (answer < min || answer >= max);

        System.out.println("���� ����� �������");


        // I. FOR
        //for (; ;) {} // ������������� ���������� ����������� ���� for
        //for (�������������; �������; ����������) {
        //    ���� �����
        // }
        // ������������� - ����������� ���� ��� ��� ����� � ����
        // ������� - ����������� ������ ��� ����� ����������� ���� �����
        // ���������� - ����������� ����� ���������� ���� �����, ����� ��������� �������
        // ���� ����� �����������, ���� ������� �������

        // �������� ���� �� 1��. �����.
        // ����� ������� ���� �� 1��, 2��, 3��, 4��, 5��.
        double price = 200; // �� 1 ��.
        for (int quantity = 1; quantity <= 5; quantity++) {
            double currentPrice = quantity * price;
            System.out.println(quantity + "��. " + " ����� " + currentPrice);
        }

        // TODO #3
        // ����� ����� ����� �� 20 �� 143 ������������, �������� 37, 45 � 101
        int task03Sum = 0;
        for (int i = 20; i <= 143; i++) {
            if (i == 37 || i == 45 || i == 101) continue;
            task03Sum += i;
            // ���
            // if (i != 37 && i != 45 && i != 101) sum += i;
        }
        System.out.println(task03Sum);


        // TODO #4
        System.out.print("��� �������� ������");
        System.out.println("� ��������� ������");
        // �������� ���������, ������� ����������� �������
        /*
        1
        12
        123
        1234
        12345
        123456
        */
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
