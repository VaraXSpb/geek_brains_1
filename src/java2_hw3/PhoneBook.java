package java2_hw3;

import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {

    public PhoneBook(Person[] persons) {
        fillPhoneBook(persons);
    }

    private HashMap<String, LinkedList<Person>> phoneBook = new HashMap<>();

    //Добавление элементов в HashMap (в т. ч. разных значений для 1 ключа)
    private void fillPhoneBook(Person[] persons) {
        for (Person p : persons) {
            if (!phoneBook.containsKey(p.getName())) {
                phoneBook.put(p.getName(), new LinkedList<>());
            }
            phoneBook.get(p.getName()).add(p);
        }
    }

    //Поиск по ключу и вывод всех значений, которые содержит ключ
    public void searchPhoneByName(String name) {
        if (!phoneBook.containsKey(name)) {
            System.out.println("Данных по человеку не найдено.");
        } else {
            int size = phoneBook.get(name).size();
            System.out.printf("\nПо фамилии %s найдено номеров телефонов: %d\n", name, size);
            if (size > 1) {
                for (Person p : phoneBook.get(name)) {
                    System.out.print(p.getPhone() + " ");
                }
            } else {
                System.out.print(phoneBook.get(name).getFirst().getPhone());
            }
        }
    }

    public void searchEmailByName(String name) {
        if (!phoneBook.containsKey(name)) {
            System.out.println("Данных по человеку не найдено.");
        } else {
            int size = phoneBook.get(name).size();
            System.out.printf("\nПо фамилии %s найдено адресов электронной почты: %d\n", name, size);
            if (size > 1) {
                for (Person p : phoneBook.get(name)) {
                    System.out.print(p.getEmail() + " ");
                }
            } else {
                System.out.print(phoneBook.get(name).getFirst().getEmail());
            }
        }
    }
}
