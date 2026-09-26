package club.quarkusclub.bookclub.effectivejava.chapter03.item10.reflexivity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Reflexivity: x.equals(x) must be true")
class PlayerTest {

    @Test
    @DisplayName("a Player is equal to itself, even without overriding equals")
    void aPlayerIsEqualToItself() {
        Player skywalker = new Player("skywalker");

        assertThat(skywalker).isEqualTo(skywalker);
    }
}
