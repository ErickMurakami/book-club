package club.quarkusclub.bookclub.effectivejava.chapter03.item10.nonnullity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Non-nullity: instanceof already rejects null")
class TicketTest {

    private final Ticket ticket = new Ticket("BOARDING-42");

    @Test
    @DisplayName("ticket.equals(null) is false, with no exception thrown")
    void equalsNullIsFalse() {
        assertThat(ticket.equals(null)).isFalse();
    }

    @Test
    @DisplayName("no exception is thrown when comparing against null - instanceof already handles it")
    void comparingWithNullNeverThrows() {
        assertThatCode(() -> ticket.equals(null)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("ticket.equals(an unrelated type) is also false, with no exception")
    void comparingWithUnrelatedTypeIsAlsoFalse() {
        assertThat(ticket.equals("BOARDING-42")).isFalse();
    }
}
