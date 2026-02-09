import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoList {

    private List<Lotto> lottoList = new ArrayList<>();
    private final int price;

    public LottoList(int price) {
        this.price = price;
        int lottoCount = getLottoCount(price);

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto());
        }
    }

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.price = lottoList.size() * Lotto.PRICE;
    }

    private int getLottoCount(int price) {
        if (price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
        return price / Lotto.PRICE;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getPrice() {
        return price;
    }
}