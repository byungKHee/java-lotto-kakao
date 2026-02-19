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
            lottoList.add(lottoFactory.create(new AutoLottoGenerator()));
        }
        return new LottoGroup(lottoList);
    }

    public LottoGroup issueManual(List<List<Integer>> manualNumbers) {
        List<Lotto> lottoList = new ArrayList<>();
        for (List<Integer> numbers : manualNumbers) {
            lottoList.add(lottoFactory.create(new ManualLottoGenerator(numbers)));
        }
        return new LottoGroup(lottoList);
    }

    public LottoGroup issueMixed(int totalPrice, List<List<Integer>> manualNumbers) {
        if (manualNumbers == null) {
            throw new IllegalArgumentException("수동 번호 목록은 null일 수 없습니다.");
        }
        int autoCount = getCount(totalPrice) - manualNumbers.size();
        List<Lotto> lottoList = new ArrayList<>();
        for (List<Integer> numbers : manualNumbers) {
            lottoList.add(lottoFactory.create(new ManualLottoGenerator(numbers)));
        }
        for (int i = 0; i < autoCount; i++) {
            lottoList.add(lottoFactory.create(new AutoLottoGenerator()));
        }
        return new LottoGroup(lottoList);
    }

    private int getCount(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("로또 발행 수는 1개 이상이어야 합니다.");
        }
        if (price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("로또 발행 금액은 1000원 단위여야 합니다.");
        }
        return price / Lotto.PRICE;
    }
}
