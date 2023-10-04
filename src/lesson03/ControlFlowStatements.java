package lesson03;

public class ControlFlowStatements {
    public static void main(String[] args) {
        // I. ����� ����
        var one = 1; // �������� ���������� ����� var, ��� ������ ���������� - int,
        // �� int ������������ �� ��������� ��� ����� �����
        // ���������� one ����� � ������� �, ��������������, �� ���� ��������� ������
        { // ������ ����� 1
            var two = 2; // ���������� two ����� � ������� �, ��������������, �� ���� ��������� ������
            System.out.println(one);
            System.out.println(two);
            { // ������ ����� 2
                var three = 3; // ���������� three ����� � ������� �����
                System.out.println(one);
                System.out.println(two);
                System.out.println(three);
            } // ����� ����� 2
            // System.out.println(three); // ���������� three �� �����, �� ��������� � ���������� �� ��������� ����� �2
        } // ����� ����� 1
        System.out.println(one);
        // System.out.println(two); // ���������� two �� �����, �� ��������� � ���������� �� ��������� ����� �1
        // System.out.println(three); // ���������� three �� �����, �� ��������� � ���������� �� ��������� ����� �2

        // I. IF ... ELSE
        double maxTemperatureValue = 1000;
        double currentTemperatureValue = 200.5;
        if (currentTemperatureValue > maxTemperatureValue) { // false
            System.out.println("��������������: " +
                    "��������� ������������ ��������"); // ������������
        }

        int maxScoreValue = 100;
        int currentScoreValue = 20;
        if (currentScoreValue == maxScoreValue) { // false
            System.out.println("�� ������� ����������� ���������� �����"); // ������������
        } else {
            System.out.println("�� �� ������ ������� ����������� " +
                    "���������� �����. ���������� ��� ���"); // �����������
        }

        char currentChar = 'a';
        if (currentChar == 'a' || currentChar == 'z') {
            System.out.println("���� ���� - ������������"); // �����������
        } else if (currentChar == 'x') {
            System.out.println("���� ���� - �������������"); // ������������
        } else {
            System.out.println("��� ��� �� ������ ����"); // ������������
        }

        // �������� ������ ����� ��������, ���� if ������������� ���� ����������
        boolean requestResult = false;
        if (requestResult) System.out.println("������ ������� ���������");
        else System.out.println("��������� ������� ����������� ��������");

        // if (requestResult/* == true*/) System.out.println("������ ������� ���������");
        // if (!requestResult/* == false*/) System.out.println("������ ������� ���������");

        // � ��� �������?
        currentChar = 'a';
        if (currentChar == 'a' || currentChar == 'z') {
            System.out.println("���� ���� - ������������");
        } else if (currentChar == 'x') {
            System.out.println("���� ���� - �������������");
        }

        /*
        currentChar = 'a';
        if (currentChar == 'a' || currentChar == 'z') {
            System.out.println("���� ���� - ������������");
        }
        if (currentChar == 'x') {
            System.out.println("���� ���� - �������������");
        }
        */

        // TODO #3
        // TODO #4
        //  ������ ��������� ������, ��������� if else:
        //  ���� 3 �����, ������� � ������� ���������� �� ���
        int num01 = 90, num02 = 8, num03 = -12;
        if (num01 > num02 && num01 > num03) System.out.println(num01);
        else if (num02 > num01 && num02 > num03) System.out.println(num02);
        else System.out.println(num03);

        // I. SWITCH CASE
        // �������� ������ � int (Integer),
        // byte (Byte),
        // short (Short),
        // char (Character),
        // enum,
        // String
        // ����������� �� ������� ���������� �� ������� break
        int monthNumber = 4;
        switch (monthNumber) {
            case 12: // 12 �� ����� monthNumber
            case 1:  // 1 �� ����� monthNumber
            case 2:  // 2 �� ����� monthNumber
                System.out.println("����"); // ignore
                break;
            case 3: // 3 �� ����� monthNumber
            case 4: // 4 ����� monthNumber
            case 5:
                System.out.println("�����"); // execute
                break; // switch ��������� ������
            case 6:
            case 7:
            case 8:
                System.out.println("����");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("�����");
                break;
            default:
                System.out.println("������ ������ ������");
        }

        // ������� � java 14 ����� ������������ ����� ��������� switch
        // � ����� ������ ��������� (lambda style)
        monthNumber = 6;
        switch(monthNumber) {
            case 12, 1, 2 -> System.out.println("����"); // monthNumber �� ����� 12, �� ����� 1, �� ����� 2
            case 3, 4, 5 -> System.out.println("�����"); // monthNumber �� ����� 3, �� ����� 4, �� ����� 5
            case 6, 7, 8 -> System.out.println("����"); // ���������� ����������, monthNumber ����� 6, switch �������� ������
            case 9, 10, 11 -> System.out.println("�����");
            // default -> System.out.println("�������� ����"); - �������������� ����
        }

        char seasonLetter = switch(monthNumber) {
            case 12, 1, 2 -> '�'; // monthNumber �� ����� 12, �� ����� 1, �� ����� 2
            case 3, 4, 5 -> '�'; // monthNumber �� ����� 3, �� ����� 4, �� ����� 5
            case 6, 7, 8 -> '�'; // ���������� ����������, monthNumber ����� 6, switch ����� '�' � �������� ������
            case 9, 10, 11 -> '�';
            default -> 'e'; // ������������ ����
        };
        System.out.println(seasonLetter);

        seasonLetter = switch(monthNumber) {
            case 12, 1, 2 -> {
                System.out.println("����");
                yield '�';
            }
            case 3, 4, 5 -> {
                System.out.println("�����");
                yield '�';
            }
            case 6, 7, 8 -> {
                System.out.println("����");
                yield '�';
            }
            case 9, 10, 11 -> {
                System.out.println("�����");
                yield '�';
            }
            default -> { // ������������ ����
                System.out.println("�������� ����");
                yield  'e';
            }
        };
        System.out.println(seasonLetter);

        // TODO #5
        //  ������ ��������� ������, ��������� switch:
        //  �������� ���������, ������� ������� � ������� ���������� ������� �� ��������� �����.
        //  1 � 2 ����� - 7 �������
        //  3 � 4 ����� - 5 �������
        //  5 ���� - 2 ��������
        //  ����� ����� �������� � ���������� floorNumber.

    }
}
