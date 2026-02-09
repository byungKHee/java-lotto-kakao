import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoResultTest {
    @Test
    void result() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));
        LottoList lottoList = new LottoList(lottos);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult lottoResult = new LottoResult(lottoList, winningLotto);

        Assertions.assertEquals(10001.66, lottoResult.getWinningRate());
    }
}
