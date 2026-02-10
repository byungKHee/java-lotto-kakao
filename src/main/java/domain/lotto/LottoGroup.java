package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private final List<Lotto> lottoList;

    public LottoGroup(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getSize() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}