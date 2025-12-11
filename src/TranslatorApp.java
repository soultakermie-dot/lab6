import java.util.Scanner;

/**
 * Консольний додаток для роботи з перекладачем
 */
public class TranslatorApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Translator translator = new Translator();

    public static void main(String[] args) {
        System.out.println("=== Англо-український перекладач ===\n");

        // Наповнення словника базовими словами
        fillDefaultDictionary();

        // Меню для роботи з перекладачем
        boolean running = true;
        while (running) {
            System.out.println("\nВиберіть дію:");
            System.out.println("1. Додати пару слів до словника");
            System.out.println("2. Перекласти фразу");
            System.out.println("3. Вийти");
            System.out.print("Ваш вибір: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addWordPair();
                    break;
                case 2:
                    translatePhrase();
                    break;
                case 3:
                    running = false;
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }

    /**
     * Наповнення словника базовими словами
     */
    private static void fillDefaultDictionary() {
        System.out.println("Наповнення словника базовими словами...");
        translator.addWordPair("hello", "привіт");
        translator.addWordPair("world", "світ");
        translator.addWordPair("good", "добрий");
        translator.addWordPair("morning", "ранок");
        translator.addWordPair("goodbye", "до побачення");
        translator.addWordPair("thank", "дякую");
        translator.addWordPair("you", "ти");
        translator.addWordPair("how", "як");
        translator.addWordPair("are", "є");
        translator.addWordPair("i", "я");
        translator.addWordPair("am", "є");
        translator.addWordPair("fine", "добре");
        translator.addWordPair("yes", "так");
        translator.addWordPair("no", "ні");
        translator.addWordPair("please", "будь ласка");
        translator.addWordPair("cat", "кіт");
        translator.addWordPair("dog", "собака");
        translator.addWordPair("house", "дім");
        translator.addWordPair("car", "автомобіль");
        System.out.println("Словник наповнено базовими словами.\n");
    }

    /**
     * Метод для додавання пари слів з клавіатури
     */
    private static void addWordPair() {
        System.out.print("Введіть англійське слово: ");
        String englishWord = scanner.nextLine().trim();

        if (englishWord.isEmpty()) {
            System.out.println("Помилка: слово не може бути порожнім.");
            return;
        }

        System.out.print("Введіть український переклад: ");
        String ukrainianWord = scanner.nextLine().trim();

        if (ukrainianWord.isEmpty()) {
            System.out.println("Помилка: переклад не може бути порожнім.");
            return;
        }

        translator.addWordPair(englishWord, ukrainianWord);
        System.out.println("Пара слів додана до словника: " + englishWord + " -> " + ukrainianWord);
    }

    /**
     * Метод для перекладу фрази
     */
    private static void translatePhrase() {
        System.out.print("Введіть фразу англійською мовою: ");
        String englishPhrase = scanner.nextLine().trim();

        if (englishPhrase.isEmpty()) {
            System.out.println("Помилка: фраза не може бути порожньою.");
            return;
        }

        String ukrainianPhrase = translator.translate(englishPhrase);
        System.out.println("Переклад: " + ukrainianPhrase);
    }

    /**
     * Метод для безпечного введення цілого числа
     */
    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Будь ласка, введіть число: ");
            }
        }
    }
}

