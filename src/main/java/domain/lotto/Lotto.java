package domain.lotto;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        for (int i : numbers) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
    }

    private void validateLotto(List<Integer> numbers){
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

}
