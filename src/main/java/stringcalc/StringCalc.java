package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringCalc {

    public int add(String numbers) {
        String delimiter = "[,;\n]";
        String unformattedNumbers = numbers;
        if (numbers.isEmpty()){
            return 0;
        }

        if (numbers.startsWith("//")) {
            int index = numbers.indexOf("//") +2;
            delimiter = numbers.substring(index, index +1);
            unformattedNumbers = numbers.substring(numbers.indexOf("\n") + 1);
        } else {
            return differentDelimiter(unformattedNumbers, delimiter);
        }

        return differentDelimiter(unformattedNumbers, delimiter);
    }

    public int differentDelimiter(String numbers, String delimiter) {
        int total = 0;
        int numberToSave;
        List<Integer> lessThanZero = new ArrayList<>();
        String[] numberArray = numbers.split(delimiter);

        for (String number : numberArray) {
            numberToSave = Integer.parseInt(number);
            if (numberToSave < 0) {
                lessThanZero.add(numberToSave);
            }
            total += numberToSave;
        }

        if (lessThanZero.size()> 0) {
            throw new IllegalArgumentException("Negatives not allowed " + lessThanZero.toString());
        }
        return total;
    }
}
