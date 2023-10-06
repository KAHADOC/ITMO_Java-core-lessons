package lesson04;

import java.util.Scanner;

public class ForAndWhile {
    public static void main(String[] args) {

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
        while (scanner.hasNextInt() && ((userInput = scanner.nextInt()) > 0)) {
            sum += userInput;
        }
        scanner.next();
        System.out.println(sum);

        while (true) {
            System.out.println("������� ����� ������������� ����� ��� 0 ��� ������ �� ���������");
            userInput = scanner.nextInt();
            if (userInput == 0) { // ���� ������������ ������ 0
                break; // ����� �� �������� �����
            }
            if (userInput < 0) { // ���� ������������ ������ ������������� �����
                continue; // ������� �� ��������� �������� � �������� ������� � ������� �������
            }
            // ���������� ����� ���������, ���� ������������ ������ ������������� �����
            System.out.println(userInput * userInput);
        }

        // TODO #2


        // I. FOR
        // �������� ���� �� 1��. �����.
        // ����� ������� ���� �� 1��, 2��, 3��, 4��, 5��.
        double price = 200; // �� 1 ��.
        for (int quantity = 1; quantity <= 5; quantity++) {
            double currentPrice = quantity * price;
            System.out.println(quantity + "��. " + " ����� " + currentPrice);
        }
        // .1, .2, .3 � �.�

        // TODO #3
        // TODO #4

        // ������������ ������ ������� ����� �� ��� ���,
        // ���� ����� �� ����� ���������� � ��������� [9; 90)
        int min = 9, max = 90;
        int answer = 0;
        do {
            System.out.println("������� �����");
            if (scanner.hasNextInt()) answer = scanner.nextInt();
            else scanner.next();
        } while (answer < min || answer >= max);

        System.out.println("���� ����� �������");
    }
}
