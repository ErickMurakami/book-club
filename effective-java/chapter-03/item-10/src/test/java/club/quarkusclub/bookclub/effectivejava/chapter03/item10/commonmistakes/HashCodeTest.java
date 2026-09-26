package club.quarkusclub.bookclub.effectivejava.chapter03.item10.commonmistakes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Common mistake: forgetting hashCode")
class HashCodeTest {

    @Nested
    @DisplayName("without hashCode, a HashSet does not recognize \"equal\"")
    class WithoutHashCode {

        @Test
        @DisplayName("equals says they are equal, but the HashSet does not find it")
        void equalsAgreesButHashSetDoesNotFind() {
            BrokenHashCode original = new BrokenHashCode("A1");
            BrokenHashCode equalButDifferentInstance = new BrokenHashCode("A1");

            assertThat(original).isEqualTo(equalButDifferentInstance);

            Set<BrokenHashCode> set = new HashSet<>();
            set.add(original);

            assertThat(set.contains(equalButDifferentInstance))
                    .as("same id, equals agrees, but they land in different buckets")
                    .isFalse();
        }
    }

    @Nested
    @DisplayName("with hashCode, the HashSet works as expected")
    class WithHashCode {

        @Test
        @DisplayName("equals agrees and the HashSet finds the equivalent entry")
        void equalsAndHashSetAgree() {
            FixedHashCode original = new FixedHashCode("A1");
            FixedHashCode equalButDifferentInstance = new FixedHashCode("A1");

            Set<FixedHashCode> set = new HashSet<>();
            set.add(original);

            assertThat(set.contains(equalButDifferentInstance)).isTrue();
        }
    }
}
