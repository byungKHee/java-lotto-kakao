package domain.winning;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<Integer> input, int bonusNumber) {
        this.bonusLottoNumber = new LottoNumber(bonusNumber);
        for (int number : input) {
            lottoNumbers.add(new LottoNumber(number));
        }
        validateNumber();
    }

    private void validateNumber() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        lottoNumberSet.add(bonusLottoNumber);
        if (lottoNumberSet.size() != 7) {
            throw new IllegalArgumentException("당첨 번호에 중복이 있습니다.");
        }
    }

    public WinningStatus compare(Lotto lotto) {
        int count = 0;
        boolean containsBonus = lotto.getNumbers().contains(bonusLottoNumber);
        for (LottoNumber lottoNumber : lotto.getNumbers()) {
            if (lottoNumbers.contains(lottoNumber)) {
                count++;
            };
        }
        return WinningStatus.valueOf(count, containsBonus);
    }
}
