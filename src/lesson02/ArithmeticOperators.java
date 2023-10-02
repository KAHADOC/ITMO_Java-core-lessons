package lesson02;

public class ArithmeticOperators {
    public static void main(String[] args) {
        // �������������� ���������
        // + - * / %

        int x = 20, y = -1;
        // �������������� �������� - �������� ����
        int result = x + y; // 20 + -1 --> 19 --> result = 19

        // ����������� �������� byte / short ���������� ����� ��� int
        byte var01 = 89, var02 = 11;
        int byteResult01 = var01 + var02;
        // ���� ����� ��������� byte / short ���, ��������� ��������� ����� ���� �������� � byte / short ����
        byte byteResult02 = (byte) (var01 + var02);

        // �������������� �������� - �������
        // ��������� �������������� ������� - ����� �����, ������� ����� ��������
        double bill = 503;
        double halfBill = bill / 2;
        System.out.println(halfBill);

        int number = 101, divisor = 10;
        // ���� ����� ��������� ������� �����, ���� �� ��������� ����� �������� � ����� � ��������� ������
        double withoutLastDigit01 = (double) number / divisor;
        int withoutLastDigit02 = number / divisor;
        System.out.println(withoutLastDigit01);
        System.out.println(withoutLastDigit02);

        int n = 40;
        long m = 100L;
        long nmResult = n * m;
        System.out.println(nmResult);

        // ��������� ������� ����������:
        // 1. ��������� �������������� ���������� � byte � short (+, ?, *, /, %) ������������� � int
        // 2. ���� ���� �� ��������� long, ��������� ��������� ���������� �� long
        // 3. ��, ���� ���� �� ��������� float, ��������� ��������� ���������� �� float
        // 4. ��, ���� ���� �� ��������� double, ��������� ��������� ���������� �� double

        // �������� % - ������� �� �������
        number = 9;
        divisor = 2;
        int evenOrOddResult = number % divisor; // 1
        System.out.println(evenOrOddResult);

        number = 153;
        divisor = 10;
        int lastDigit = number % divisor; // 3
        System.out.println(lastDigit);

        // ����� ��� ������ � ���������� varResult � ������?
        var var1 = 60L;
        var var2 = -20;
        var var3 = 10.0;
        var varResult = var1 + var2 * var3;
        System.out.println(varResult); // double, �� ���� �� ��������� (var3) - double

        // ��������� ������������
        int num = 10;
        num = num + 10; // 10 + 10 --> 20 --> num = 20
        // num = num + 10 ����� �������� �� num += 10;
        // � ��� ��� ���� �������������� ����������
        num -= 10; // ��� num = num - 10; // 20 - 10 --> 10 --> num = 10
        num *= 10; // ��� num = num * 10; // 10 * 10 --> 100 --> num = 100
        num /= 10; // ��� num = num / 10; // 100 / 10 --> 10 --> num = 10
        num %= 10; // ��� num = num % 10; // 10 % 10 --> num = 0

    }
}
