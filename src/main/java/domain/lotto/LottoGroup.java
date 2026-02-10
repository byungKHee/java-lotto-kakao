package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {

    private List<Lotto> lottoList = new ArrayList<>();

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