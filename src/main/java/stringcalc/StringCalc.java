package stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalc {

    public int add(String numbers) {
        StringBuilder defaultRegex = new StringBuilder("\\n,");
        StringBuilder fixed = new StringBuilder();
        List<Integer> lessThanZero = new ArrayList<>();
        if (numbers.startsWith("//")) {
            defaultRegex.append(numbers, numbers.indexOf("//"),
                    numbers.indexOf("\n"));
            fixed.append(numbers.substring(numbers.indexOf("\n")).trim());
        } else {
            fixed.append(numbers);
        }
        String[] split = fixed.toString().split("[" + defaultRegex + "]");
        Arrays.stream(split)
                .map(String::strip)
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .forEach(lessThanZero::add);
        if (lessThanZero.size() > 0) {
            throw new IllegalArgumentException("Negatives not allowed " + lessThanZero.toString());
        }

        return Arrays.stream(split)
                .map(String::strip)
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 1001 && num > 0)
                .sum();
    }
}
