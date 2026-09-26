package club.quarkusclub.bookclub.effectivejava.chapter03.item10.symmetry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Symmetry: comparing only against its own type")
class CaseInsensitiveStringTest {

    private final CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    private final CaseInsensitiveString sameWordDifferentCase = new CaseInsensitiveString("polish");

    @Nested
    @DisplayName("given cis = \"Polish\" and s = \"polish\"")
    class GivenTwoCaseInsensitiveStrings {

        @Test
        @DisplayName("then cis.equals(s) is true")
        void cisEqualsS() {
            assertThat(cis.equals(sameWordDifferentCase)).isTrue();
        }

        @Test
        @DisplayName("and s.equals(cis) is also true - neither order breaks the contract")
        void sEqualsCis() {
            assertThat(sameWordDifferentCase.equals(cis)).isTrue();
        }
    }
}
