import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호를 생성한다.")
    void winning() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(input, bonusNumber);
        Assertions.assertNotNull(winningLotto);
    }
}
