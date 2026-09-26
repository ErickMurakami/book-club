package club.quarkusclub.bookclub.effectivejava.chapter03.item10.commonmistakes;

import java.util.Objects;

/**
 * Same {@code equals} as {@link BrokenHashCode}, plus the {@code hashCode} override the contract
 * requires alongside it. Equal instances now land in the same bucket, so a {@code HashSet} finds
 * them as expected.
 */
public class FixedHashCode {

    private final String id;

    public FixedHashCode(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FixedHashCode other && other.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
