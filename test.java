import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
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
        // у нас ест список размеров слов
        for (int index = 0; index < words.size(); index++) {
            Integer elementLength = words.get(index).length();
            sizeWords.add(elementLength);
        }
        System.out.println(sizeWords); // получили размеры слов
        // нужно добавить в список слова с определенный размеров
        for (int i = 0; i < sizeWords.size(); i++) {
            Integer wordLength = sizeWords.get(i);
            // System.out.println(sizeWords.get(i));
            stats.put(wordLength, adds);
        }

        // проходимся по мэпу и выводим слова
        for (Map.Entry<Integer, List<String>> entry : stats.entrySet()) {
            System.out.println("Длина слова = " + entry.getKey() + "  Список слов = " + entry.getValue());           
            Integer r = entry.getKey();
            for (int index = 0; index < words.size(); index++) {
                Integer elementLength = words.get(index).length();
            //     sizeWords.add(elementLength);
            //     adds.add("0");
            if (elementLength.equals(entry.getKey()) == true) {
                System.out.println(words.get(index));
            }
            }
            
        }
         
        System.out.println();

        //     adds.add(element);

        
        // Set<Integer> keys = stats.keySet();
        // System.out.println(stats);
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
