package domain.winning;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<Integer> input, int bonusNumber) {
        List<LottoNumber> lottoNumbers = input.stream()
                .map(LottoNumber::new)
                .toList();
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusLottoNumber = new LottoNumber(bonusNumber);
        validateNumber();
    }

    private void validateNumber() {
        if (winningLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public WinningStatus compare(Lotto lotto) {
        int count = 0;
        // 보너스 번호 포함 여부 확인
        boolean containsBonus = lotto.getNumbers().contains(bonusLottoNumber);
        // 일치하는 번호 개수 세기
        Set<LottoNumber> winningNumbersSet = new HashSet<>(winningLotto.getNumbers());
        winningNumbersSet.retainAll(lotto.getNumbers());

        return WinningStatus.valueOf(winningNumbersSet.size(), containsBonus);
    }
}
