package club.quarkusclub.bookclub.effectivejava.chapter03.item10.commonmistakes;

/**
 * Overrides {@code equals} but not {@code hashCode} - a violation of the {@link Object#hashCode}
 * contract, which requires equal objects to have equal hash codes. Two instances that are
 * {@code equals} almost always land in different hash buckets, so a {@code HashSet} or
 * {@code HashMap} built from them behaves as if they were never equal at all.
 */
public class BrokenHashCode {

    private final String id;

    public BrokenHashCode(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BrokenHashCode other && other.id.equals(id);
    }
}
