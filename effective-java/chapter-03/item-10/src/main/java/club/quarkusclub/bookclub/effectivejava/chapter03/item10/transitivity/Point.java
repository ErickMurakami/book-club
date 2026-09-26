package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

/**
 * An instantiable, immutable two-dimensional point. Obeys the {@code equals} contract on its own;
 * the trouble starts once a subclass tries to add a value component (see {@code ColorPoint*}).
 */
public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point other
                && other.x == x
                && other.y == y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "Point(%d, %d)".formatted(x, y);
    }
}
