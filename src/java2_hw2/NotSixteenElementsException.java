package java2_hw2;

public class NotSixteenElementsException extends ArrayIndexOutOfBoundsException {
    public NotSixteenElementsException(){
        System.out.println("Количество элементов в строке превысило 16.\nНевозможно сгенерировать массив 4x4.");
    }
}
