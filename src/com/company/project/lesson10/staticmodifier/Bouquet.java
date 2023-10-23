package com.company.project.lesson10.staticmodifier;

public class Bouquet {
    public int numberOfFlowers;
    public String type;

    // �� �������� ���������� ��������
    public static int numberOfFlowersStatic;
    public static String typeStatic;

    static { // static ����
        // ���������� ����������� ���� ��� ��� �������� ������
        // � ���������
        // ������������ ��� ������������� static �������,
        // �������� ����� static �������
        typeStatic = getType();
    }

    public double getPrice(){
        double price = Math.random() * 300 * numberOfFlowers;
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    // �� ���������� ���������� ��������
    public /* final �� ��������� */ static double getPriceStatic(){
        // �� static ������� ������:
        // 1. ���������� � �� static ���������
        // 2. �������� �� static ������
        // double price = Math.random() * 300 * this.numberOfFlowers; - ������
        // double price = getPrice(); - ������
        double priceWithStatic = Math.random() * 300 * numberOfFlowersStatic;
        return priceWithStatic;
    }

    private static String getType(){
        String[] types = {"�������", "���������", "����������"};
        return types[(int) (Math.random()*types.length)];
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "numberOfFlowers= " + numberOfFlowers +
                ", numberOfFlowersStatic= " + numberOfFlowersStatic +
                ", type='" + type + '\'' +
                ", typeStatic='" + typeStatic + '\'' +
                '}';
    }
}


