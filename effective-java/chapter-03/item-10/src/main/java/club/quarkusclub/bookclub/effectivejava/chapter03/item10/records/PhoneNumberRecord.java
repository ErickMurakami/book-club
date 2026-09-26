package club.quarkusclub.bookclub.effectivejava.chapter03.item10.records;

/**
 * The same value as {@code recipe.PhoneNumber}, expressed as a record. The compiler generates
 * {@code equals}, {@code hashCode} and {@code toString} from the component list, and that
 * generated {@code equals} already satisfies the full five-clause contract - the same recipe from
 * this item, just written once by the language instead of by hand every time. {@code AutoValue}
 * (Google's alternative for pre-record Java) generates the same shape via annotation processing;
 * a record gets there with no dependency at all.
 */
public record PhoneNumberRecord(short areaCode, short prefix, short lineNumber) {

    public PhoneNumberRecord {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
    }

    private static void rangeCheck(short value, int max, String field) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(field + ": " + value);
        }
    }
}
