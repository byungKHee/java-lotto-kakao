import java.util.ArrayList;
import java.util.List;

public class LottoList {

    List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int price) {
        int lottoCount = getLottoCount(price);

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto());
        }
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
}