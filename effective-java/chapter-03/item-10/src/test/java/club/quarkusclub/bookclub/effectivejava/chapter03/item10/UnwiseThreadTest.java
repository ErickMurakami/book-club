package club.quarkusclub.bookclub.effectivejava.chapter03.item10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Before anything else: should you even override equals?")
class UnwiseThreadTest {

    @Test
    @DisplayName("two distinct threads become \"equal\" - Thread is an active entity, not a value")
    void twoDifferentThreadsBecomeEqual() {
        UnwiseThread a = new UnwiseThread();
        UnwiseThread b = new UnwiseThread();

        assertThat(a).isNotSameAs(b);
        assertThat(a.equals(b)).as("should never be true for two distinct threads").isTrue();
    }
}
