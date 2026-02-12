package controller;

import domain.lotto.LottoFactory;
import domain.lotto.LottoGroup;
import domain.winning.LottoResult;
import domain.winning.WinningLotto;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run_step1() {
        int purchaseAmount = inputView.enterPurchaseAmount();
        LottoService lottoService = new LottoService(new LottoFactory());
        LottoGroup lottoGroup = lottoService.issueAutoLottoGroup(purchaseAmount);
        outputView.printLottoCount(lottoGroup);

        List<Integer> winningNumbers = inputView.enterWinningNumbers();
        int bonus = inputView.enterBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        LottoResult lottoResult = lottoService.calculateResult(lottoGroup, winningLotto);
        outputView.printStatistics(lottoResult);
    }

    public void run_step2() {
        int purchaseAmount = inputView.enterPurchaseAmount();
        int manualCount = inputView.enterManualPurchaseCount();
        List<List<Integer>> manualNumbers = inputView.enterManualLottos(manualCount);

        LottoService lottoService = new LottoService(new LottoFactory());
        LottoGroup lottoGroup = lottoService.issueMixedLottoGroup(purchaseAmount, manualNumbers);
        outputView.printLottoCount(lottoGroup);

        List<Integer> winningNumbers = inputView.enterWinningNumbers();
        int bonus = inputView.enterBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        LottoResult lottoResult = lottoService.calculateResult(lottoGroup, winningLotto);
        outputView.printStatistics(lottoResult);
    }
}
