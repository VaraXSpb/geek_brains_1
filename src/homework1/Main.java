package homework1;

public class Main {

    public static void main(String[] args) {
        byte a = 3;
        short b = 240;
        int c = 15044;
        long d = 1500000000000L;
        float e = 2.5f;
        double f = 45.75543;
        boolean g = true;
        char h = 'h';
        String s = "Hello, World!";
    }

    private static double findResult(double a, double b, double c, double d) {
        double result = a * (b + (c / d));
        return result;
    }

    private static boolean checkTwoNumbers(int a, int b) {
        if ((a + b) <= 20 && (a + b) >= 10) {
            return true;
        } else {
            return false;
        }
    }

    private static void checkNumberValue(int num) {
        if (num >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    private static boolean checkNegativeNumber(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void helloByName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void checkYear(int year) {
        if (year % 100 == 0 && year % 400 != 0) {
            System.out.println("Вы указали не високосный год");
        } else if (year % 4 == 0) {
            System.out.println("Вы указали високосный год");
        } else {
            System.out.println("Вы указали не високосный год");
        }
    }
}
