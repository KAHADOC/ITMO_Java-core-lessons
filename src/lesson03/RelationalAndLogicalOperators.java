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
        // && � - ������ true, ���� ��� �������� - true.
        // ���������� false � �� ��������� ������ �������,
        // ���� ������ ����� false
        // || ��� - ������ true, ���� ���� ������� - true.
        // ���������� true � �� ��������� ������ �������,
        // ���� ������ ����� true
        // ! �� - ������ �������� �������� �� ���������������
        int x = 7, y = 5;
        result = (x > 0) && (y > 0); // (7 > 0) && (5 > 0) --> true && true --> true
        result = (x < 0) && (y > 0); // (7 < 0) && (5 > 0) --> false && true --> false

        result = (x < 0) || (y < 0); // (7 < 0) || (5 < 0) --> false || false --> false --> false
        result = (x > 0) || (x > y); // (7 > 0) || (7 > 5) --> true || true --> true --> true

        // (5 <= x <= 15) ������ ����������
        // (x <= 5 && x >= 15) ���������� ������
        // (x >= 5 && x <= 15) �����

        boolean isActive = true;
        result = !isActive; // !true --> false
        result = !(x < 0); // !(7 < 0) --> !false --> true

        // TODO #1
        int height = 10, width = 8;
        boolean created = true, colored = false;
        int code = 4444;

        // true
        result = (height % 2 == 0) && (height % 2 == 0) && (width % 2 == 0);
        // true
        result = (code == 2222) || (code == 3333) || (code == 4444);
        // true
        result = !colored && (code == 4444);
        // true
        result = colored || created;
        // false
        result = colored && created;

        // I. ��������� �������� ?:
        int yearStart = 2023, yearEnd = 2025;
        int validity = yearEnd > yearStart ? yearEnd - yearStart : -1;
        // ������� (yearEnd > yearStart) - true, �������
        // ��������� �������� ������ ��������� ��������� yearEnd - yearStart, �� ���� 2
        System.out.println(validity); // 2

        yearStart = 2037;
        yearEnd = 2030;
        validity = yearEnd > yearStart ? yearEnd - yearStart : -1;
        // ������� (yearEnd > yearStart) - false, �������
        // ��������� �������� ������ -1
        System.out.println(validity);

        // TODO #2
        //  ������ ��������� ������, ��������� ��������� ��������:
        //  ���� ���������� sum - ����� �������,
        //  ���� ����� ������� ���� 100_000, ���������� ������� ������ 10%,
        //  � ��������� ������ ������ �� �������������.
        //  ������� ����� ������� � ������ ������.

        var /*(int / double)*/ sum = 800_000.0;
        var /*(double)*/ resultSum = sum > 100_000 ? sum * 0.9 : sum;
        sum = sum > 100_000 ? sum * .9 : sum;

    }
}
