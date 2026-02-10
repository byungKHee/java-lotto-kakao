import controller.LottoController;
import domain.lotto.LottoFactory;
import domain.lotto.LottoIssuer;
import service.LottoService;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new view.InputView(),
                new OutputView()
        );
        lottoController.run();
    }
}
