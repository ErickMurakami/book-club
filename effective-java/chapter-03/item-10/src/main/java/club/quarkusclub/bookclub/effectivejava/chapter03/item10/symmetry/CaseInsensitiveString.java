package club.quarkusclub.bookclub.effectivejava.chapter03.item10.symmetry;

import java.util.Objects;

/**
 * Compares only against its own type: two case-insensitive strings agree on equality no matter
 * which side calls {@code equals}, so this satisfies symmetry.
 */
public class CaseInsensitiveString {

    private final String value;

    public CaseInsensitiveString(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString other
                && other.value.equalsIgnoreCase(value);
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
