package lesson2;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    static int[] arr = {1, 1, 0, 0, 1, 0, 1, 0, 0, 1};
    static int[] arr2 = new int[8];
    static int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    static int[] arr4 = {2, 2, 2, 1, 2, 2, 10, 1};
    static int[] arr5 = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        changeValues(arr);
        printArray(arr);

        fillArray(arr2);
        printArray(arr2);

        multiply6(arr3);
        printArray(arr3);

        print2DArray(fill2DArrayWith1(create2DArray(10)));

        System.out.println("В массиве " + Arrays.toString(arr3) + " максимальный элемент: " + maxElementOfArray(arr3));

        System.out.println("");
        System.out.println("В массиве " + Arrays.toString(arr4) + " есть места, где левая и правая часть равны: " + checkMirror(arr4));

        System.out.println("");
        printArray(scrollArray(arr5, 2));
    }

    // Печать массива
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    //Задание 1. Поменять 0 и 1
    private static void changeValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }

    //Задание 2. Заполнить массив числами 0, 3, 6 ...
    private static void fillArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
    }

    //Задание 3. Умножить все элементы массива <6 на 2
    private static void multiply6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    //Задание 4. Заполнить диагонали двумерного массива единицами
    private static int[][] create2DArray(int n) {
        int[][] arr2D = new int[n][n];
        return arr2D;
    }

    private static int[][] fill2DArrayWith1(int[][] arr2D) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D.length; j++) {
                if (i == j || i + j == arr2D.length - 1) {
                    arr2D[i][j] = 1;
                }
            }
        }
        return arr2D;
    }

    private static void print2DArray(int[][] arr2D) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D.length; j++) {
                System.out.printf("%d\t", arr2D[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Задание 5. Максимальный элемент массива
    private static int maxElementOfArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //Задание 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true.

    private static boolean checkMirror(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (partOfArraySum(arr, 0, i) == partOfArraySum(arr, i, arr.length)) {
                return true;
            }
        }
        return false;
    }

    //Суммирование массива от [i до j) элемента
    public static int partOfArraySum(int a[], int i, int j) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += a[k];
        }
        return sum;
    }

    //Задание 7. Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен
    // сместить все элементымассива на n позиций. Для усложнения задачи нельзя
    // пользоваться вспомогательными массивами.

    private static int[] scrollArray(int[] arr, int n) {
        if (n<0){
            return scrollArrayLeft(arr,n);
        } else if (n==0){
            return arr;
        }

        int a = 0;
        int b = 0;
        do {
            int el=arr[arr.length-1];
            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0) {
                    a = arr[i];
                    arr[i] = b;
                } else {
                    b = arr[i];
                    arr[i] = a;
                }
            }
            arr[0]=el;
            n--;
        } while (n != 0);

        return arr;
    }

    private static int[] scrollArrayLeft(int[] arr, int n) {
        int a = 0;
        int b = 0;
        do {
            int el=arr[0];
            for (int i = arr.length-1; i >=0; i--) {
                if (i % 2 == 0) {
                    a = arr[i ];
                    arr[i] = b;
                } else {
                    b = arr[i];
                    arr[i] = a;
                }
            }
            arr[arr.length-1]=el;
            n++;
        } while (n != 0);

        return arr;
    }
}
