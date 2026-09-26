package club.quarkusclub.bookclub.effectivejava.chapter03.item10.performance;

import static org.assertj.core.api.Assertions.assertThat;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.performance.Polygon.Vertex;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Performance: a derived field short-circuits the expensive comparison")
class PolygonTest {

    private static final List<Vertex> UNIT_SQUARE =
            List.of(new Vertex(0, 0), new Vertex(1, 0), new Vertex(1, 1), new Vertex(0, 1));
    private static final List<Vertex> LARGE_TRIANGLE =
            List.of(new Vertex(0, 0), new Vertex(10, 0), new Vertex(0, 10));

    @BeforeEach
    void resetCounter() {
        Polygon.vertexComparisons.set(0);
    }

    @Test
    @DisplayName("different areas: no vertex is ever compared")
    void differentAreasShortCircuitBeforeTouchingVertices() {
        Polygon square = new Polygon(UNIT_SQUARE);
        Polygon triangle = new Polygon(LARGE_TRIANGLE);

        assertThat(square.equals(triangle)).isFalse();
        assertThat(Polygon.vertexComparisons).as("vertex comparison never started").hasValue(0);
    }

    @Test
    @DisplayName("same area: only then are the vertices walked")
    void sameAreaFallsThroughToVertexComparison() {
        Polygon square = new Polygon(UNIT_SQUARE);
        Polygon sameSquareDifferentOrder = new Polygon(UNIT_SQUARE);

        assertThat(square.equals(sameSquareDifferentOrder)).isTrue();
        assertThat(Polygon.vertexComparisons.get()).as("had to compare all 4 vertices").isEqualTo(4);
    }
}
