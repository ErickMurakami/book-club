package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import java.awt.Color;
import java.util.Objects;

/**
 * The way out: composition instead of inheritance. A {@code ColorPointComposition} is not a
 * {@link Point}, it has one, exposed through {@link #asPoint()}. With no subtyping relationship to
 * defend, {@code equals} can safely compare both fields without breaking any of the five clauses.
 */
public class ColorPointComposition {

    private final Point point;
    private final Color color;

    public ColorPointComposition(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ColorPointComposition other
                && other.point.equals(point)
                && other.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}
