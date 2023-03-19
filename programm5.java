import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class programm5 {
    public static void main(String[] args) {
        String text = "й r. ew извлечь из него все слова Ростов-на-Дону, и отсортировать; по длине. Мороз и солнце- день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\-\\s]+", "");
        Map<Integer, List<String>> stats = new HashMap<>();
        /**
         * (?U) - пробельные символы (оставляем)
         * [^ - начало исключающего символьного класса, находит любой символ, отличный от заданных в классе
         * \p{L} - любая буква юникода
         * \p{N} - ллюбая цифра 
         * \s - находит любой пробельный символ благодаря (?U)
         * ]+ - конец символьного класса (быстрое удаление)
         * "Есть текст. Нужно извлечь из него все слова, и отсортировать; по длине. Мороз и солнце- день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись"
         */

        ArrayList<String> words = new ArrayList<>(); // Список слов из текста
        ArrayList<Integer> sizeWords = new ArrayList<>(); // список длин слов
        gettingElement(text, words, result);
        collectStats(text, words, stats, sizeWords);
    }

    static void collectStats(String text, ArrayList<String> words, Map<Integer, List<String>> stats, ArrayList<Integer> sizeWords) {
        List<String> adds = new ArrayList<String>(); // список слов одной длины

        // у нас есть список длины слов
        for (int index = 0; index < words.size(); index++) {
            Integer elementLength = words.get(index).length();
            sizeWords.add(elementLength);
        }
        // System.out.println(sizeWords); // Вывод списка с длиной слов

        // нужно поместить в мэп слова с определенным размером
        for (int i = 0; i < sizeWords.size(); i++) {
            Integer wordLength = sizeWords.get(i);
            stats.put(wordLength, adds); // привязываем к ключу в мэп список слов одинаковой длины
        }

        // проходимся по мэпу и выводим слова
        for (Map.Entry<Integer, List<String>> entry : stats.entrySet()) {
            
            // пока выбран ключ, проходимся по списку длин слов
            for (int index = 0; index < words.size(); index++) {
                Integer elementLength = words.get(index).length();

                // если ключ эквивалентен длине слова, добавляем слово в список
                if (elementLength.equals(entry.getKey()) == true) {
                    // System.out.println(words.get(index)); // можно слова вывести так
                    adds.add(words.get(index));
                }
            }
            // System.out.println(adds); // можно вывести слова и так "списком"
            System.out.println("Длина " + entry.getKey() + " Список слов = " + entry.getValue()); // вывод мэпа       
            adds.removeAll(adds); // очищаем список слов одинаковой длины
        }
         
    }
    static void gettingElement(String text, List<String> words, String result) { // получили элементы
        for (String wordss : result.split("[ -]+")) {
            words.add(wordss); // добавили все слова в список
        }

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
