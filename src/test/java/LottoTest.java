import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @Test
    @DisplayName("로또 한 개를 생성한다.")
    void name() {
        Lotto lotto = new Lotto();

        List<Number> numbers = lotto.getNumbers();

        assertEquals(6, new HashSet<>(numbers).size());
    }
}
