package club.quarkusclub.bookclub.effectivejava.chapter03.item10.nonnullity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Non-nullity violated: casting before checking the type")
class TicketUnsafeCastTest {

    private final TicketUnsafeCast ticket = new TicketUnsafeCast("BOARDING-42");

    @Test
    @DisplayName("equals(null) throws NullPointerException instead of returning false")
    void equalsNullThrowsInsteadOfReturningFalse() {
        assertThatThrownBy(() -> ticket.equals(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("equals(wrong type) throws ClassCastException instead of returning false")
    void equalsWrongTypeThrowsInsteadOfReturningFalse() {
        assertThatThrownBy(() -> ticket.equals("BOARDING-42")).isInstanceOf(ClassCastException.class);
    }
}
