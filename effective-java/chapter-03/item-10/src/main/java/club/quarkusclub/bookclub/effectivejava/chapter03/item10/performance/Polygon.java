package club.quarkusclub.bookclub.effectivejava.chapter03.item10.performance;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Field order and derived fields, in one example. {@code area} is a derived field: a summary of
 * the whole shape, cached at construction time instead of recomputed on every comparison.
 * Comparing it first means two polygons with different areas never pay for a vertex-by-vertex
 * comparison at all - the expensive check only runs once the cheap one has already agreed.
 * <p>
 * {@link #vertexComparisons} is a demo-only counter (not something a real equals would carry) so a
 * test - or a live run - can show the short-circuit actually firing, not just claim it does.
 */
public final class Polygon {

    public static final AtomicInteger vertexComparisons = new AtomicInteger();

    private final List<Vertex> vertices;
    private final double area;

    public Polygon(List<Vertex> vertices) {
        this.vertices = List.copyOf(vertices);
        this.area = shoelaceArea(this.vertices);
    }

    private static double shoelaceArea(List<Vertex> v) {
        double sum = 0;
        for (int i = 0; i < v.size(); i++) {
            Vertex a = v.get(i);
            Vertex b = v.get((i + 1) % v.size());
            sum += a.x() * b.y() - b.x() * a.y();
        }
        return Math.abs(sum) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Polygon other)) {
            return false;
        }
        if (Double.compare(area, other.area) != 0) {
            Log.debugf(Messages.get("performance.polygon.areaShortCircuit"), area, other.area);
            return false;
        }
        for (int i = 0; i < vertices.size(); i++) {
            vertexComparisons.incrementAndGet();
            if (i >= other.vertices.size() || !vertices.get(i).equals(other.vertices.get(i))) {
                return false;
            }
        }
        return vertices.size() == other.vertices.size();
    }

    @Override
    public int hashCode() {
        return Double.hashCode(area);
    }

    public record Vertex(double x, double y) {
    }
}
