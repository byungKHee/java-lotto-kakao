package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoIssuerTest {

    @DisplayName("자동 발행은 금액에 맞는 수량의 로또를 발행한다")
    @Test
    void issue_auto_lottos_by_price() {
        LottoIssuer lottoIssuer = new LottoIssuer(new LottoFactory());

        LottoGroup lottoGroup = lottoIssuer.issueAuto(3000);

        assertThat(lottoGroup.getSize()).isEqualTo(3);
    }

    @DisplayName("수동 발행은 전달된 번호 목록 수만큼 수동 로또를 발행한다")
    @Test
    void issue_manual_lottos_by_manual_numbers() {
        LottoIssuer lottoIssuer = new LottoIssuer(new LottoFactory());
        List<List<Integer>> manualNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)
        );

        LottoGroup lottoGroup = lottoIssuer.issueManual(manualNumbers);

        assertThat(lottoGroup.getSize()).isEqualTo(2);
    }

    @DisplayName("혼합 발행은 수동 수량을 제외한 나머지를 자동으로 발행한다")
    @Test
    void issue_mixed_lottos_with_manual_and_auto() {
        LottoIssuer lottoIssuer = new LottoIssuer(new LottoFactory());
        List<List<Integer>> manualNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12)
        );

        LottoGroup lottoGroup = lottoIssuer.issueMixed(5000, manualNumbers);

        assertThat(lottoGroup.getSize()).isEqualTo(5);
    }

    @DisplayName("자동 발행 시 금액이 0 이하이면 예외가 발생한다")
    @Test
    void issue_auto_lottos_with_negative_price() {
        LottoIssuer lottoIssuer = new LottoIssuer(new LottoFactory());

        assertThatThrownBy(() -> lottoIssuer.issueAuto(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동 발행 시 금액이 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void issue_auto_lottos_with_invalid_price() {
        LottoIssuer lottoIssuer = new LottoIssuer(new LottoFactory());

        assertThatThrownBy(() -> lottoIssuer.issueAuto(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
