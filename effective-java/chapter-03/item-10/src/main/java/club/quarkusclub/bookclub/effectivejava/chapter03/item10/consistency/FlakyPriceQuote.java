package club.quarkusclub.bookclub.effectivejava.chapter03.item10.consistency;

import club.quarkusclub.bookclub.effectivejava.chapter03.item10.support.Messages;
import io.quarkus.logging.Log;
import java.util.function.DoubleSupplier;

/**
 * Modeled after the book's {@code java.net.URL.equals} warning: comparing two objects should
 * never require reaching out to something that can change between calls, DNS resolution being the
 * book's own example. Here the "unreliable resource" is an injected {@link DoubleSupplier} instead
 * of a real network call, so the violation is demonstrated deterministically rather than through
 * an actually flaky test - see {@code FlakyPriceQuoteTest} for how the same pair of objects can
 * report equal on one call and not equal on the next, though neither one was mutated.
 */
public class FlakyPriceQuote {

    private final String route;
    private final DoubleSupplier livePriceLookup;

    public FlakyPriceQuote(String route, DoubleSupplier livePriceLookup) {
        this.route = route;
        this.livePriceLookup = livePriceLookup;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FlakyPriceQuote other) || !other.route.equals(route)) {
            return false;
        }
        boolean result = livePriceLookup.getAsDouble() == other.livePriceLookup.getAsDouble();
        Log.warnf(Messages.get("consistency.priceQuote.liveLookup"), route, result);
        return result;
    }
}
