package lesson05;


import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // ������� - ����������� ������� ������ ��� �������� �������� ������ ����
        // �������� (��������) � ������� �������� ��� ��������� (��������� ���������� 0)
        // 1. ���������� ���������� �������: ���������[] �������������
        // 2. ������������� ������� �������: new ���������[len]
        // ����� ������ ������ �� len ���������, ����������� ���������� �� ���������.
        // ��� ����� - 0, ��� ����������� ���� - false,
        // ��� char - '\u0000' ��� 0 (������ ������),
        // ��� ��������� ����� - null
        // 3. ������������� ������������ �������: {��������1, ��������2, ��������3,..., ��������N}
        // 4. ��������������� ������� = new int[]{��������1, ��������2, ��������3,..., ��������N}
        // 5. ����� ������� - ���������� ��������� �������, ��������������� �������� ���� int
        // ����� �������� ������
        // ����� ������� ����� ���������� ����� ���������� ��� ���������
        // 6. ��������� � �������� ������� �������������[������]
        // ��������� � ��������������� ������� (����� �� ������� �������) - java.lang.ArrayIndexOutOfBoundsException

        // ������ ������ �� 3 ��������, ����������� ���������� �� ���������, �.�. 0.0
        int len = 3;
        double[] prices = new double[len]; // [0.0, 0.0, 0.0]
        // �������� �������� � �������� 0 ����� �������� �� 67.5
        prices[0] = 67.5; // [67.5, 0.0, 0.0]
        // �������� �������� � �������� 1 ����� �������� �� 100.5
        prices[1] = 100.5; // [67.5, 100.5, 0.0]
        // �������� �������� � �������� 2 ����� �������� �� 300.0
        prices[2] = 300; // [67.5, 100.5, 300.0]

        int[] temperatures = {12, 14, 15, 17, 22, 24, 10}; // 7
        // �������� �������� � �������� 0 ����� �������� � �������
        System.out.println(temperatures[0]); // 12
        // �������� �������� � �������� 3 ����� �������� �� 20
        temperatures[3] = 20;

        // ������ �������
        System.out.println(prices.length); // 3
        System.out.println(temperatures.length); // 7

        // ������� ������� #1:
        // ���� ����������� �������� �������� � �����
        // ���� ����������� ���������� ������
        // �� ������ �� ������� �������� � ����������

        // ���������� i ������ ������ �������� �������
        // � ����������� � ������ ��������� �����
        // ��� ������� � ��������� ������� ������������ []
        for (int i = 0; i < prices.length; i++) { // fori
            // ����������� �������� ������� �������� �������,
            // ������� � �������
            prices[i] *= 1.2;
        }
        // {12, 14, 15, 17, 22, 24, 10}
        for (int i = temperatures.length - 1; i >= 0; i--) { // fori
            if (temperatures[i] >= 20) {
                temperatures[i] = -temperatures[i];
            }
        }

        // ������� ������� #2:
        // ��� ������� � ��������
        // ��� ����������� �������� �������� � �����
        // ����� ���������� ������ ������ �� ������� �������� � ����������

        // �� ������ �������� ����� � ���������� temperature ���������� �������� �������� �������
        int sum = 0;
        for (var /*int*/ temperature : temperatures) { // iter
            sum += temperature;
        }
        System.out.println("������� �����������: " + ((double) sum / temperatures.length));

        for (var/*double*/ price : prices) {
            if (price > 100) {
                System.out.println(price);
                break;
            }
        }

        // ����� Arrays �������� ������ ��� ������ � ���������
        // ��������� ������: import java.util.Arrays
        int[] ids = {2, 5, 7, 8, 9, 12, 44, 67};

        System.out.println(Arrays.toString(ids));

        // ������ ��� ������ � ���������
        double[] temps = {45.7, 22.9, 12.0, 33.8, 98.1};
        // ����������
        Arrays.sort(temps); // ������ �������� ������
        System.out.println(Arrays.toString(temps));

        // �������� ����� [12.0, 22.9, 33.8, 45.7, 98.1]
        System.out.println(Arrays.binarySearch(temps, 98.1)); // 4
        System.out.println(Arrays.binarySearch(temps, 6)); // -1

        // �������� �����
        // 1) ��������� ������� ������ ����� �������
        double[] newTemps01 = temps.clone();
        System.out.println(Arrays.toString(newTemps01));

        // 2) ��������� ����������� ��������� ������ ��������� �������
        // ��� ������� ������ ����� �������
        double[] newTemps02 = Arrays.copyOf(temps, 3);
        System.out.println(Arrays.toString(newTemps02));

        // 3) System.arraycopy(Object src, int srcPos, Object dst, int dstPos, int len)
        // ����� �������� len ��������� ������� src, ������� � ������� srcPos,
        // � ������ dst, ������� � ������� dstPos.
        // ������ dst ������ ����� ����������� ������,
        // ����� � ��� ����������� ��� ���������� ��������.
        // [12.0, 22.9, 33.8, 45.7, 98.1]
        double[] newTemps03 = new double[30];
        System.arraycopy(temps, 0, newTemps03, 10, temps.length);
        System.out.println(Arrays.toString(newTemps03));

        // ������ � ���������:
        // 1. ����������
        // 2. �������� �����
        // 3. ������� �� ������� ��������
        // 4. ������� �� ���������� ��������
        // 5. ������� ����� ��� ��������� (��� ���������� ����� ��������� ������)
        // 6. ����� ����������� ����. ������������ ��� ������� ������� � ������������,
        // ����������� ('����� ����� ��������� ����������', '����� ������� ����������' � �.�)
        // ������: ��� ��������� ��������� � ���� ������� �� �����������, �������� ����.
        // � ���� ���������� ����������� ���� �������, �� ���� ��������� ���� �������.
        // ������������� ��������� �������������, ��� ������������� �����������.
        // ������ ���� ����� ���� �������� ��� ������������ (����� ���� ������� �����������,
        // � ����� ��������)
        // wSize = 3;
        // [3, 4, 5, 7, 1, 2, 9]
        // wStart = 0, wEnd = 0;
        /*
        int sum = 0;
        for (int wEnd = 0; wEnd < arr.len; wEnd++) {
            sum+=arr[wEnd];
            if (){
                sum-=arr[wStart];
                wStart++;
            }
        }

        int[] someArr = {3, 4, 5, 7, 1, 2, 9};
        int target = 20;
        int wStart = 0;
        int subArrSum = 0;
        int subArrLen = 10000;
        for (int wEnd = 0; wEnd < someArr.length; wEnd++) { // ���������� ����
            subArrSum += someArr[wEnd];
            while (subArrSum >= target){
                subArrLen = Math.min(subArrLen, wEnd - wStart + 1)
                subArrSum -= someArr[wStart];
                wStart++;
            }
        }
        */

        // TODO #1
        // ��� ��������������� ������ ����� �����. ����� ������������ �������
        int[] task01 = {4, 6, 89, 90, 220, 560, 780};
        System.out.println(task01[task01.length-1]);

        // TODO #2
        // ��� ��������������� ������ ������������� ����� ����� task02.
        // ����� � ������ ������� ����� ��� ����� (���� ����), ����� �� ����� ���� ����� targetSum.
        int[] task02 = {1, 3, 7, 8, 9, 10, 13};
        int targetSum = 10;
        // ��������� ����
        out: for (int i = 0; i < task02.length; i++) {
            for (int j = i + 1; j < task02.length; j++) {
                if (task02[i] + task02[j] == targetSum) {
                    System.out.println(task02[i]);
                    System.out.println(task02[j]);
                    break out;
                }
            }
        }
        // ��� ���������
        int low = 0;
        int high = task02.length - 1;
        while (low < high){
            int sumToFind = task02[low] + task02[high];
            if (sumToFind == targetSum) {
                System.out.println(task02[low]);
                System.out.println(task02[high]);
                break;
            }
            if (sumToFind > targetSum) high--;
            else low++;
        }
    }
}
