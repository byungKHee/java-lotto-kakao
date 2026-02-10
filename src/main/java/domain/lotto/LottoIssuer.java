package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private final LottoFactory lottoFactory;

    public LottoIssuer(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public LottoGroup issueAuto(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("로또 발행 수는 1개 이상이어야 합니다.");
        }

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(lottoFactory.createAutoLotto());
        }
        return new LottoGroup(lottoList);
    }
}
