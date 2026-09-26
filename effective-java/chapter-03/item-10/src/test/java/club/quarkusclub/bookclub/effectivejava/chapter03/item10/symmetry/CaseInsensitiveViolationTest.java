package club.quarkusclub.bookclub.effectivejava.chapter03.item10.symmetry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - Symmetry violated: comparing against String")
class CaseInsensitiveViolationTest {

    private final String s = "polish";
    private final CaseInsensitiveViolation cis = new CaseInsensitiveViolation("Polish");

    @Test
    @DisplayName("cis.equals(s) is true - CaseInsensitiveViolation knows about String")
    void cisKnowsAboutString() {
        assertThat(cis.equals(s)).isTrue();
    }

    @Test
    @DisplayName("but s.equals(cis) is false - String has no idea this type exists")
    void stringHasNoIdeaAboutCis() {
        assertThat(s.equals(cis)).isFalse();
    }

    @Test
    @DisplayName("practical consequence: list.contains(s) is undefined, here it returns false")
    void collectionsBehaveUnpredictably() {
        List<CaseInsensitiveViolation> collection = new ArrayList<>();
        collection.add(cis);

        assertThat(collection.contains(s)).isFalse();
    }
}
