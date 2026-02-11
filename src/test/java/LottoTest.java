import domain.lotto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    @DisplayName("자동 로또 하나를 생성한다.")
    void create_auto_lotto() {
        Random random = new Random(10);
        LottoFactory autoLottoFactory = new LottoFactory(random);
        Lotto lotto = autoLottoFactory.createAutoLotto();
        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        assertEquals(6, new HashSet<>(lottoNumbers).size());
    }

    @Test
    @DisplayName("수동 로또 하나를 생성한다.")
    void create_manual_lotto() {
        LottoFactory manualLottoFactory = new LottoFactory();
        Lotto lotto = manualLottoFactory.createManualLotto(List.of(1, 11, 15, 29, 35, 45));
        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        assertEquals(6, new HashSet<>(lottoNumbers).size());
    }

    @Test
    @DisplayName("로또 생성 시 1~45 범위를 벗어나면 예외가 발생한다.")
    void create_lotto_out_of_range() {
        LottoFactory manualLottoFactory = new LottoFactory();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manualLottoFactory.createManualLotto(
                        List.of(0, 11, 15, 29, 35, 46)
                )
        );
    }

    @Test
    @DisplayName("로또 생성 시 중복된 번호가 있으면 예외가 발생한다.")
    void create_lotto_with_duplicates() {
        LottoFactory manualLottoFactory = new LottoFactory();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manualLottoFactory.createManualLotto(
                        List.of(1, 11, 15, 29, 35, 35)
                )
        );
    }

    @Test
    @DisplayName("자동 로또 여러 개를 생성한다")
    void create_auto_lottos() {
        Random random = new Random(10);
        LottoFactory lottoFactory = new LottoFactory(random);

        LottoIssuer lottoIssuer = new LottoIssuer(lottoFactory);
        LottoGroup lottoGroup = lottoIssuer.issueAuto(5000);

        for (Lotto lotto : lottoGroup.getLottoList()) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            assertEquals(6, new HashSet<>(lottoNumbers).size());
        }
        assertEquals(5, lottoGroup.getLottoList().size());
    }

}
