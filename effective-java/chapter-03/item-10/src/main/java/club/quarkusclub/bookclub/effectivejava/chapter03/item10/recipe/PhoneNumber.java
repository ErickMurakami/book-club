package club.quarkusclub.bookclub.effectivejava.chapter03.item10.recipe;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import java.util.Objects;

/**
 * The book's own recipe, step by step, each one logged so a live run narrates which clause fired:
 * <ol>
 *   <li>{@code ==} reference check, an optimization worth it only because a full comparison is
 *       three field reads;</li>
 *   <li>{@code instanceof}, doubling as the null check;</li>
 *   <li>the cast, safe because it is guarded by step 2;</li>
 *   <li>field-by-field comparison, primitives first with {@code ==}, cheapest / most likely to
 *       differ first.</li>
 * </ol>
 */
public final class PhoneNumber {

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNumber = rangeCheck(lineNumber, 9999, "line number");
    }

    private static short rangeCheck(int value, int max, String field) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(field + ": " + value);
        }
        return (short) value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            Log.debugf(Messages.get("recipe.phoneNumber.sameReference"), this);
            return true;
        }
        if (!(o instanceof PhoneNumber other)) {
            Log.debugf(Messages.get("recipe.phoneNumber.wrongTypeOrNull"), this, o);
            return false;
        }
        boolean result = other.lineNumber == lineNumber
                && other.prefix == prefix
                && other.areaCode == areaCode;
        Log.debugf(Messages.get("recipe.phoneNumber.fieldsCompared"), this, other, result);
        return result;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNumber);
        return result;
    }

    @Override
    public String toString() {
        return "(%03d) %03d-%04d".formatted(areaCode, prefix, lineNumber);
    }
}
