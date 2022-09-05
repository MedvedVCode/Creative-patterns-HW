package logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainLogger {
    public static Logger logger = Logger.getInstance();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int listSize = getIntFromConsole("Введите размер списка: ");
        int maxItem = getIntFromConsole("Введите верхнюю границу для значений: ");

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxItem));
        }
        logger.log("Случайный список: " + list);

        int filterThreshold = getIntFromConsole("Введите порог для фильтра: ");
        Filter filter = new Filter(filterThreshold);
        logger.log("Отфильтрованный список: " + filter.filterOut(list));
        logger.log("Программа закончила работу! Bye!");
    }

    private static int getIntFromConsole(String logText) {
        logger.log(logText);
        boolean isCorrect = false;
        int result = 0;
        while (!isCorrect) {
            String console = sc.nextLine();
            if (console.matches("[-+]?\\d+")) {
                result = Integer.parseInt(console);
                if (result <= 0) {
                    logger.log("Неверный диапазон числа. " + logText);
                } else {
                    isCorrect = true;
                }
            } else {
                logger.log("Неверный формат числа. " + logText);
            }
        }
        return result;
    }


}
