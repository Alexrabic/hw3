package org.example;

import java.util.HashSet;
import java.util.Set;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     *
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     *
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        if (str == null) {
            throw new NullPointerException("Нельзя передавать null");
        }

        String maxString = "";
        if (str.isEmpty()) {
            return maxString;
        }

        int maxLength = 0;
        String maxSubstring = "";
        int currentLength = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            if (currentChar == nextChar) {
                if (maxSubstring.length() >= maxString.length()) {
                    maxString = maxSubstring + currentChar;
                }
                currentLength = 0;
                maxSubstring = "";
            } else {
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
                maxSubstring += currentChar;
                if (maxSubstring.length() > maxString.length()) {
                    maxString = maxSubstring;
                }
            }
        }

        var lastChar = str.charAt(str.length() - 1);
        if (str.charAt(str.length() - 2) == lastChar) {
            maxString = maxSubstring + lastChar;
        } else {
            maxSubstring += lastChar;
            if (maxSubstring.length() > maxString.length()) {
                maxString = maxSubstring;
            }
        }
        return maxString;
    }


    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     *
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Нельзя передавать null");
        }

        if (sentence.isEmpty()) {
            return false;
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : sentence.toLowerCase().replaceAll("\\d|\\s", "").toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                uniqueChars.add(ch);
            }
        }
        return uniqueChars.size() == 26;
    }

}
