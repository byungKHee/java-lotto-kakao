import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoListTest {

    @Test
    @DisplayName("금액만큼 로또를 구입한다.")
    void buy() {
        String input = "14000";

        LottoList lottoList = new LottoList(Integer.parseInt(input));

        Assertions.assertEquals(14, lottoList.getLottoList().size());
    }

}
