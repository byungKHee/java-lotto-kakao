import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final List<Integer> winningCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
    private final int rate;

    public LottoResult(LottoList lottoList, WinningLotto winningLotto) {
        for (Lotto lotto : lottoList.getLottoList()) {
            WinningStatus winningStatus = winningLotto.compare(lotto);
            winningCount.set(winningStatus.ordinal(), winningCount.get(winningStatus.ordinal()) + 1);
        }
        //rate

    }

    public double getWinningRate() {


        return 0;
    }
}
