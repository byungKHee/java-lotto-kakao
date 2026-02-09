import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    List<Number> numbers = new ArrayList<>();

    public Lotto() {
        List<Integer> shuffleNumbers = new ArrayList<>();
        for (int i = Number.MIN_NUMBER; i <= Number.MAX_NUMBER; i++) {
            shuffleNumbers.add(i);
        }
        Collections.shuffle(shuffleNumbers);
        for (int i : shuffleNumbers.subList(0, 6)) {
            numbers.add(new Number(i));
        }
    }

    public Lotto(List<Integer> numbers) {
        for (int i : numbers) {
            this.numbers.add(new Number(i));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
