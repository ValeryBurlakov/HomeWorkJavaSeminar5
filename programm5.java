import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class programm5 {
    public static void main(String[] args) {
        String text = "Есть текст. Нужно извлечь из него все слова, и отсортировать; по длине. Мороз и солнце- день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        String result = text.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
        Map<Integer, List<String>> stats = new HashMap<>();
        /**
         * (?U) - пробельные символы (оставляем)
         * [^ - начало исключающего симв класса, находит любой символ, отличный от заданных в классе
         * \p{L} - любая буква юникода
         * \p{N} - ллюбая цифра 
         * \s - находит любой пробельный символ благодаря (?U)
         * ]+ - конец символьного класса (быстрое удаление)
         */
        List<String> words = new ArrayList<>();

        addPrintElement(text, words, result);
    }
    static void collectStats(String text, List<String> words) {
        
        for (int i = 0; i < words.size(); i++) {
            
        }

        // ArrayList<String> list = new ArrayList<>(List.of("3e19d", "3.14F", "string", "-7j", "444.444d", "5.0439", "1.1E+50", "-12", "my_value", "23.04j"));
        // System.out.println(list);
    }
    static void addPrintElement(String text, List<String> words, String result) { // получили элементы
        for (String wordss : result.split(" ")) {
            System.out.println(wordss);
        }
            // String[] wordss = text.split(" ");
            // System.out.println(wordss);
            // int num = Integer.parseInt(consData[1]); // получение 2 элемента не нужно
            // int localSize = num - words.size();
            // for (int i = 0; i <= localSize; i++) {
            //     words.add(text[i]);
            // }
            // if (consData[0].equals("print")) {
            //     System.out.println(listData.get(num));
            //     System.out.printf("Введите команду: ");
            // } 
            // else {
            //     System.out.println("Массив пополняется, Сэр");
            //     listData.set(num, consData[0]);
            //     System.out.printf("Введите команду: ");
            // }
   
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
