package domain.winning;

import domain.lotto.Lotto;
import domain.lotto.LottoGroup;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<WinningStatus, Integer> counts = new EnumMap<>(WinningStatus.class);

    public LottoResult(LottoGroup lottoGroup, WinningLotto winningLotto) {
        for (WinningStatus status : WinningStatus.values()) {
            counts.put(status, 0);
        }
        for (Lotto lotto : lottoGroup.getLottoList()) {
            WinningStatus status = winningLotto.compare(lotto);
            counts.put(status, counts.get(status) + 1);
        }
    }

    public Map<WinningStatus, Integer> getCounts() {
        return counts;
    }

    public long totalPrize() {
        long total = 0;
        for (WinningStatus status : WinningStatus.values()) {
            total += status.prize() * counts.get(status);
        }
        return total;
    }

    public double totalRate() {
        int totalCount = 0;
        for (Integer c : counts.values()) {
            totalCount += c;
        }

        if (totalCount == 0) {
            throw new IllegalStateException("구매한 로또가 없습니다.");
        }

        long paidMoney = (long) totalCount * Lotto.PRICE;
        return (double) totalPrize() / paidMoney;
    }
}