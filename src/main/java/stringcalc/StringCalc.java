package stringcalc;

public class StringCalc {

    public int add(String numbers) {
        int total = 0;
        if (numbers.isEmpty()){
            return 0;
        }
        String[] numberArray = numbers.split(",");

        for (String number:numberArray) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
