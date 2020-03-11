package java2_hw3;

public class Main {

    private static final String[] str = {"жили", "ли", "ежи", "а", "ежели", "жили", "то", "жалили", "ли", "ежей", "жужелицы"};
    private static final Person[] persons = {new Person("Иванов", "290999", "1@mail.ru"),
            new Person("Иванов", "1234", "2@mail.ru"),
            new Person("Сидоров", "5678", "3@mail.ru"),
            new Person("Петров", "1122331", "4@mail.ru"),
            new Person("Иванов", "334455", "5@mail.ru"),
            new Person("Сидоров", "009988", "6@mail.ru"),
            new Person("Васильев", "776655", "7@mail.ru"),
            new Person("Петров", "445599", "8@mail.ru")};

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.countWords(str);
        task1.uniqueWords(str);

        PhoneBook book = new PhoneBook(persons);
        book.searchPhoneByName("Сидоров");
        book.searchEmailByName("Иванов");
    }
}
