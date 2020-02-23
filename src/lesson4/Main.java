package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {


    final static char DOT_X = 'X';
    final static char DOT_O = 'O';
    final static char DOT_NULL = '.';
    final static int DOTS_TO_WIN = 5;
    final static int MAP_SIZE = 7;
    public static final String PLAYER_COLOR = "\u001B[32m";
    public static final String AI_COLOR = "\u001B[31m";
    public static final String DEFAULT_COLOR = "\u001B[37m";
    static char[][] map;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int ctr = 0;

    //Переменные для анализа направления построения линии AI
    public static int aiX = -1;
    public static int aiY = -1;
    public static int dX = 0;
    public static int dY = 0;


    public static void main(String[] args) {
        initMap(MAP_SIZE);
        int maxTurns = map.length * map.length;

        do {
            playerTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Игрок победил и спас мир!");
                break;
            }

            ctr++;
            if (ctr == maxTurns) {
                System.out.println("Силы машины и человека оказались равны!");
                break;
            }

            aiTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Машина победила и началось восстание!");
                break;
            }

            ctr++;
        } while (ctr < maxTurns);

    }

    public static void initMap(int size) {

        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            System.out.printf("\t%d", (i + 1));
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_NULL;
                System.out.printf("\t%c", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void playerTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты ячейки, в которую хотите походить (строка, столбец):");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (y >= map.length && x >= map.length || x < 0 && y < 0 || isFilled(map[y][x]));

        map[y][x] = DOT_X;
    }

    public static void printMap() {
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.printf("\t%d", (i + 1));
        }
        System.out.println();

        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < map.length; j++) {

                //Печать карты с учетом цветов игроков
                if (map[i][j] == DOT_X) {
                    System.out.printf(PLAYER_COLOR + "\t%c" + DEFAULT_COLOR, map[i][j]);
                } else if (map[i][j] == DOT_O) {
                    System.out.printf(AI_COLOR + "\t%c" + DEFAULT_COLOR, map[i][j]);
                } else {
                    System.out.printf("\t%c" + DEFAULT_COLOR, map[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void aiTurn() {
        int x;
        int y;
// Проверка возможного выигрыша человека (на следующий ход вперед). Если да, то занимаем клетку
        if (checkExpectedWin(DOT_O, DOT_O)) {

// Проверка возможности выигрыша машины за текущий ход. Если да, то выигрываем.
        } else if (checkExpectedWin(DOT_X, DOT_O)) {

// Проверка, началась ли собираться линия, чтобы продолжить её собирать
        } else if (aiX < map.length && aiY < map.length && aiX >= 0 && aiY >= 0 && !isFilled(map[aiY][aiX])) {
            map[aiY][aiX] = DOT_O;
            if (dX > 0) {
                aiX += 1;
            } else if (dX < 0) {
                aiX -= 1;
            }
            if (dY > 0) {
                aiY += 1;
            } else if (dY < 0) {
                aiY -= 1;
            }
// Начать сбор линии в сторону, в которую возможно её собрать (от предыдущего хода)
        } else if (aiMakeLine()) {
// Рандомный ход
        } else {
            do {
                y = random.nextInt(MAP_SIZE);
                x = random.nextInt(MAP_SIZE);
            } while (isFilled(map[y][x]));
            map[y][x] = DOT_O;
        }
    }

    // Начать сбор линии в сторону, в которую ее возмоно собрать относительно первого попавщегося элемента О
    // TODO: Упростить метод
    public static boolean aiMakeLine() {
        aiX = -1;
        aiY = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_O) {
                    if (i + 1 < map.length && i + DOTS_TO_WIN <= map.length && !isFilled(map[i + 1][j]) && isLineFree(i,j,1,0,1)) {
                        map[i + 1][j] = DOT_O;
                        aiX = j;
                        aiY = i + 2;
                        dY = 2;
                        return true;
                    }
                    if (i - 1 >= 0 && i + 1 - DOTS_TO_WIN >= 0 && !isFilled(map[i - 1][j])&& isLineFree(i,j,-1,0,1)) {
                        map[i - 1][j] = DOT_O;
                        aiX = j;
                        aiY = i - 2;
                        dY = -2;
                        return true;
                    }
                    if (j + 1 < map.length && j + DOTS_TO_WIN <= map.length && !isFilled(map[i][j + 1])&& isLineFree(i,j,1,1,0)) {
                        map[i][j + 1] = DOT_O;
                        aiX = j + 2;
                        aiY = i;
                        dX = 2;
                        return true;
                    }
                    if (j - 1 >= 0 && j + 1 - DOTS_TO_WIN >= 0 && !isFilled(map[i][j - 1])&& isLineFree(i,j,-1,1,0)) {
                        map[i][j - 1] = DOT_O;
                        aiX = j - 2;
                        aiY = i;
                        dX = -2;
                        return true;
                    }

                }
            }
        }
        return false;
    }
// Проверка наличия Х по линии, где собирается начаться сбор линии AI
    public static boolean isLineFree(int y, int x, int vector, int horizontal, int vertical) {
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (isFilledByX(map[y + i * vector * vertical][x + i * vector * horizontal])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkExpectedWin(char dotCheck, char dotWin) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!isFilled(map[i][j])) {
                    map[i][j] = dotCheck;
                    if (isWin(dotCheck)) {
                        map[i][j] = dotWin;
                        return true;
                    }
                    map[i][j] = DOT_NULL;
                }
            }
        }
        return false;
    }

    public static boolean isFilled(char mapElement) {
        return mapElement == DOT_X || mapElement == DOT_O;
    }
    public static boolean isFilledByX(char mapElement) {
        return mapElement == DOT_X;
    }

    public static boolean isWin(char dotType) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (checkWin(j, i, dotType)) {
                    return true;
                }
            }
        }
        return false;
    }

// TODO: Упростить метод
    public static boolean checkWin(int y, int x, char dotType) {

        int ctr;

        //Проверка по горизонтали
        if (x + DOTS_TO_WIN <= map.length) {
            ctr = 0;
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[y][x + i] != dotType) {
                    break;
                }
                ctr++;
            }
            if (ctr == DOTS_TO_WIN) {
                return true;
            }
        }

        //Проверка по вертикали
        if (y + DOTS_TO_WIN <= map.length) {
            ctr = 0;
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[y + i][x] != dotType) {
                    break;
                }
                ctr++;
            }
            if (ctr == DOTS_TO_WIN) {
                return true;
            }
        }

        //Проверка по диагонали вправо
        if (y + DOTS_TO_WIN <= map.length && x + DOTS_TO_WIN <= map.length) {
            ctr = 0;
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[y + i][x + i] != dotType) {
                    break;
                }
                ctr++;
            }
            if (ctr == DOTS_TO_WIN) {
                return true;
            }
        }

        //Проверка по диагонали влево
        if (x >= DOTS_TO_WIN - 1 && y + DOTS_TO_WIN <= map.length) {
            ctr = 0;
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                if (map[y + i][x - i] != dotType) {
                    break;
                }
                ctr++;
            }
            if (ctr == DOTS_TO_WIN) {
                return true;
            }
        }

        return false;
    }
}
