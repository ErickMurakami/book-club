package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Point alone obeys the contract")
class PointTest {

    @Test
    @DisplayName("x=y and y=z imply x=z for three equal Points")
    void transitivityHoldsForPlainPoints() {
        Point x = new Point(10, 10);
        Point y = new Point(10, 10);
        Point z = new Point(10, 10);

        assertThat(x).isEqualTo(y);
        assertThat(y).isEqualTo(z);
        assertThat(x).isEqualTo(z);
    }
}
