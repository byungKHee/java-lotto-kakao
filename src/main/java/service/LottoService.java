package service;

import domain.lotto.LottoFactory;
import domain.lotto.LottoGroup;
import domain.lotto.LottoIssuer;
import domain.winning.LottoResult;
import domain.winning.WinningLotto;

import java.util.List;

public class LottoService {

    private final LottoIssuer lottoIssuer;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoIssuer = new LottoIssuer(lottoFactory);
    }

    public LottoGroup issueLottoGroup(int purchaseAmount) {
        return lottoIssuer.issueAuto(purchaseAmount);
    }

    public LottoResult calculateResult(LottoGroup lottoGroup, List<Integer> winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return lottoGroup.compare(winningLotto);
    }
}
