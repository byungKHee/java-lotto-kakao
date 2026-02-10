package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private final LottoFactory lottoFactory;

    public LottoIssuer(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public LottoGroup issueAuto(int price) {
        int count = getCount(price);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(lottoFactory.createAutoLotto());
        }
        return new LottoGroup(lottoList);
    }

    public int getCount(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("로또 발행 수는 1개 이상이어야 합니다.");
        }
        if (price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("로또 발행 금액은 1000원 단위여야 합니다.");
        }
        return price / Lotto.PRICE;
    }
}
