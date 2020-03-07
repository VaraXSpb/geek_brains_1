package java2_hw2;

import java.util.Arrays;

public class Main {
    private static String msg = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static String[][] array;


    public static void main(String[] args) {
        try {
            makeArray4x4(msg);
            System.out.println(convertToIntAndReturnSumDivTwo(array));
        } catch (NotSixteenElementsException | ArrayDataException e ) {
            e.printStackTrace();
        }

    }

    private static void makeArray4x4(String msg) throws NotSixteenElementsException {
        msg = msg.replace("\n", " ");
        String[] a = msg.split(" ");

        if (a.length != 16) {
            throw new NotSixteenElementsException();
        }

        array = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = a[j + i * 4];
            }
        }
    }

    private static void printArray4x4(String[][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int convertToIntAndReturnSumDivTwo(String[][] array) throws ArrayDataException {
        int result = 0;
        int[][] arrInt = new int[array.length][array.length];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    arrInt[i][j] = Integer.parseInt(array[i][j]);
                    result += arrInt[i][j];
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j);
                }
            }
        }
        return result / 2;
    }
}
