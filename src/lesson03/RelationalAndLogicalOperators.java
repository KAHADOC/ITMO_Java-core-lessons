package lesson03;

public class RelationalAndLogicalOperators {
    public static void main(String[] args) {
        // I. ��������� ��������� (������ ���������� ��������� ���� boolean)
        // > ������
        // < ������
        // >= ������ ��� �����
        // <= ������ ��� �����
        // == �����
        // != �� �����

        int apples = 24, pears = 31, bananas = 24;
        boolean result = apples < pears; // true, �������� apples (24) ������ �������� pears (31)
        result = apples != bananas; // false, �������� apples (24) ����� �������� bananas (24)
        result = apples == bananas; // true, �������� apples (24) ����� �������� bananas (24)
        result = apples >= bananas; // true, �������� apples (24) ����� �������� bananas (24)
        result = apples <= pears; // true, �������� apples (24) ������ �������� pears (24)

        // I. ���������� ��������� (������ ���������� ��������� ���� boolean)
        // && � - ������ true, ���� ��� �������� - true. ���������� false � �� ��������� ������ �������,
        // ���� ������ ����� false
        // || ��� - ������ true, ���� ���� ������� - true. ���������� true � �� ��������� ������ �������,
        // ���� ������ ����� true
        // ! �� - ������ �������� �������� �� ���������������
        int x = 7, y = 5;
        result = (x > 0) && (y > 0); // (7 > 0) && (5 > 0) --> true && true --> true
        result = (x < 0) && (y > 0); // (7 < 0) && (5 > 0) --> false && true --> false

        result = (x < 0) || (y < 0); // (7 < 0) || (5 < 0) --> false || false --> false --> false
        result = (x > 0) || (x > y); // (7 > 0) || (7 > 5) --> true || true --> true --> true


        boolean isActive = true;
        result = !isActive; // !true --> false
        result = !(x < 0); // !(7 < 0) --> !false --> true

        // TODO #1

        // I. ��������� �������� ?:
        int yearStart = 2023, yearEnd = 2025;
        int validity = yearEnd > yearStart ? yearEnd - yearStart : -1;
        // ������� (yearEnd > yearStart) - true, �������
        // ��������� �������� ������ ��������� ��������� yearEnd - yearStart, �� ���� 2
        System.out.println(validity);

        yearStart = 2037;
        yearEnd = 2030;
        validity = yearEnd > yearStart ? yearEnd - yearStart : -1;
        // ������� (yearEnd > yearStart) - false, �������
        // ��������� �������� ������ -1
        System.out.println(validity);

        // TODO #2

    }
}
