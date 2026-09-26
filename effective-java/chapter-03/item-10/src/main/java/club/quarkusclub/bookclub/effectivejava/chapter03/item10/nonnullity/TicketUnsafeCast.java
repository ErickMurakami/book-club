package club.quarkusclub.bookclub.effectivejava.chapter03.item10.nonnullity;

/**
 * Skips the type check the recipe asks for and casts straight away. A {@code null} argument casts
 * fine (casting {@code null} to any reference type is legal) but then throws
 * {@link NullPointerException} the moment a field is read off it; an argument of the wrong type
 * throws {@link ClassCastException} instead. Both violate the equals contract, which demands
 * {@code false}, never an exception.
 */
public class TicketUnsafeCast {

    private final String code;

    public TicketUnsafeCast(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        TicketUnsafeCast other = (TicketUnsafeCast) o;
        return other.code.equals(code);
    }
}
