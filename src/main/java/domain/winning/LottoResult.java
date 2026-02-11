package domain.winning;

import domain.lotto.Lotto;
import domain.lotto.LottoGroup;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<WinningStatus, Integer> counts;

    public LottoResult(Map<WinningStatus, Integer> counts) {
        this.counts = new EnumMap<>(counts);
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