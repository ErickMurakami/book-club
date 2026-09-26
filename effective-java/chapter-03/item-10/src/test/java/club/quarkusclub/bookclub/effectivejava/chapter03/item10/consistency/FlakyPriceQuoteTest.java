package club.quarkusclub.bookclub.effectivejava.chapter03.item10.consistency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Consistency violated: equals depends on a live lookup")
class FlakyPriceQuoteTest {

    @Test
    @DisplayName("the same two instances disagree from one call to the next, though neither one changed")
    void sameTwoInstancesDisagreeAcrossCalls() {
        Deque<Double> pricesSeenByA = new ArrayDeque<>(List.of(100.0, 100.0));
        Deque<Double> pricesSeenByB = new ArrayDeque<>(List.of(100.0, 105.0));

        FlakyPriceQuote a = new FlakyPriceQuote("GRU-JFK", pricesSeenByA::poll);
        FlakyPriceQuote b = new FlakyPriceQuote("GRU-JFK", pricesSeenByB::poll);

        boolean firstComparison = a.equals(b);
        boolean secondComparison = a.equals(b);

        assertThat(firstComparison).as("on the first call the live prices happen to match").isTrue();
        assertThat(secondComparison)
                .as("on the second call the price moved behind the scenes - same objects, different verdict")
                .isFalse();
    }
}
