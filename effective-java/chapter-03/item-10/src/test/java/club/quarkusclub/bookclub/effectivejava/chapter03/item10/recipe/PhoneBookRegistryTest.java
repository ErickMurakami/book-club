package club.quarkusclub.bookclub.effectivejava.chapter03.item10.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A {@code @QuarkusTest} instead of a plain unit test: it boots CDI and injects the real,
 * application-scoped bean, so the lookup below runs through the exact same {@link PhoneNumber}
 * instances a running Quarkus app would use as map keys - not a hand-rolled stand-in.
 */
@QuarkusTest
@DisplayName("Item 10 - The recipe in production: PhoneNumber as a CDI bean's map key")
class PhoneBookRegistryTest {

    @Inject
    PhoneBookRegistry registry;

    @Test
    @DisplayName("a lookup with a NEW but equal instance finds the entry")
    void lookupByAnEqualButDifferentInstanceFindsTheEntry() {
        registry.register(new PhoneNumber(11, 987, 6543), "Miles of Smiles support");

        var found = registry.lookup(new PhoneNumber(11, 987, 6543));

        assertThat(found).contains("Miles of Smiles support");
    }

    @Test
    @DisplayName("a lookup for a number that was never registered finds nothing")
    void lookupByAnUnregisteredNumberFindsNothing() {
        var found = registry.lookup(new PhoneNumber(21, 111, 2222));

        assertThat(found).isEmpty();
    }
}
