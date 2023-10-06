package lesson04;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        // I. ���������������� ���� (Scanner)

        // ��������� ������: import java.util.Scanner;
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("������� ����� �����");
        int intValue = scanner.nextInt(); // 34.6 34htj

        System.out.println("������� ����� ����� (� ��������� byte)");
        byte byteValue = scanner.nextByte(); // 345

        System.out.println("������� ����� � ��������� ������");
        double doubleValue = scanner.nextDouble();

        System.out.println("������� ���������� ��������");
        boolean booleanValue = scanner.nextBoolean();

        System.out.println(intValue);
        System.out.println(byteValue);
        System.out.println(doubleValue);
        System.out.println(booleanValue);*/


        // ��� ����� ��������� ����,
        // ��������� �������� ���������� java.util.InputMismatchException

        // ����� ��������� �� ���, ����� �������� ����������
        System.out.println("������� ����� �����");
        if (scanner.hasNextInt()) {
            int userNumber = scanner.nextInt();
            userNumber *= userNumber;
            System.out.println("���� ����� � ��������: " + userNumber);
        } else {
            System.out.println("�� ����� �� ����� �����");
            // ��������� �������� ����, ����� ������ �� ������ � ��������� ����������
            scanner.next();
        }

        System.out.println("������� ����� ����� ��� ���");
        int number = scanner.nextInt();
        System.out.println(number);

        System.out.println("������� ����� ������");
        var input = scanner.next(); // ������ (��� String)
        System.out.println(input);

    }
}
