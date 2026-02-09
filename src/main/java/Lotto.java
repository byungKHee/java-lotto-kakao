import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static final int PRICE = 1000;

    List<Number> numbers = new ArrayList<>();

    public Lotto() {
        List<Integer> shuffleNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            shuffleNumbers.add(i);
        }
        Collections.shuffle(shuffleNumbers);
        for (int i : shuffleNumbers.subList(0, 6)) {
            numbers.add(new Number(i));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
