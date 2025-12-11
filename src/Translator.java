import java.util.HashMap;
import java.util.Map;

/**
 * Клас перекладача з англійської мови на українську
 */
public class Translator {
    private HashMap<String, String> dictionary;

    /**
     * Конструктор, який ініціалізує словник
     */
    public Translator() {
        this.dictionary = new HashMap<>();
    }

    /**
     * Метод для додавання пари слів до словника
     * @param englishWord англійське слово
     * @param ukrainianWord українське слово
     */
    public void addWordPair(String englishWord, String ukrainianWord) {
        if (englishWord != null && ukrainianWord != null) {
            dictionary.put(englishWord.toLowerCase(), ukrainianWord);
        }
    }

    /**
     * Метод для перекладу фрази з англійської на українську
     * @param phrase фраза англійською мовою
     * @return перекладена фраза українською мовою
     */
    public String translate(String phrase) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return "";
        }

        String[] words = phrase.split("\\s+");
        StringBuilder translatedPhrase = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            // Видаляємо розділові знаки для пошуку в словнику
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-ЯіІїЇєЄ]", "");
            
            if (dictionary.containsKey(cleanWord)) {
                String translatedWord = dictionary.get(cleanWord);
                // Зберігаємо розділові знаки з оригінального слова
                String punctuation = word.substring(cleanWord.length());
                translatedPhrase.append(translatedWord).append(punctuation);
            } else {
                // Якщо слова немає в словнику, залишаємо оригінал
                translatedPhrase.append(words[i]);
            }
            
            if (i < words.length - 1) {
                translatedPhrase.append(" ");
            }
        }

        return translatedPhrase.toString();
    }

    /**
     * Метод для отримання словника (для перевірки)
     * @return копія словника
     */
    public Map<String, String> getDictionary() {
        return new HashMap<>(dictionary);
    }

    /**
     * Метод для перевірки, чи містить словник слово
     * @param word слово для перевірки
     * @return true, якщо слово є в словнику
     */
    public boolean containsWord(String word) {
        return dictionary.containsKey(word.toLowerCase());
    }
}

