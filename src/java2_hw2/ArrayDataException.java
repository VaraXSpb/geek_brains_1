package java2_hw2;

public class ArrayDataException extends NumberFormatException {
    public ArrayDataException(int i, int j) {
        System.out.printf("В ячейке массива %d,%d находится не число.\nИсправьте ошибку и повторите попытку.\n", i+1, j+1);
    }
}
