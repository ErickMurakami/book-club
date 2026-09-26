package club.quarkusclub.bookclub.effectivejava.chapter03.item10.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - The full recipe: PhoneNumber")
class PhoneNumberTest {

    @Nested
    @DisplayName("the five contract properties, written by hand")
    class TheContractByHand {

        private final PhoneNumber number = new PhoneNumber(11, 987, 6543);

        @Test
        @DisplayName("reflexive: equal to itself, and takes the == shortcut before comparing fields")
        void reflexive() {
            assertThat(number).isEqualTo(number);
        }

        @Test
        @DisplayName("symmetric and consistent: same numbers, called repeatedly, always true")
        void symmetricAndConsistent() {
            PhoneNumber sameNumber = new PhoneNumber(11, 987, 6543);

            for (int i = 0; i < 5; i++) {
                assertThat(number).isEqualTo(sameNumber);
                assertThat(sameNumber).isEqualTo(number);
            }
        }

        @Test
        @DisplayName("non-nullity: equals(null) is false, with no exception")
        void nonNullity() {
            assertThat(number.equals(null)).isFalse();
        }

        @Test
        @DisplayName("hashCode agrees with equals - required to work correctly as a map key")
        void hashCodeAgreesWithEquals() {
            PhoneNumber sameNumber = new PhoneNumber(11, 987, 6543);

            assertThat(number).hasSameHashCodeAs(sameNumber);
        }
    }

    @Test
    @DisplayName("the whole contract, verified automatically via EqualsVerifier")
    void fullContractViaEqualsVerifier() {
        EqualsVerifier.forClass(PhoneNumber.class).verify();
    }
}
