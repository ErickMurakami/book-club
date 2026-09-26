package club.quarkusclub.bookclub.effectivejava.chapter03.item10.symmetry;

import java.util.Objects;

/**
 * The bug is the content: this class tries to also compare equal to a plain {@link String}.
 * {@code String.equals} has no idea this type exists, so {@code cis.equals(s)} and
 * {@code s.equals(cis)} disagree - a textbook symmetry violation. Do not "fix" this class.
 */
public class CaseInsensitiveViolation {

    private final String value;

    public CaseInsensitiveViolation(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveViolation other) {
            return value.equalsIgnoreCase(other.value);
        }
        if (o instanceof String other) {
            return value.equalsIgnoreCase(other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }
}
