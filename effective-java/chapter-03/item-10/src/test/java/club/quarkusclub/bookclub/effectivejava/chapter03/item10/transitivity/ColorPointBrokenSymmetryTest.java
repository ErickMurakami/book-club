package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Attempt A: compares only against its own type")
class ColorPointBrokenSymmetryTest {

    @Test
    @DisplayName("p.equals(cp) is true, but cp.equals(p) is false - symmetry broken")
    void symmetryIsBroken() {
        Point p = new Point(1, 2);
        ColorPointBrokenSymmetry cp = new ColorPointBrokenSymmetry(1, 2, Color.RED);

        assertThat(p.equals(cp)).as("Point has no idea ColorPoint exists, falls through to Point.equals").isTrue();
        assertThat(cp.equals(p)).as("ColorPoint requires its own type, p is not a ColorPoint").isFalse();
    }
}
