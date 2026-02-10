package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoFactory {

    private final Random random;

    public LottoFactory() {
        this.random = new Random();
    }

    public LottoFactory(Random random) {
        this.random = random;
    }

    public Lotto createAutoLotto() {
        List<Integer> shuffleNumbers = new ArrayList<>();
        for (int i = Lotto.MIN_NUMBER; i <= Lotto.MAX_NUMBER; i++) {
            shuffleNumbers.add(i);
        }
        Collections.shuffle(shuffleNumbers, random);
        List<Integer> numbers = new ArrayList<>(shuffleNumbers.subList(0, Lotto.LOTTO_SIZE));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public Lotto createManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
