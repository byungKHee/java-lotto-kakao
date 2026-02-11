package controller;

import domain.lotto.LottoFactory;
import domain.lotto.LottoGroup;
import domain.winning.LottoResult;
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

    public void run() {
        int purchaseAmount = inputView.enterPurchaseAmount();
        LottoService lottoService = new LottoService(new LottoFactory());
        LottoGroup lottoGroup = lottoService.issueLottoGroup(purchaseAmount);
        outputView.printLottoCount(lottoGroup);

        List<Integer> winningNumbers = inputView.enterWinningNumbers();
        int bonus = inputView.enterBonusNumber();
        LottoResult lottoResult = lottoService.calculateResult(lottoGroup, winningNumbers, bonus);
        outputView.printStatistics(lottoResult);
    }
}
