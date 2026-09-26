package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import java.awt.Color;

/**
 * Attempt A: only ever compares equal to another {@code ColorPointBrokenSymmetry}. A plain
 * {@link Point} at the same coordinates never matches back, which breaks symmetry the moment a
 * {@code Point} and a colored point are compared in either order.
 */
public class ColorPointBrokenSymmetry extends Point {

    public final Color color;

    public ColorPointBrokenSymmetry(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointBrokenSymmetry other)) {
            return false;
        }
        return super.equals(other) && other.color.equals(color);
    }
}
