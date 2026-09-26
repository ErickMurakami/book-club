package club.quarkusclub.bookclub.effectivejava.chapter03.item10.consistency;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import java.util.Objects;

/**
 * An immutable value: once built, its fields never change, so repeated calls to {@code equals}
 * against the same argument always agree. Consistency falls out of immutability for free - the
 * clause only gets interesting when a class reaches for state that is not under its own control
 * (see {@link FlakyPriceQuote}).
 */
public final class ReservationSnapshot {

    private final String confirmationCode;
    private final int totalCents;

    public ReservationSnapshot(String confirmationCode, int totalCents) {
        this.confirmationCode = Objects.requireNonNull(confirmationCode);
        this.totalCents = totalCents;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = o instanceof ReservationSnapshot other
                && other.confirmationCode.equals(confirmationCode)
                && other.totalCents == totalCents;
        Log.debugf(Messages.get("consistency.reservation.compare"), confirmationCode, result);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(confirmationCode, totalCents);
    }
}
