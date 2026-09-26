package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.awt.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Attempt B: ignores color in mixed comparisons")
class ColorPointBrokenTransitivityTest {

    @Test
    @DisplayName("symmetric now, but p1=p2 and p2=p3 do not imply p1=p3")
    void theClassicCounterexample() {
        ColorPointBrokenTransitivity p1 = new ColorPointBrokenTransitivity(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPointBrokenTransitivity p3 = new ColorPointBrokenTransitivity(1, 2, Color.BLUE);

        assertThat(p1.equals(p2)).as("p2 is not a ColorPoint, color is ignored").isTrue();
        assertThat(p2.equals(p3)).as("same reason, color is ignored").isTrue();
        assertThat(p1.equals(p3)).as("both are ColorPoint, colors differ - transitivity broken").isFalse();
    }

    @Test
    @DisplayName("two siblings that delegate to each other overflow the stack")
    void crossSiblingComparisonOverflows() {
        ColorPointBrokenTransitivity colorPoint = new ColorPointBrokenTransitivity(1, 2, Color.RED);
        SmellPointBrokenTransitivity smellPoint = new SmellPointBrokenTransitivity(1, 2, "lavender");

        assertThatThrownBy(() -> colorPoint.equals(smellPoint))
                .as("each equals() delegates to the other side, with no base case")
                .isInstanceOf(StackOverflowError.class);
    }
}
