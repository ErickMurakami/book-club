package club.quarkusclub.bookclub.effectivejava.chapter03.item10.records;

import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Item 10 - A modern alternative: equals for free with records")
class PhoneNumberRecordTest {

    @Test
    @DisplayName("two instances with the same components are equal, with no equals method written")
    void generatedEqualsWorks() {
        PhoneNumberRecord a = new PhoneNumberRecord((short) 11, (short) 987, (short) 6543);
        PhoneNumberRecord b = new PhoneNumberRecord((short) 11, (short) 987, (short) 6543);

        assertThat(a).isEqualTo(b);
        assertThat(a).hasSameHashCodeAs(b);
    }

    @Test
    @DisplayName("the same EqualsVerifier used on PhoneNumber also approves the record")
    void fullContractViaEqualsVerifier() {
        EqualsVerifier.forClass(PhoneNumberRecord.class).verify();
    }
}
