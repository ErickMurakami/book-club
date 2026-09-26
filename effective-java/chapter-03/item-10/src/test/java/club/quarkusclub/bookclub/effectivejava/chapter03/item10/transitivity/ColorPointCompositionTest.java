package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - The way out: composition instead of inheritance")
class ColorPointCompositionTest {

    @Test
    @DisplayName("two ColorPointComposition with the same position and color are equal")
    void equalWhenPositionAndColorMatch() {
        ColorPointComposition a = new ColorPointComposition(1, 2, Color.RED);
        ColorPointComposition b = new ColorPointComposition(1, 2, Color.RED);

        assertThat(a).isEqualTo(b);
        assertThat(a).hasSameHashCodeAs(b);
    }

    @Test
    @DisplayName("asPoint() exposes the same coordinates as a plain Point, without pretending to be one")
    void asPointExposesTheUnderlyingPosition() {
        ColorPointComposition colorPoint = new ColorPointComposition(1, 2, Color.RED);

        assertThat(colorPoint.asPoint()).isEqualTo(new Point(1, 2));
    }
}
