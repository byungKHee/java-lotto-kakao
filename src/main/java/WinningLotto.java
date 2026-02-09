import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final List<Number> numbers = new ArrayList<>();
    private final Number bonusNumber;

    public WinningLotto(List<Integer> input, int bonusNumber) {
        this.bonusNumber = new Number(bonusNumber);
        for (int number : input) {
            numbers.add(new Number(number));
        }
        validateNumber();
    }

    private void validateNumber() {
        Set<Number> numberSet = new HashSet<>(numbers);
        numberSet.add(bonusNumber);
        if (numberSet.size() != 7) {
            throw new IllegalArgumentException("당첨 번호에 중복이 있습니다.");
        }
    }

    public WinningStatus compare(Lotto lotto) {
        int count = 0;
        boolean containsBonus = lotto.getNumbers().contains(bonusNumber);
        for (Number number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            };
        }
        return WinningStatus.valueOf(count, containsBonus);
    }
}
