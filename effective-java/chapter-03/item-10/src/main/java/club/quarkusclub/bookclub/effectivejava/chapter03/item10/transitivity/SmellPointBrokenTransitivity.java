package club.quarkusclub.bookclub.effectivejava.chapter03.item10.transitivity;

/**
 * A second sibling of {@link Point}, built with the exact same "ignore the value component in
 * mixed comparisons" trick as {@link ColorPointBrokenTransitivity}. On its own it looks harmless;
 * paired with another sibling that delegates the same way, {@code equals} recurses forever - see
 * {@code ColorPointBrokenTransitivityTest#crossSiblingComparisonOverflows()}.
 */
public class SmellPointBrokenTransitivity extends Point {

    public final String smell;

    public SmellPointBrokenTransitivity(int x, int y, String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        if (!(o instanceof SmellPointBrokenTransitivity)) {
            return o.equals(this);
        }
        SmellPointBrokenTransitivity other = (SmellPointBrokenTransitivity) o;
        return super.equals(other) && other.smell.equals(smell);
    }
}
