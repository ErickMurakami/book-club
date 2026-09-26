package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

import java.awt.Color;

/**
 * Attempt B: fixes symmetry by ignoring color in "mixed" comparisons (delegating to the other
 * side when it is a plain {@link Point}), but pays for it with transitivity. Two color-blind
 * comparisons can each report equal while the two colored points differ from each other.
 */
public class ColorPointBrokenTransitivity extends Point {

    public final Color color;

    public ColorPointBrokenTransitivity(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        if (!(o instanceof ColorPointBrokenTransitivity)) {
            return o.equals(this);
        }
        ColorPointBrokenTransitivity other = (ColorPointBrokenTransitivity) o;
        return super.equals(other) && other.color.equals(color);
    }
}
