import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class programm5 {
    public static void main(String[] args) {
        String text = "й r. ew извлечь из него все слова, и отсортировать; по длине. Мороз и солнце- день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        Map<Integer, List<String>> stats = new HashMap<>();
        /**
         * (?U) - пробельные символы (оставляем)
         * [^ - начало исключающего симв класса, находит любой символ, отличный от заданных в классе
         * \p{L} - любая буква юникода
         * \p{N} - ллюбая цифра 
         * \s - находит любой пробельный символ благодаря (?U)
         * ]+ - конец символьного класса (быстрое удаление)
         * "Есть текст. Нужно извлечь из него все слова, и отсортировать; по длине. Мороз и солнце- день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись"
         */
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> sizeWords = new ArrayList<>();
        addPrintElement(text, words, result);
        collectStats(text, words, stats, sizeWords);
    }
    static void collectStats(String text, ArrayList<String> words, Map<Integer, List<String>> stats, ArrayList<Integer> sizeWords) {
        List<String> adds = new ArrayList<String>();

        for (int index = 0; index < words.size(); index++) {
            Integer elementLength = words.get(index).length();
            sizeWords.add(elementLength);
        }
        System.out.println(sizeWords); // получили размеры слов

        for (int i = 0; i < words.size(); i++) {
            Integer elementLength = words.get(i).length(); // длина каждого слова
            String element = words.get(i); // каждое слово
            // adds.add(element);
            // Integer t = 1;
            // System.out.println(stats);
            for (int j = 0; j < words.size(); j++) {
                if (sizeWords.get(j) == i) {
                    adds.add(element);
                    stats.put(sizeWords.get(j), adds);
                    // j++;
                    // t++;
                    // System.out.println(i);
                } 
                else {

                    // j++;
                }
            }
 
            // t++;
            //  else {
            //     t = t + 1;
            // }

        }
        
        // Set<Integer> keys = stats.keySet();
        System.out.println(stats);
        // System.out.println(keys);
        // ArrayList<String> list = new ArrayList<>(List.of("3e19d", "3.14F", "string", "-7j", "444.444d", "5.0439", "1.1E+50", "-12", "my_value", "23.04j"));
        // System.out.println(list);
    }
    static void addPrintElement(String text, List<String> words, String result) { // получили элементы
        for (String wordss : result.split(" ")) {
            // System.out.println(wordss);
            words.add(wordss); // добавили все элементы в список
        }
        // System.out.println(words);
    }
}


/**
 * Есть тест. Нужно извлечь из него все слова и отсортировать по длине.
 * Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись
 *
 * и
 * ты
 * Еще
 * день друг Пора
 * ..
 *
 */
