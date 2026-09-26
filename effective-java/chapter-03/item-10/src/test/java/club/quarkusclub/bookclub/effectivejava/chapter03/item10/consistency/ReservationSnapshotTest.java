package club.quarkusclub.bookclub.effectivejava.chapter03.item10.consistency;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Consistency: an immutable value never changes its mind")
class ReservationSnapshotTest {

    @Test
    @DisplayName("ten consecutive comparisons between the same two objects always return the same result")
    void repeatedComparisonsAlwaysAgree() {
        ReservationSnapshot a = new ReservationSnapshot("MOS-4471", 18900);
        ReservationSnapshot b = new ReservationSnapshot("MOS-4471", 18900);

        for (int i = 0; i < 10; i++) {
            assertThat(a).isEqualTo(b);
        }
    }
}
