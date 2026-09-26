package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import java.awt.Color;

/**
 * Attempt C: requires an exact class match instead of {@code instanceof}. Among instances of this
 * exact class it is symmetric and transitive, but it does not fix the problem: {@link Point}
 * itself still uses {@code instanceof}, so a plain {@code Point} accepts this as equal while this
 * class refuses the {@code Point} back. That remaining asymmetry against its own superclass is the
 * Liskov substitution violation - a {@code ColorPointGetClass} can never be treated as the
 * {@code Point} it otherwise is.
 */
public class ColorPointGetClass extends Point {

    public final Color color;

    public ColorPointGetClass(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        ColorPointGetClass other = (ColorPointGetClass) o;
        return other.x == x && other.y == y;
    }
}
