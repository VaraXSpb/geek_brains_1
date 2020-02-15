package homework3;

import java.util.Random;
import java.util.Scanner;
// Домашнее Задание 3
// Сделано 2 задания

public class Main {

    static Random random;
    static Scanner sc;
    static int answer;
    static int randomAnswer;
    static int counter;
    static String userAnswer;
    final static int MAX_COUNT = 3;

    public static void main(String[] args) {
        deployGame();
    }

    public static void deployGame() {
        sc = new Scanner(System.in);
        random = new Random();

        System.out.println("Введите номер игры для запуска:\n1. Угадай число\n2. Угадай слово");
        answer = sc.nextInt();
        if (answer == 1) {
            runGame1();
        } else if (answer == 2) {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            runGame2(words);
        } else {
            System.out.println("Игры с таким номером нет!");
        }
    }

    public static void runGame1() {
        randomAnswer = random.nextInt(10);
        counter = 0;

        System.out.printf("Я загадал число от 0 до 9. Попроубуйте угадать за %d попытки.\nВведите число:", MAX_COUNT);
        System.out.println();

        do {
            if (counter == MAX_COUNT) {
                System.out.printf("Вы проигарли! Загаданное число - %d!", randomAnswer);
                break;
            }
            answer = sc.nextInt();
        } while (!compareAnswer(answer, randomAnswer));
    }

    public static boolean compareAnswer(int userAnswer, int correctAnswer) {
        if (userAnswer > correctAnswer) {
            counter++;
            System.out.printf("Загаданное число меньше %d. Осталось попыток: %d.", userAnswer, MAX_COUNT - counter);
            System.out.println();
        } else if (userAnswer < correctAnswer) {
            counter++;
            System.out.printf("Загаданное число больше %d. Осталось попыток: %d", userAnswer, MAX_COUNT - counter);
            System.out.println();
        } else {
            System.out.printf("Вы угадали! Загаданное число - %d!", correctAnswer);
        }
        return userAnswer == correctAnswer;
    }

    public static void runGame2(String[] words) {
        String correctAnswer = words[random.nextInt(words.length)];
        System.out.printf("Я загадал слово на английском. Это ягода, овощь или фрукт.\nПопробуй угадать:");
        System.out.println();
        userAnswer = sc.nextLine();

        do {
            userAnswer = sc.nextLine();
        } while (!compareAnswer(userAnswer, correctAnswer));
    }

    public static boolean compareAnswer(String userAnswer, String correctAnswer) {
        if (!userAnswer.equals(correctAnswer)) {
            String hiddenAnswer = "";
            int length;

            if (userAnswer.length() > correctAnswer.length()) {
                length = correctAnswer.length();
            } else {
                length = userAnswer.length();
            }

            for (int i = 0; i < length; i++) {

                if (correctAnswer.charAt(i) == userAnswer.charAt(i)) {
                    hiddenAnswer += userAnswer.charAt(i);
                } else {
                    hiddenAnswer += '#';
                }
            }

            hiddenAnswer = addLetters(hiddenAnswer, "#", 15 - hiddenAnswer.length());

            System.out.printf("Не угадал! Посмотри, есть ли буквы на своих местах: %s\nПопробуй еще:\n", hiddenAnswer);
            return false;
        } else {
            System.out.printf("Слово введено верно! Это %s.", correctAnswer);
            return true;
        }
    }

    public static String addLetters(String s, String add, int length) {
        for (int i = 0; i < length; i++) {
            s += add;
        }
        return s;
    }
}
