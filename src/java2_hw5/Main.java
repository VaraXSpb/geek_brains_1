package java2_hw5;

import java.util.Arrays;

public class Main {
    static int size = 10000000;
    static int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1;
    static float[] a2;

    public static void main(String[] args) {
        System.out.println("Результаты работы первого метода (один поток):");
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        first(arr);
        a = System.currentTimeMillis() - a;
        System.out.println("Время работы метода, мс - " + a);
        System.out.println("Сумма элементов рассчитанного массива: " + sum(arr));

        System.out.println();

        System.out.println("Результаты работы второго метода (два потока):");
        Arrays.fill(arr, 1);
        a = System.currentTimeMillis();
        second(arr);
        a = System.currentTimeMillis() - a;
        System.out.println("Время работы метода, мс - " + a);
        System.out.println("Сумма элементов рассчитанного массива: " + sum(arr));
    }

    public static void first(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void second(float[] arr) {
        a1 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);

        a2 = new float[h];
        System.arraycopy(arr, h, a2, 0, h);

        Thread first = new Thread(() -> {
            calculate(a1, 0);
            System.arraycopy(a1, 0, arr, 0, h);
        });
        first.start();

        Thread second = new Thread(() -> {
            calculate(a2, h);
            System.arraycopy(a2, 0, arr, h, h);
        });
        second.start();

        // Чтобы подсчитать время выполнения, джоиним методы.
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            first.interrupt();
            second.interrupt();
        }
    }

    public static void calculate(float[] arr, int index) {
        for (int i = index, j = 0; i < arr.length + index; i++, j++) {
            arr[j] = (float) (arr[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    // Вспомогательный метод для косвенной првоерки результатов работы первого и второго способов
    public static float sum(float[] arr) {
        float sum = 0;
        for (float element : arr) {
            sum += element;
        }
        return sum;
    }
}
